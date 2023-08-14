package nowcoder.outd.Y23Q3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 有 N 个正整数组成的一个序列。
 * 给定整数 sum，求长度最长的连续子序列，使他们的和等于 sum，返回此子序列的长度，
 * 如果没有满足要求的序列，返回-1。
 * 输入描述：
 * 	第一行输入是：N个正整数组成的一个序列
 * 	第二行输入是：给定整数sum
 * 输出描述：
 * 	最长的连续子序列的长度
 * 备注：
 * 	输入序列仅由数字和英文逗号构成，数字之间采用英文逗号分隔
 * 	序列长度：1 <= N <= 200
 * 	输入序列不考虑异常情况
 *
 * 示例1：
 * 	输入：
 * 		1,2,3,4,2
 * 		6
 * 	输出：
 * 		3
 * 说明：
 * 	1,2,3和4,2两个序列均能满足要求，所以最长的连续序列为1,2,3，因此结果为3
 *
 * 示例2：
 * 	输入：
 * 		1,2,3,4,2
 * 		20
 * 	输出：
 * 		-1
 * 说明：
 * 	解释：没有满足要求的子序列，返回-1
 */
public class _最长连续子序列_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int target = Integer.parseInt(scanner.nextLine());
        int left = 0;
        int right = 0;
        int sum = 0;
        int n = array.length;
        int max = -1;

        while (right < n) {
            sum += array[right];

            if (sum == target) {
                max = Math.max(max, right - left + 1);
                while (sum >= target && left < right) {
                    sum -= array[left++];
                }
            }
            right++;
        }

        System.out.println(max);
    }

}
