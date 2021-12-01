package ltcd.dynamicProgrammingExercise;

public class _198_打家劫舍 {

    public int rob(int[] nums) {
        int N = nums.length;
        if (N == 0) {
            return 0;
        }

        int[] dp = new int[N + 1];
        //case base
        dp[0] = 0;//rob 0 house just get 0$
        dp[1] = nums[0];//rob one house, can get the first house money
        /**
         * if rob n houses, can rob the n-ed house or don't rob the n-ed house(n houses: the index from 0 to n - 1)
         *      if rob n-ed house, will get rob the max profit of rob (n - 1) house + nums[n]
         *      if don't rob n-ed house, will get the max profit of rob (n) houses
         * f(n) = max{ f(n - 2) + nums[n],  f(n - 1)}
         */
        for (int i = 2; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }

        return dp[N];
    }

    public static void main(String[] args) {
        _198_打家劫舍 v = new _198_打家劫舍();
        System.out.println(v.rob(new int[]{1,2,3,1}));
    }

}
