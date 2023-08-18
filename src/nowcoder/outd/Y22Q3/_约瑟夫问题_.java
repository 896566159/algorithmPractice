package nowcoder.outd.Y22Q3;

import java.util.*;

/**
 * 输入一个由随机数组成的数列（数列中每个数均是大于 0 的整数，长度已知），和初始计数值 m。
 * 从数列首位置开始计数，计数到 m 后，将数列该位置数值替换计数值 m，
 * 并将数列该位置数值出列，然后从下一位置从新开始计数，直到数列所有数值出列为止。
 * 如果计数到达数列尾段，则返回数列首位置继续计数。
 * 请编程实现上述计数过程，同时输出数值出列的顺序。
 *
 * 比如：输入的随机数列为：3,1,2,4，初始计数值 m=7，从数列首位置开始计数（数值 3 所在位置）
 * 第一轮计数出列数字为 2，计数值更新 m=2，出列后数列为 3,1,4，从数值 4 所在位置从新开始计数
 * 第二轮计数出列数字为 3，计数值更新 m=3，出列后数列为 1,4，从数值 1 所在位置开始计数
 * 第三轮计数出列数字为 1，计数值更新 m=1，出列后数列为 4，从数值 4 所在位置开始计数
 * 最后一轮计数出列数字为 4，计数过程完成。输出数值出列顺序为：2,3,1,4。
 *
 *
 * 输入：
 * 	3,1,2,4
 * 	4
 * 	7
 * 输出：
 * 	2,3,1,4
 * 说明:
 * 	第一行是初始数列intput array
 * 	第二行是初始数列的长度len第三行是初始计数值m
 * 	数值出列顺序：2,3,1,4
 *
 * 示例：
 * 	输入：
 * 		3,1,2,4,5,8,7,4
 * 		8
 * 		1
 * 	输出：
 * 		3,4,4,8,5,1,2,7
 * 示例：
 * 	输入：
 * 		1,2,3,4,5,6,7,8,9,10
 * 		10
 * 		10
 * 	输出：
 * 		10,1,2,4,8,5,6,3,7,9
 */
public class _约瑟夫问题_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(",");
        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        int m2 = m;
        List<Integer> arr = new ArrayList<>();

        Node head = null;
        Node pre = null;
        for (int i = 0; i < n; i++) {
            Node cur = new Node();
            int value = Integer.parseInt(split[i]);
            cur.value = value;
            arr.add(value);

            if (i == 0) {
                head = cur;
                pre = cur;
            } else {
                pre.next = cur;
                pre = cur;
            }
        }
        // 尾巴指向头结点，形成环
        pre.next = head;
        List<Integer> res = new ArrayList<>();

        int count = n;
        while (count > 1) {
            int index = m % count - 1;
            Node p = head;
            if (index == -1) {
                // 要删除的是尾巴
                while (p.next.next != head) {
                    p = p.next;
                }
            } else if (index == 0) {
                // 要删除的是头
                while (p.next != head) {
                    p = p.next;
                }
            } else {
                while (index > 1) {
                    p = p.next;
                    index--;
                }
            }
            // 删除
            Node next = p.next;
            m = next.value;
            res.add(m);
            p.next = p.next.next;
            next = null;

            head = p.next;
            count--;
        }

        res.add(head.value);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i));
            if (i != res.size() - 1) {
                System.out.print(",");
            }
        }

        // 使用队列来模拟
        System.out.println("\n使用队列来模拟结果：");
        method(arr, m2);
    }

    private static void method(List<Integer> arr, int m) {
        List<Integer> res = new ArrayList<>();


        while (!arr.isEmpty()) {
            int currentIndex = m % arr.size() - 1;

            if (currentIndex == -1) {
                // 要删除的是尾巴
                m = arr.remove(arr.size() - 1);
            } else if (currentIndex == 0) {
                // 要删除的是头
                m = arr.remove(0);
            } else {
                List<Integer> tmp = new ArrayList<>();
                while (currentIndex-- > 0) {
                    tmp.add(arr.remove(0));
                }
                m = arr.remove(0);
                arr.addAll(tmp);
            }
            res.add(m);
        }

        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i));
            if (i != res.size() - 1) {
                System.out.print(",");
            }
        }
    }

    static class Node {
        int value;
        Node next;
    }

}






