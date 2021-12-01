package ltcd.dynamicProgrammingExercise;

public class _70_爬楼梯 {

    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        int first = 1;
        int second = 2;
        int ans = 0;

        for (int i = 3; i < n + 1; i++) {
            ans = first + second;
            first = second;
            second = ans;
        }

        return ans;
    }

}
