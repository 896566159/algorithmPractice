package nowcoder.outd.Y22Q4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 某生产门电路的厂商发现某一批次的或门电路不稳定，具体现象为计算两个二进制数的或操作时，第一个二进制数中某两个比特位会出现交换，
 * 交换的比特位置是随机的，但只交换这两个位，其他位不变。
 * 很明显，这个交换可能会影响最终的或结果，也可能不会有影响。
 * 为了评估影响和定位出错的根因，工程师需要研究在各种交换的可能下，最终的或结果发生改变的情况有多少种。
 * 输入描述:
 * 	第一行有一个正整数 N;其中 1 ≤ N ≤ 1000000。
 * 	第二行有一个长为 N 的二进制数，表示与电路的第一个输入数，即会发生比特交换的输入数。
 * 	第三行有一个长为 N 的二进制数，表示与电路的第二个输入数。注意第二个输入数不会发生比特交换。
 * 输出描述:
 * 	输出只有一个整数，表示会影响或结果的交换方案个数。
 *
 * 示例1：
 * 	输入：
 * 		3
 * 		010
 * 		110
 * 	输出：
 * 		1
 * 说明：
 * 	原本010和110的或结果是110，但第一个输入数可能会发生如下三种交换：
 * 	1.交换第 1 个比特和第 2 个比特，第一个输入数变为 100，计算结果为 110，计算结果不变
 * 	2.交换第 1 个比特和第 3 个比特，第一个输入数变为 010，计算结果为 110，计算结果不变
 * 	3.交换第 2 个比特和第 3 个比特，第一个输入数变为 001，计算结果为 111，计算结果改变
 * 	故只有一种交换会改变计算结果。
 */
public class _出错的或电路_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[] num1 = scanner.nextLine().toCharArray();
        char[] num2 = scanner.nextLine().toCharArray();
        // 统计 num2 中 “1” 对应 num1 上的 “0”，“1” 统计
        int[] num2IsOne = new int[2];
        // num1 中的 “1”、“0”的个数前缀和： 统计 num1 中 i 位置之前的、且对应 num2 位上非 “1” 的 “1” 的个数
        int[][] preOneSum = new int[n + 1][2];
        int ans = 0;

        // 求解 num1 中的 1 的个数前缀和
        int countOne = 0;
        int countZore = 0;
        for (int i = 0; i < n; i++) {
            int index = num1[i] == '0' ? 0 : 1;

            if (num2[i] == '1') {
                // 统计 num2 中 “1” 对应 num1 上的 “0”，“1” 统计
                num2IsOne[index]++;
            } else {
                if (index == 0) {
                    countZore++;
                } else {
                    countOne++;
                }
                preOneSum[i][0] = countZore;
                preOneSum[i][1] = countOne;
            }
        }

        // 位运算 或 操作：0 | 0 = 0， 0 | 1 = 1， 1 | 0 = 1, 1 | 1 = 1
        // 或运算只要其中一个是 1，结果就是1
        // 思路：只有 num2 中的为 “0” 时，num1中的 0 和 1 交换才会导致结果变化
        for (int i = 0; i < n; i++) {
            if (num1[i] == '0' && num2[i] == '0') {
                // 原本该位置都是 0，0 | 0 = 0，如果 num1 和 其他非 0 位交换，则该处的结果 变成 0 | 1 = 1
                // 更新答案 = num1 中 “1” 的个数 - i位置之前的 ”1“ 的个数
                ans += num2IsOne[1] + countOne;
                ans -= preOneSum[i][1];
            } else if (num1[i] == '1' && num2[i] == '0') {
                // 原本该位置都是 1，1 | 0 = 1，如果 num1 和 其他 0 位交换，则该处的结果 变成 0 | 0 = 0
                // 更新答案 = num1 中 “0” 的个数 - i位置之前的 “0” 的个数
                ans += n - (num2IsOne[1] + countOne);
                ans -= preOneSum[i][0];
            }
//            else if (num1[i] == '0' && num2[i] == '1') {
//                // 原本该位置都是 0，0 | 1 = 1，num1 交换后结果不会变
//            } else {
//                // 原本该位置都是 1，1 | 1 = 1，num1 交换后结果不会变
//            }
        }

        System.out.println(ans);


        //网上的答案
        otherMethod(n, num1, num2);
    }

    private static void otherMethod(int n, char[] input_str1, char[] input_str2) {
        List<Integer> c = new ArrayList<Integer>();
        int[] cnt = new int[2];
        for (int i = 0; i< n; i++) {
            if (input_str2[i] == '0') {
                c.add(Integer.parseInt (String.valueOf (input_str1[i])));
            }
            if (input_str1[i] == '0') {
                cnt[0] += 1;
            } else {
                cnt[1] += 1;
            }
        }
        //System.out.println(c);

        int total = 0;

        for (int i=0;i<c.size();i++) {
            total += cnt[c.get(i) ^ 1];
            cnt[c.get(i)] -= 1;
        }

        System.out.println(total);
    }


}
