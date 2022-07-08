//package ltcd.binarySearchExercise;
//
//import java.util.HashSet;
//
//public class _786_第K个最小的素数分数 {
//
//    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
//
//        int len = arr.length;
//        int left = 1;
//        int right = len - 1;
//
//        while (left < right) {
//            int mid = (arr[left] + arr[right]) >> 1;
//            int count = countLessEquls(arr[mid], arr);
//
//            if (count > k) {
//                left = mid + 1;
//            } else {
//                right = mid;
//            }
//        }
//
//
//        return new int[]{}
//    }
//
//}
