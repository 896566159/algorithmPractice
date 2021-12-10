package ltcd.binarySearchExercise;

public class _剑指_Offer_II_069_山峰数组的顶部 {

    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) >> 1;

            if (mid + 1 < arr.length - 1 && arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

}
