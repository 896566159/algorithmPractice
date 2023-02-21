package ltcd.arrayExercise;

import java.util.Arrays;

public class _剑指_Offer_61_扑克牌中的顺子 {

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int pre = nums[4];
        int zero = 0;

        for (int i = 0; i < 5; i++) {
            if (nums[i] == 0) {
                zero++;
            }
        }

        for (int i = 3; i >= 0 && nums[i] != 0; i--) {
            if (pre - 1 == nums[i]) {
                pre = nums[i];
            } else if (pre == nums[i]) {
                return false;
            } else {
                zero = zero - (pre - nums[i] - 1);
                if (zero < 0) {
                    return false;
                }
                pre = nums[i];
            }
        }

        return true;
    }

}
