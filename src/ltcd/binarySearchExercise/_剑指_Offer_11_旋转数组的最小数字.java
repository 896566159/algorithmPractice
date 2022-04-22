package ltcd.binarySearchExercise;

public class _剑指_Offer_11_旋转数组的最小数字 {

    public int minArray(int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        }

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                right--;
            }
        }

        return numbers[left];
    }

}
