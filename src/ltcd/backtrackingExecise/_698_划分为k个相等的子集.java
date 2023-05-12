package ltcd.backtrackingExecise;


import java.util.Arrays;

public class _698_划分为k个相等的子集 {

    public static void main(String[] args) {
        _698_划分为k个相等的子集 k个相等的子集 = new _698_划分为k个相等的子集();
//        System.out.println(k个相等的子集.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
//        System.out.println(k个相等的子集.canPartitionKSubsets(new int[]{3, 2, 2, 1}, 3));
        System.out.println(k个相等的子集.canPartitionKSubsets(new int[]{1739,5391,8247,236,5581,11,938,58,1884,823,686,1760,6498,6513,6316,2867}, 6));
//        System.out.println(k个相等的子集.canPartitionKSubsets(new int[]{2,2,2,2,3,4,5}, 4));
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }

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
        int[] group = new int[k];

        return dfs(target, nums, nums.length - 1, group);
    }

    private boolean dfs(int target, int[] nums, int index, int[] group) {
        if (index < 0) {
            // 这里不需要判断每个桶内的元素是否为 target，因为每个元素都已经放在桶中，说明每个通都是等于target的
//            for (int i = 0; i < group.length; i++) {
//                if (group[i] != target) {
//                    return false;
//                }
//            }
            return true;
        }

        for (int i = 0; i < group.length; i++) {
            if (i > 1 && group[i] == group[i - 1]) {
                // 如果该桶和上一个桶相等，则这个元素选择放相同值的桶的结果是一样的，可以不对第二个重复桶的值在放一次
                continue;
            }

            // 可以放如该桶
            if (nums[index] + group[i] <= target) {
                group[i] = nums[index] + group[i];
                if (dfs(target, nums, index + 1, group)) {
                    return true;
                }
                group[i] = group[i] - nums[index];
            }
        }

        return false;
    }

}
