package nowcoder.outd.Y22Q4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * A、B两个人把苹果分为两堆，
 * A希望按照他的计算规则等分苹果，他的计算规则是按照二进制加法计算，并且不计算进位 12+5=9（1100 + 0101 = 9），
 * B的计算规则是十进制加法，包括正常进位，B希望在满足A的情况下获取苹果重量最多。
 *
 * 输入苹果的数量和每个苹果重量，输出满足A的情况下B获取的苹果总重量。
 * 如果无法满足A的要求，输出-1。
 *
 * 数据范围：
 * 	1 <= 总苹果数量 <= 20000
 * 	1 <= 每个苹果重量 <= 10000
 *
 * 输入描述：
 * 	输入第一行是苹果数量：3
 * 	输入第二行是每个苹果重量：3 5 6
 * 输出描述：
 * 	输出第一行是B获取的苹果总重量：11
 *
 * 示例1：
 * 	输入：
 * 		3
 * 		3 5 6
 * 	输出：
 * 		11
 * 示例2：
 * 	输入：
 * 		8
 * 		7258 6579 2602 6716 3050 3564 5396 1773
 * 	输出：
 * 		35165
 */
public class _分苹果_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine());
            int[] weights = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int aw = 0;
            int bw = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                // 不进位的二进制加法，即同于做异或操作
                aw ^= weights[i];
                bw += weights[i];
                min = Math.min(weights[i], min);
            }

            if (aw == 0) {
                System.out.println(bw - min);
            } else {
                System.out.println(-1);
            }
        }
    }

}
