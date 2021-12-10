package ltcd.binarySearchExercise;

import java.util.*;

public class _349_两个数组的交集 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        for (int i = 0; i < nums1.length; i++) {
            binarySearch(nums1[i], set, nums2);
        }

        int[] array = new int[set.size()];
        Iterator<Integer> iterator = set.iterator();
        int index = 0;

        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            array[index++] = integer;
        }

        return array;
    }

    private void binarySearch(int target, Set<Integer> list, int[] nums2) {
        int left = 0;
        int right = nums2.length - 1;

        while (left <= right) {
            int mid = (left + right) >> 1;

            if (nums2[mid] > target) {
                right = mid - 1;
            } else if(nums2[mid] < target) {
                left = mid + 1;
            } else if (nums2[mid] == target) {
                list.add(target);
                return;
            }
        }
    }

}
