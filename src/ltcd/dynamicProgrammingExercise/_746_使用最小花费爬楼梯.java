package ltcd.dynamicProgrammingExercise;

public class _746_使用最小花费爬楼梯 {

    public int minCostClimbingStairs(int[] cost) {
        int first = cost[0];
        int second = cost[1];
        int ans = 0;

        for (int i = 2; i < cost.length; i++) {
            ans = Math.min(first, second) + cost[i];
            first = second;
            second = ans;
        }

        return first > second ? second : first;
    }

    public int minCostClimbingStairs1(int[] cost) {
        int[] help = new int[cost.length];

        help[0] = cost[0];
        help[1] = cost[1];

        for (int i = 2; i < help.length; i++) {
            help[i] = Math.min(help[i - 1], help[i - 2]) + cost[i];
        }

        return Math.min(help[help.length - 1], help[help.length - 2]);
    }



//    超时
//    int min = Integer.MAX_VALUE;
//
//    public int minCostClimbingStairs(int[] cost) {
//        recur(cost, 0, cost[0]);
//        recur(cost, 1, cost[1]);
//        return min;
//    }
//
//    private void recur(int[] cost, int l, int sum) {
//
//        if (l == cost.length - 1 || l == cost.length - 2) {
//            min = Math.min(min, sum);
//            return;
//        }
//        recur(cost, l + 1, sum + cost[l + 1]);
//        recur(cost, l + 2, sum + cost[l + 2]);
//    }

    public static void main(String[] args) {
        _746_使用最小花费爬楼梯 v = new _746_使用最小花费爬楼梯();
        System.out.println(v.minCostClimbingStairs(new int[]{10,15,20}));;
    }

}
