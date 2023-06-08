package ltcd.dynamicProgrammingExercise.digitDP;

import java.util.Arrays;

public class _600_不含连续1的非负整数 {

    int memo[][];
    char[] chars;
    int res = 0;
    public int findIntegers(int n) {
        chars = Integer.toBinaryString(n).toCharArray();
        memo = new int[chars.length][2];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }

        return f(0, 0, true);
    }

    // prev 表示第 i - 1 位的数字。即前一个数字
    private int f(int i, int prev, boolean isLimit) {
        // 结束条件：到达此处的路径均为可行解，直接返回 1
        if (i == chars.length) {
            return 1;
        }

        if (!isLimit && memo[i][prev] != -1) {
            return memo[i][prev];
        }

        int res = 0;
        int up = isLimit ? chars[i] - '0' : 1;
        for (int d = 0; d <= up; d++) {
            // 如果 prev == 1 && d == 1 表示出现连续的两个 1, 直接跳过
            if (!(prev == 1 && d == 1)) {
                res += f(i + 1, d, isLimit && d == up);
            }
        }

        if (!isLimit) {
            memo[i][prev] = res;
        }

        return res;
    }

}
