package nowcoder.outd.Y22Q3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给出数字K，请输出所有小于 K 的整数组合到一起的最小交换次数。
 * 组合一起是指满足条件的数字相邻，不要求相邻后在数组中的位置。
 *
 * 取值范围：
 * 	-100 <= K <= 100
 * 	-100 <= 数组中的数值 <= 100
 *
 * 输入描述：
 * 	第一行输入数组：1 3 1 4 0
 * 	第二行输入K数值：2
 * 输出描述：
 * 	第一行输出的最少交换次数：1
 *
 * 思路：
 * 	1、数出一共有多少个小于 k 的
 *  2、使用滑动窗口，以 小于k 的总数为窗口大小
 *  3、计算窗口内 大于k 的个数，最少的即为需要交换的次数
 */
public class _最少交换次数_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = Integer.parseInt(scanner.nextLine());
        int count = 0;

        // 统计小于 K 的数有多少个
        for (int element : array) {
            if (element < k) {
                count++;
            }
        }

        // 开一个长度为 count 的窗口，该窗口中小于 k 的数量最多时，交换次数最少
        int left = 0;
        int right = 0;
        int windows = 0;
        while (right < array.length && right < count) {
            if (array[right] < k) {
                windows++;
            }
            right++;
        }

        int max = windows;
        while (right < array.length) {
            if (array[left] < k) {
                windows--;
            }
            if (array[right] < k) {
                windows++;
            }
            right++;
            left++;
            max = Math.max(max, windows);
        }

        // 需要把窗口中的大于 k 的和串口外小于 k 的元素交换
        System.out.println(count - max);
    }

}
