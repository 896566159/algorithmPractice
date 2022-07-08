package ltcd.dynamicProgrammingExercise;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _剑指_Offer_II_103_最少的硬币数目 {

    public static void main(String[] args) {
        System.out.println(new _剑指_Offer_II_103_最少的硬币数目().coinChange(new int[]{186,419,83,408}, 6249));
    }

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }

        if (amount == 0) return 0;

        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {

            if (i == 2856) {
                System.out.println();
            }

            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] == i) {
                    dp[i] = 1;
                    break;
                } else if (coins[j] > i) {
                    continue;
                } else if (dp[i - coins[j]] != 0){
                    min = Math.min(min, dp[i - coins[j]] + 1);
                }
            }

            if (Integer.MAX_VALUE != min && dp[i] != 1) dp[i] = min;
        }

        return dp[amount] == 0 ? -1 : dp[amount];
    }

//    超时
//    int count = 0;
//
//    public int coinChange(int[] coins, int amount) {
//        help(coins, amount, 0);
//        return count;
//    }
//
//    private void help(int[] coins, int amount, int sum) {
//        if (amount < 0) {
//            return;
//        }
//
//        if (amount == 0) {
//            count = Math.min(sum, count);
//        }
//
//        for (int i = 0; i < coins.length; i++) {
//            help(coins, amount - coins[i], sum);
//        }
//    }

}
