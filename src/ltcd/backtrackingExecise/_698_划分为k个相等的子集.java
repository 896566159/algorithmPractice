package ltcd.backtrackingExecise;

import java.util.Arrays;

public class _698_划分为k个相等的子集 {

    public static void main(String[] args) {
        _698_划分为k个相等的子集 k个相等的子集 = new _698_划分为k个相等的子集();
        System.out.println(k个相等的子集.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
//        System.out.println(k个相等的子集.canPartitionKSubsets(new int[]{3, 2, 2, 1}, 3));
//        System.out.println(k个相等的子集.canPartitionKSubsets(new int[]{2,2,2,2,3,4,5}, 4));
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }

        // 不能均分成 k 组
        if (sum % k != 0 || sum / k < max) {
            return false;
        }

        Arrays.sort(nums);

        int target = sum / k;


        boolean[] used = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                if (!dfs(nums, used, target, i)) {
                    used[i] = true;
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int[] nums, boolean[] used, int target, int index) {
        if (target == 0) {
//            this.used = used;
            return true;
        }



        return false;
    }

}
