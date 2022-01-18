package ltcd.dynamicProgrammingExercise;

public class _剑指_Offer_II_020_回文子字符串的个数 {

    public int countSubstrings(String s) {
        if (s.length() == 1) {
            return 1;
        }

        int[] dp = new int[s.length() + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 1; i <= s.length(); i++) {
            int count = 1;
            for (int j = 0; j < i; j++) {
                if (isHuiWen(j, i, s) && j < s.length()) {
                    count++;
                }
            }

            dp[i] = dp[i - 1] + count;
        }

        return dp[s.length() - 1];
    }

    private boolean isHuiWen(int j, int i, String s) {
        if (i >= s.length()) {
            return false;
        }

        while (j < i) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i--;
            j++;
        }

        return true;
    }

    public static void main(String[] args) {
        new _剑指_Offer_II_020_回文子字符串的个数().countSubstrings("abc");
    }

}
