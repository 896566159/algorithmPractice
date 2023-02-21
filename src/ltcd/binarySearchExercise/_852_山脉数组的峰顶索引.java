package ltcd.binarySearchExercise;

public class _852_山脉数组的峰顶索引 {

    public int peakIndexInMountainArray(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) >> 1;

            //[left,right]是单调递增
            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return left;
    }

}
