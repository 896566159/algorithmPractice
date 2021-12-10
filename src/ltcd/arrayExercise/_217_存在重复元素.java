package ltcd.arrayExercise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _217_存在重复元素 {

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }

        return false;
    }


    public boolean containsDuplicate1(int[] nums) {
        if (nums == null) {
            return false;
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }

        return false;
    }

}
