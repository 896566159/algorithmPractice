package ltcd.dualPointerExercise;

public class _167_两数之和_II_输入有序数组 {

    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return new int[]{-1, -1};
        }

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else if (numbers[left] + numbers[right] < target){
                left++;
            } else {
                return new int[]{left, right};
            }
        }

        return new int[]{-1, -1};
    }

}
