package ltcd.dynamicProgrammingExercise;

import java.util.HashSet;
import java.util.Set;

public class _剑指_Offer_II_103_最少的硬币数目 {

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 1) {
            return -1;
        }

        int[] dp = new int[amount + 1];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < coins.length; i++) {
            set.add(coins[i]);
        }

        for (int i = 0; i < dp.length; i++) {
            dp[i] = set.contains(i) ? 1 : i;
        }

//        for (int i = 0; i < dp.length; i++) {
//            dp[]
//        }

        return dp[amount];
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
