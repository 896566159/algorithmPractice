package ltcd.dualPointerExercise;

public class _283_移动零 {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int p = 0;

        for (int i = 0; i < nums.length && p < nums.length; i++) {
            if (nums[i] != 0 && i < p) {
                nums[p] = nums[i];
                nums[i] = 0;
            }
            p++;
        }
    }


    public void moveZeroes1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int left = 0;
        int index = 0;

        while (left < nums.length) {
            if (nums[left] != 0) {
                nums[index++] = nums[left++];
            }
        }

        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
