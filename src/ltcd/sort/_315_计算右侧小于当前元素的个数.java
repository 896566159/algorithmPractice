package ltcd.sort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _315_计算右侧小于当前元素的个数 {
    public static void main(String[] args) {
        new _315_计算右侧小于当前元素的个数().countSmaller(new int[]{5,2,6,1});
    }

    List<Integer> ans = new ArrayList<>();

    public List<Integer> countSmaller(int[] nums) {
        mergeSort(nums, 0, nums.length);
        return ans;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left + 1 >= right) {
            return;
        }

        int mid = (left + right + 1) >> 1;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] help = new int[right - left];
        int leftIndex = left;
        int among = mid;
        int index = 0;

        while (mid < right && left < among) {
            if (nums[left] < nums[mid]) {
                help[index++] = nums[left++];
            } else {
                help[index++] = nums[mid++];
            }
        }

        while (left < among) {
            help[index++] = nums[left++];
        }

        while (mid < right) {
            help[index++] = nums[mid++];
        }

        index = 0;
        for (int i = 0; i < help.length; i++) {
            nums[leftIndex++] = help[i];
        }
    }

}
