package nowcoder.outd.Y23Q2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定一个非空数组(列表)
 * 元素数据类型为整型
 * 请按照数组元素十进制最低位从小到大进行排序
 * 十进制最低位相同的元素，相对位置保持不变
 * 当数组元素为负值时，十进制最低为等同于去除符号位后对应十进制值最低位
 *
 * 输入描述：
 * 	给定一个非空数组(列表)
 * 	其元素数据类型为32位有符号整数
 * 	数组长度为[1,1000]
 * 输出描述：
 * 	排序后的数组
 *
 * 示例1：
 * 输入：
 * 	1,2,5,-21,22,11,55,-101,42,8,7,32
 * 输出：
 * 	1,-21,11,-101,2,22,42,32,5,55,7,8
 */
public class 数字最低位排序 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int n = array.length;
        int[][] help = new int[n][2];

        for (int i = 0; i < n; i++) {
            help[i][0] = Math.abs(array[i] % 10);
            help[i][1] = array[i];
        }

        Arrays.sort(help, (a, b)->a[0] - b[0]);
        System.out.print(help[0][1]);
        for (int i = 1; i < n; i++) {
            System.out.print("," + help[i][1]);
        }
    }
    
}
