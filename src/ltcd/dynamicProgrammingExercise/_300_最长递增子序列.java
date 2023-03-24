package ltcd.dynamicProgrammingExercise;

public class _300_最长递增子序列 {

    public int lengthOfLIS2(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return length;
        }

        // tail 数组的定义: 长度为 i + 1 的升序子序列的末尾最小是几
        int[] tail = new int[length];
        // 遍历第 1 个数。直接放在有序数组 tail 的开头
        tail[0] = nums[0];
        // end 表示有序数组 tail 的最后一个已经赋值元素的索引
        int end = 0;

        for (int i = 0; i < length; i++) {
            // 逻辑1 比 tail 数组实际有效的末尾的那个元素还大
            if (nums[i] > tail[end]) {
                // 直接添加在哪个元素的后面，所以 end 先加 1
                end++;
                tail[end] = nums[i];
            } else {
                // 使用二分查找法，在有序数组 tail 中：找到第 1 个大于等于 nums[i] 的元素，尝试让那个元素更小
                int left = 0;
                int right = end;

                while (left < right) {
                    int mid = left + ((right - left) >>> 1);
                    if (tail[mid] < nums[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                // 走到这里是因为 【逻辑 1】 的反面，因此一定能找到第 1 个大于等于 nums[i] 的元素, 因此，无需再单独判断
                tail[left] = nums[i];
            }
        }
        return 0;
    }

    // 时间复杂度 O(n方)
    public int lengthOfLIS1(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int max = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        // 遍历填写 dp[i]
        for (int i = 1; i < nums.length; i++) {
            int tmp = 0;

            // 填写 dp[i] 时，遍历一遍 i 下标之前的所有元素，找出一个 元素值比num[i]小 并且 dp[i]最大的
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    tmp = Math.max(tmp, dp[j]);
                }
            }

            dp[i] = tmp + 1;
            max = Math.max(dp[i], max);
        }

        return max;
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int max = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j], dp[i]);
                }
            }

            max = Math.max(dp[i], max);
        }

        return max;
    }

}
