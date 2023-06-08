package ltcd.dynamicProgrammingExercise;

import java.util.Arrays;

public class _剑指_OfferII_119_最长连续序列 {

    public static void main(String[] args) {
        System.out.println(new _剑指_OfferII_119_最长连续序列().longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }

    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int max = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                dp[i] = dp[i - 1];
            } else if (nums[i - 1] + 1 == nums[i]) {
                dp[i] = dp[i - 1] + 1;
                max = Math.max(max, dp[i]);
            } else {
                dp[i] = 1;
            }
        }

        return max;
    }

}
