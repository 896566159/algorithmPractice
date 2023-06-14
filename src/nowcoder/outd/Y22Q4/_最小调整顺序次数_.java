package nowcoder.outd.Y22Q4;

import java.util.Scanner;

/**
 * 有一个特异性的双端队列，该队列可以从头部或尾部添加数据，但是只能从头部移出数据。
 * 输入一个数字n，会依次添加数字 1~n（也就是添加n次）。
 * 但是在添加数据的过程中，也会删除数据，要求删除必须按照 1~n 顺序进行删除，所以在删除时，可以根据需要调整队列中数字的顺序以满足删除条件。
 * 输入描述：
 * 第一行一个数据N，表示数据的范围。
 * 接下来的 2N 行是添加和删除语句。其中：head add x 表示从头部添加元素 x，tail add 表示从尾部添加元素，remove表示删除元素。
 * 输出描述：
 * 	输出一个数字，表示最小的调整顺序次数。
 *
 * 示例：
 * 	输入：
 * 		5
 * 		head add 1
 * 		tail add 2
 * 		remove
 * 		head add 3
 * 		tail add 4
 * 		head add 5
 * 		remove
 * 		remove
 * 		remove
 * 		remove
 * 	输出：
 * 		1
 *
 * 说明：
 * 第1步：[1]
 * 第2步：[1,2]
 * 第3步：头部删除1，无需调整，还剩[2]
 * 第4步：[3,2]
 * 第5步：[3,2,4]
 * 第6步：[5,3,2,4]
 * 第7步：头部删除2，调整顺序再删除，还剩[3，4，5]
 * 第8步：头部删除3，无需调整，还剩[4，5]
 * 第9步：头部删除4，无需调整，还剩[5]
 * 第10步：头部删除5，无需调整
 * 只需要调整1次
 */
public class _最小调整顺序次数_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        // 标记链表的长度
        int size = 0;
        // 标记链表中的元素是否有序
        boolean flag = true;
        // 调整次数
        int count = 0;

        for (int i = 0; i < 2 * n; i++) {
            String s = scanner.nextLine();
            String[] split = s.split(" ");

            if (split[0].equals("remove")) {
                // 删除
                if (!flag && size > 0) {
                    // 链表调整一次后恢复有序
                    count++;
                    flag = true;
                }
                size--;
            } else if (split[0].equals("head")) {
                // 添加到头部， 当链表中有数据，使用头插法后，会导致链表中的数据无序
                if (size > 0) {
                    flag = false;
                }
                size++;
            } else {
                // 添加到尾部
                size++;
            }
        }

        System.out.println(count);
    }

}
