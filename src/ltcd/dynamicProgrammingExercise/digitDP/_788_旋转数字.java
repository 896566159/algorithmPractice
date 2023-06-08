package ltcd.dynamicProgrammingExercise.digitDP;

import java.util.Arrays;

public class _788_旋转数字 {

    public static void main(String[] args) {
        _788_旋转数字 v = new _788_旋转数字();
        System.out.println(v.rotatedDigits(10));
    }

    // ISDIFF[i] == -1 表示 i 不能旋转，如：3，4，7
    // ISDIFF[i] == 0 表示 i 旋转后为同一个数字，如：0，1，8
    // ISDIFF[i] == 1 表示 i 旋转后为不同的数字，如：2，5，6，9
    private int[] ISDIFF = new int[]{0, 0, 1, -1, -1, 1, 1, -1, 0, 1};
    int[][] memo;
    char[] chars;
    public int rotatedDigits(int n) {
        chars = Integer.toString(n).toCharArray();
        // 每次选择 0~9
        memo = new int[chars.length][2];
        for (int i = 0; i < chars.length; i++) {
            Arrays.fill(memo[i], -1);
        }

        return f(0, 0, true);
    }

    private int f(int i, int hasDiff, boolean isLimit) {
        // 终止条件: 到达此处的路径根据 hasDiff 判断是否为可行解，直接返回 hasDiff 即可
        if (i == chars.length) {
            return hasDiff;
        }

        if (!isLimit && memo[i][hasDiff] != -1) {
            return memo[i][hasDiff];
        }

        int up = isLimit ? chars[i] - '0' : 9;
        int res = 0;
        for (int d = 0; d <= up; d++) {
            // -1 表示存在不能旋转的数字：3, 4, 7，直接跳过
            if (ISDIFF[d] != -1) {
                // 如果 ISDIFF[d] = 1，则表示旋转后为不同数字，hasDiff | ISDIFF[d] 或运算后值为 1
                res += f(i + 1, hasDiff | ISDIFF[d], isLimit && d == up);
            }
        }

        if (!isLimit) {
            memo[i][hasDiff] = res;
        }

        return res;
    }

}
