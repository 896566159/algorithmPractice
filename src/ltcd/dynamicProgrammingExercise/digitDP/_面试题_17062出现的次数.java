package ltcd.dynamicProgrammingExercise.digitDP;

import java.util.Arrays;

public class _面试题_17062出现的次数 {

    int[][] memo;
    char[] chars;
    public int numberOf2sInRange(int n) {
        chars = Integer.toString(n).toCharArray();

        // 记忆化搜索
        memo = new int[chars.length][10];
        for (int i = 0; i < chars.length; i++) {
            Arrays.fill(memo[i], -1);
        }

        return f(0, 0, true);
    }

    /**
     * 计算出从 index 位开始，2 出现的次数
     * @param index 从左往右第 index 位
     * @param cntTwo 从左往右前面 index-1 位中包含的 2 的数量
     * @param isLimit 前面 index - 1 位的每一位置上是否和 n 的每一位都相同
     * @return 从 index 位开始，2 出现的次数
     */
    private int f(int index, int cntTwo, boolean isLimit) {
        // 填写的数字长度已经和 n 的长度相同，在列举就会 > n 了，所以直接返回
        if (index == chars.length) {
            return cntTwo;
        }
        // 前面的数位和 n 的每一位都不同 并且 已经有过搜索记录
        if (!isLimit && memo[index][cntTwo] != -1) {
            return memo[index][cntTwo];
        }

        int count = 0;
        // index 位置上能填写的数字上限
        int up = isLimit ? chars[index] - '0' : 9;
        // 从 0 开始枚举填写在此处的数字
        for (int d = 0; d <= up; d++) {
            count += f(index + 1, cntTwo + (d == 2 ? 1 : 0), isLimit && d == up);
        }

        // 前面的数位和 n 的每一位都不同
        if (!isLimit) {
            memo[index][cntTwo] = count;
        }

        return count;
    }

}
