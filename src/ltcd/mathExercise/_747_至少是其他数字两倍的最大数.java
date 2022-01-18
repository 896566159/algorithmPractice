package ltcd.mathExercise;

public class _747_至少是其他数字两倍的最大数 {

    public int dominantIndex(int[] nums) {

        if (nums == null) {
            return 0;
        }

        if (nums.length == 1) {
            return 0;
        }

        int maxIndex = 0;
        int secondMaxIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            if ((secondMaxIndex == -1 || nums[i] > nums[secondMaxIndex]) && nums[i] < nums[maxIndex]) {
                secondMaxIndex = i;
            }

            if (nums[i] > nums[maxIndex]) {
                secondMaxIndex = maxIndex;
                maxIndex = i;
            }
        }

        if (nums[secondMaxIndex] * 2 <= nums[maxIndex]) {
            return maxIndex;
        }

        return -1;
    }

    public static void main(String[] args) {
        new _747_至少是其他数字两倍的最大数().dominantIndex(new int[]{2,0,3,0});
    }

}
