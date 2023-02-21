package ltcd.dynamicProgrammingExercise;

import java.util.Arrays;

public class _剑指_Offer_60_n个骰子的点数 {

    public static void main(String[] args) {
        new _剑指_Offer_60_n个骰子的点数().dicesProbability(2);
    }

    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);

        //骰子从数量从2开始
        for (int i = 2; i <= n; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp;
        }

        return dp;
    }

}
