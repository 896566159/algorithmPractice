package ltcd.dynamicProgrammingExercise.digitDP;

import java.util.Arrays;

public class _233_数字1的个数 {

    public static void main(String[] args) {
        _233_数字1的个数 v = new _233_数字1的个数();
        System.out.println(v.countDigitOne(50));
    }

    int[][] memo;
    char[] chars;
    public int countDigitOne(int n) {
        chars = Integer.toString(n).toCharArray();

        // 根据题目给出的范围，一个数中 1 的数量最多只有 10 种情况
        memo = new int[chars.length][10];
        for (int i = 0; i < chars.length; i++) {
            Arrays.fill(memo[i], -1);
        }

        return f(0, 0, true);
    }

    private int f(int index, int oneCnt, boolean isLimit) {
        // 填写数字结束
        if (index == chars.length) {
            return oneCnt;
        }
        // 没有限制 且 该状态结果已经计算出，则直接返回
        if (!isLimit && memo[index][oneCnt] != -1) {
            return memo[index][oneCnt];
        }

        int count = 0;
        int up = isLimit ? chars[index] - '0' : 9;
        for (int d = 0; d <= up; d++) {
            count += f(index + 1, oneCnt + (d == 4? 1 : 0), (isLimit && d == up));
        }

        // 记忆化：记录该状态的结果
        if (!isLimit) {
            memo[index][oneCnt] = count;
        }

        return count;
    }

}
