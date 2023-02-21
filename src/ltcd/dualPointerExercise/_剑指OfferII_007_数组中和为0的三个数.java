package ltcd.dualPointerExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _剑指OfferII_007_数组中和为0的三个数 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        //排序
        Arrays.sort(nums);
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            int num = nums[i];

            //去重剪枝：如果当前数已经大于0 则他不可能和后面的任意两个正数累加和为 0
            if (num > 0) {
                break;
            }

            //剪枝：如果当前数和前面一个数相等，则跳过
            if (i > 0 && num == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right] + num;

                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(num);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ans.add(list);

                    //去重剪枝：
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                }
            }
        }

        return ans;
    }

}
