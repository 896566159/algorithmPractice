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
 */
public class _最少交换次数_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    }

}
