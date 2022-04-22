package ltcd.arrayExercise;

public class _剑指_Offer_21_调整数组顺序使奇数位于偶数前面 {

    public int[] exchange(int[] nums) {
        int first = 0;
        int seoned = 0;

        while (seoned < nums.length) {
            if ((nums[seoned] & 1) == 0) {
                first = seoned + 1;
                while (first < nums.length && ((nums[first] & 1) != 0)) {
                    first++;
                }

                if (first >= nums.length) {
                    return nums;
                }

                int tmp = nums[seoned];
                nums[seoned] = nums[first];
                nums[first] = seoned;
            }

            seoned++;
        }

        return nums;
    }

}
