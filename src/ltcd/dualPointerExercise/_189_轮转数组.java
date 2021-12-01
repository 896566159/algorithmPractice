package ltcd.dualPointerExercise;

public class _189_轮转数组 {

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }

        if (k == nums.length / 2 && k % 2 == 0) {
            int tmp = nums[0];
            int flag = 0;

            for (int i = 0; i < k; i++) {
                tmp = nums[i + k];
                nums[i + k] = nums[i];
                nums[i] = tmp;
            }

        }

        int flag = 0;
        int pointer = 0;
        int pre = nums[pointer];
        int tmp = 0;

        while (flag < nums.length) {
            tmp = nums[(pointer + k) % nums.length];
            nums[(pointer + k) % nums.length] = pre;
            pre = tmp;
            pointer = pointer + k;
            flag++;
        }
    }

}
