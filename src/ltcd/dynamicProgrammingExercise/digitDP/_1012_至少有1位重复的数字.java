package ltcd.dynamicProgrammingExercise.digitDP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _1012_至少有1位重复的数字 {

    public static void main(String[] args) {
        _1012_至少有1位重复的数字 v = new _1012_至少有1位重复的数字();
        System.out.println(v.numDupDigitsAtMostN(1000));
    }

    int[][] memo;
    char[] chars;
    public int numDupDigitsAtMostN(int n) {
        int[] preDigits = new int[10];
        chars = (n + "").toCharArray();
        memo = new int[chars.length][1024];
        for (int i = 0; i < chars.length; i++) {
            Arrays.fill(memo[i], -1);
        }

        // n - 不包含重复数字的数量
        return n - f(0, 0, true, false);
    }

    /**
     * 统计 [1 - n] 中没有重数字的个数
     * @param i 数位从高到低，第几位
     * @param mask 大小为1024，长度为10，记录 0-9 的选择情况，若 i 已选择，则 mask 中第 i 位为 1
     * @param isLimit i 位之前的数字是否和 n 的对应数位相等
     * @param isNum i 位之前的数字是否全都是 0，没有构成数字
     * @return
     */
    private int f(int i, int mask, boolean isLimit, boolean isNum) {
        // 数位长度和 n 的长度相等了，则判断所有数位是不是都选择了 0 ——不构成数字 isNum = false
        // 如果前面的数位都写 0，而最后一位写的是0，则表示数字0——构成数字0，且 0 不含重复数字isNum = 1
        if (i == chars.length) {
            return isNum ? 1 : 0;
        }

        if (!isLimit && memo[i][mask] != -1) {
            return memo[i][mask];
        }

        int count = 0;
        // 可以跳过当前数位，不选
        if (!isNum) {
            count = f(i + 1, mask, false, false);
        }

        int down = isNum ? 0 : 1;
        int up = isLimit ? chars[i] - '0' : 9;
        for (int d = down; d <= up; d++) {
            // 如果数字 d 没有被选择过
            if (((mask >> d) & 1) == 0) {
                count += f(i + 1, mask | (1 << d), (isLimit && d == up), true);
            }
        }

        if (!isLimit && isNum) {
            memo[i][mask] = count;
        }

        return count;
    }

}
