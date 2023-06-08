package ltcd.dynamicProgrammingExercise.digitDP;

import java.util.Arrays;

public class _902_最大为N的数字组合 {

    public static void main(String[] args) {
        _902_最大为N的数字组合 v = new _902_最大为N的数字组合();
        System.out.println(v.atMostNGivenDigitSet(new String[]{"1", "3", "5", "7"}, 100));
        System.out.println(v.atMostNGivenDigitSet(new String[]{"1","4","9"}, 1000000000));
    }

    char[] chars;
    int[] memo;
    char[] digits;
    public int atMostNGivenDigitSet(String[] digits, int n) {
        // 数字转成字符数组
        chars = Integer.toString(n).toCharArray();
        // 字符串数组转成字符数组
        this.digits = new char[digits.length];
        for (int i = 0; i < digits.length; i++) {
            this.digits[i] = digits[i].charAt(0);
        }

        memo = new int[chars.length];
        // dp[i] = -1 表示 i 这个状态还没被计算出来
        Arrays.fill(memo, -1);

        return f(0, true, false);
    }

    private int f(int i, boolean isLimit, boolean isNum) {
        // 如果填了数字，则为 1 种合法方案
        if (i == chars.length) {
            return isNum ? 1 : 0;
        }

        // 在不受到任何约束的情况下，返回记录的结果，避免重复运算
        if (!isLimit && memo[i] != -1) {
            return memo[i];
        }

        int res = 0;
        if (!isNum) {
            // 前面不填数字，那么可以跳过当前数位，也不填数字
            // isLimit 改为 false，因为没有填数字，位数都比 n 要短，自然不会受到 n 的约束
            // isNum 仍然为 false，因为没有填任何数字
            res = f(i + 1, false, false);
        }

        // 根据是否受到约束，决定可以填的数字的上限
        int up = isLimit ? chars[i] : '9';
        // 注意：对于一般的题目而言，如果此时 isNum 为 false，则必须从 1 开始枚举，由于本题 digits 没有 0，所以无需处理这种情况
        for (char digit : digits) {
            // 可以进行选择，约束选择的范围不能超过上限
            if (digit <= up) {
                res += f(i + 1, isLimit && digit == up, true);
            }
        }

        // 在不受到任何约束的情况下，记录结果
        if (!isLimit && isNum) {
            memo[i] = res;
        }

        return res;
    }

}
