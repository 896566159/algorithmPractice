package ltcd.dynamicProgrammingExercise;

public class _剑指_Offer_II_092_翻转字符 {

    public int minFlipsMonoIncr(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = 0;
        int count1 = 0;

        for (int i = 1; i <= length; i++) {
            if (chars[i - 1] == '0') {
                dp[i] = Math.min(count1, dp[i - 1] + 1);
            } else {
                dp[i] = dp[i - 1];
                count1++;
            }
        }

        return dp[length];
    }

}
