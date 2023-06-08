package ltcd.backtrackingExecise;

import java.util.*;

public class _剑指OfferII_104_排列的数目 {

    public static void main(String[] args) {
        _剑指OfferII_104_排列的数目 v = new _剑指OfferII_104_排列的数目();
        System.out.println(v.combinationSum4_1(new int[]{1, 2, 4}, 7));
    }

    // 动态规划版本
    public int combinationSum4_1(int[] nums, int target) {
        Arrays.sort(nums);

        int[] dp = new int[target + 1];
        for (int num : nums) {
            if (target >= num) {
                dp[num] = 1;
            }
        }

        // 1 2 4
        for (int i = 1; i <= target; i++) {
            int count = dp[i];

            for (int num : nums) {
                if (num < i) {
                    count += dp[i - num];
                }else {
                    break;
                }
            }

            dp[i] = count;
        }

        return dp[target];
    }

    // 递归 + 记忆化搜索 版本
    Map<Integer, Integer> memo = new HashMap<>();
    int[] arr;
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        arr = nums;
        return dfsWithMemo(target);
    }

    private int dfsWithMemo(int target) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }

        if (target < 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (target < arr[i]) {
                continue;
            } else if (target == arr[i]) {
                count++;
                continue;
            } else {
                count += dfsWithMemo(target - arr[i]);
            }
        }

        memo.put(target, count);
        return count;
    }

    // 递归超时版本
//    Set<List<Integer>> ans = new HashSet<>();
//    int[] arr;
//    public int combinationSum4(int[] nums, int target) {
//        arr = nums;
//        List<Integer> trace = new ArrayList<>();
//
//        dfs(target, trace);
//        return ans.size();
//    }
//
//    private boolean dfs(int target, List<Integer> trace) {
//        if (target < 0) {
//            return false;
//        }
//
//        if (target == 0) {
//            ans.add(trace);
//            return true;
//        }
//
//        for (int i = 0; i < arr.length; i++) {
//            if (target - arr[i] >= 0) {
//                trace.add(arr[i]);
//                dfs(target - arr[i], trace);
//                trace.remove(trace.size() - 1);
//            }
//        }
//
//        return false;
//    }

}
