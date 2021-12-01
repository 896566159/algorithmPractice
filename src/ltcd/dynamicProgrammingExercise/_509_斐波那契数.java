package ltcd.dynamicProgrammingExercise;

public class _509_斐波那契数 {

    public int fib(int n) {
        //DP table
        int[] dp = new int[n + 1];

        //base case
        dp[0] = 0;
        dp[1] = 1;

        //state transition equation
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i + 2];
        }

        return dp[n];
    }


    public int fib1(int n) {
        int[] nums = new int[n + 1];
        return help(n, nums);
    }

    private int help(int n, int[] nums) {
        //base case
        if (n == 1 || n == 2) {
            return 0;
        }

        if (nums[n] != 0) {
            return nums[n];
        }

        nums[n] = help(n - 1, nums) + help(n - 2, nums);

        return nums[n];
    }


}
