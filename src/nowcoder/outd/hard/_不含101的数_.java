package nowcoder.outd.hard;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 小明在学习二进制时，发现了一类不含 101的数，也就是：
 * 将数字用二进制表示，不能出现 101 。
 * 现在给定一个整数区间 [l,r] ，请问这个区间包含了多少个不含 101 的数
 *
 * 输入描述
 * 	输入的唯一一行包含两个正整数 l， r（ 1 ≤ l ≤ r ≤ 10^9）。
 *
 * 输出描述
 * 	输出的唯一一行包含一个整数，表示在 [l,r] 区间内一共有几个不含 101 的数。
 *
 * 样例1：
 * 	输入:
 * 		1 10
 * 	输出:
 * 		8
 * 说明:
 * 	区间 [1,10] 内，
 * 	5 的二进制表示为 101 ，
 * 	10的二进制表示为 1010 ，
 * 	因此区间 [ 1 , 10 ] 内有 10−2=8 个不含 101的数。
 *
 * 示例2：
 * 	输入:
 * 		10 20
 * 	输出:
 * 		7
 * 说明：
 * 	区间 [10,20] 内，
 * 	满足条件的数字有 [12,14,15,16,17,18,19]
 * 	因此答案为 7。
 */
public class _不含101的数_ {

    // 该方法存在一些问题
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int left = scanner.nextInt();
        int right = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        long count = 0;
        System.out.println("dp结果 --------" + (dp(right)-dp(left-1)));
        _不含101的数_ v = new _不含101的数_();
        System.out.println("我的dp结果 --------" + (v.myDp(right) - v.myDp(left-1)));
        long sum = right - left + 1;

        // 求left的二进制
        int tmp = left - 1;
        while (tmp != 0) {
            sb.append(tmp % 2);
            tmp /= 2;
        }

        // 记录 101 的在二进制字符串中的下标
        int indexOf = sb.toString().indexOf("101");
        int pre = indexOf == -1 ? Integer.MAX_VALUE : indexOf;
        while (left <= right) {
            int oldLen = sb.length();
            int index = oldLen - 1;

            // 从右往左找到第一个 0
            while (index >= 0 && sb.charAt(index) != '0') {
                index--;
            }

            // 0 的右边的所有 1 替换成 0
            if (index < 0) {
                // sb中全是1，则说明二进制的位数需要增加一位才能表示：左边第一位为 1，其余都是 0
                pre = pre == sb.length() - 1 ? sb.length() : pre;
                sb.append('1');
                index = 0;
            } else {
                // 100 --> 101
                if (index - 2 >= 0 && sb.charAt(index - 2) == '1' && sb.charAt(index - 1) == '0') {
                    count++;
                    // 更新 pre
                    pre = Math.min(pre, index);
                } else {
                    // 在 index 的左边存在 101
                    if (pre != Integer.MAX_VALUE && pre < index) {
                        count++;
                    }
                    if (index < pre) {
                        pre = sb.length();
                    }
                }
            }

            // 从右往左找到第一个 0 后，把这个 0 改成 1，把 0 的右边的 1 全部改成 0
            sb.setCharAt(index++, '1');
            while (index < sb.length()) {
                sb.setCharAt(index, '0');
                index++;
            }

            left++;
        }

        System.out.println("我的------" + (sum - count));
    }


    // 自己实现
    char[] chars;
    int[][][] memo;
    public int myDp(int num) {
        chars = Integer.toBinaryString(num).toCharArray();
        memo = new int[chars.length][2][2];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        return f(0, 0, 0, true);
    }

    private int f(int i, int pre, int prepre, boolean isLimit) {
        // 如果能够成功的填写出长度和 num 一样的二进制数，说明该路径解可行
        if (i == chars.length) {
            return 1;
        }

        if (!isLimit && memo[i][pre][prepre] != -1) {
            return memo[i][pre][prepre];
        }

        int res = 0;
        int up = isLimit ? chars[i] - '0' : 1;
        for (int d = 0; d <= up; d++) {
            if (!(d == 1 && pre == 0 && prepre == 1)) {
                res += f(i + 1, d, pre, isLimit && d == up);
            }
        }

        if (!isLimit) {
            memo[i][pre][prepre] = res;
        }

        return res;
    }


    // 博客上的实现
    public static int dp(int num) {
        // 10 -> [1,0,1,0,0]
        String number_str=Integer.toBinaryString(num);
        Integer[] single_binary_nums = new Integer[number_str.length()];
        for (int i=0;i<number_str.length();i++) {
            single_binary_nums[i] = Integer.parseInt(number_str.charAt(i)+"");
        }

        int[][][] binary_dp = new int[single_binary_nums.length][2][2];

        return search(0, true, binary_dp, single_binary_nums, 0, 0);
    }

    public static int search(int p, boolean flag, int[][][] binary_dp, Integer[] single_binary_nums, int pre, int prepre) {
        if (p == single_binary_nums.length) {
            return 1;
        }

        if (!flag && binary_dp[p][pre][prepre] != 0) {
            return binary_dp[p][pre][prepre];
        }

        int index = flag ? single_binary_nums[p] : 1;
        int count = 0;

        for (int i = 0; i < index+1; i++) {
            if (i == 1 && pre == 0 && prepre == 1) {
                continue;
            }
            count += search(p + 1, flag && i == index, binary_dp, single_binary_nums, i, pre);
        }

        if (!flag) {
            binary_dp[p][pre][prepre] = count;
        }

        return count;
    }
}
