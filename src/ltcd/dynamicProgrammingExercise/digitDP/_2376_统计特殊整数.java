package ltcd.dynamicProgrammingExercise.digitDP;

import java.util.Arrays;

public class _2376_统计特殊整数 {

    public static void main(String[] args) {
        _2376_统计特殊整数 v = new _2376_统计特殊整数();
        System.out.println(v.countSpecialNumbers(5));
        System.out.println(v.countSpecialNumbers(135));
    }

    int[][] memo;
    char[] chars;
    public int countSpecialNumbers(int n) {
        chars = Integer.toString(n).toCharArray();
        memo = new int[chars.length][1024];
        for (int i = 0; i < chars.length; i++) {
            Arrays.fill(memo[i], -1);
        }

        return f(0, 0, true, false);
    }

    private int f(int i, int mask, boolean isLimit, boolean isNum) {
        if (i == chars.length) {
            return isNum ? 1 : 0;
        }

        if (!isLimit && memo[i][mask] != -1) {
            return memo[i][mask];
        }

        int res = 0;
        // 可以跳过当前位不选
        if (!isNum) {
            res = f(i + 1, mask, false, false);
        }

        int down = isNum ? 0 : 1;
        int up = isLimit ? chars[i] - '0' : 9;
        for (int d = down; d <= up; d++) {
            // 如果数字 d 没有被选择过
            if (((mask >> d) & 1) == 0) {
                res += f(i + 1, mask | (1 << d), (isLimit && d == up), true);
            }
        }

        if (!isLimit && isNum) {
            memo[i][mask] = res;
        }

        return res;
    }

}
