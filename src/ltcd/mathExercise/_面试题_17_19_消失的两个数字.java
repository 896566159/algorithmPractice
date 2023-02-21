package ltcd.mathExercise;

public class _面试题_17_19_消失的两个数字 {

    public static int[] missingTwo(int[] nums) {

        int totalLen = nums.length + 2;
        int toltalSum = (1 + totalLen) * (totalLen >> 1);

        for (int num : nums) {
            toltalSum -= num;
        }

        int diffMid = toltalSum >> 1;
        int diffHalfSum = ((diffMid + 1) * diffMid) >> 1;
        for (int num : nums) {
            if (num <= diffMid) {
                diffHalfSum -= num;
            }
        }

        return new int[] {diffHalfSum, toltalSum - diffHalfSum};
    }

}
