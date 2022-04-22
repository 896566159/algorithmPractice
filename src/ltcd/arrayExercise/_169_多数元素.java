package ltcd.arrayExercise;

public class _169_多数元素 {

    //摩尔投票法
    public int majorityElement(int[] nums) {

        int candidate = nums[0];
        int count = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            } else if (--count == 0) {
                candidate = nums[i];
                count = 1;
            }
        }

        return candidate;
    }

}
