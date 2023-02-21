package ltcd.sort;

import java.util.*;

public class _剑指_Offer_51_数组中的逆序对 {

    int ans = 0;

    public int reversePairs(int[] nums) {
        mergeSort(0, nums.length, nums);
        return ans;
    }

    /**
     * 归并排序
     * @param left
     * @param right
     * @param nums
     */
    private void mergeSort(int left, int right, int[] nums) {
        if (right - left <= 1) {
            return;
        }

        int mid = (left + right) >> 1;
        mergeSort(left, mid, nums);
        mergeSort(mid, right, nums);

        merge(left, mid, right, nums);
    }

    private void merge(int left, int mid, int right, int[] nums) {
        int[] help = new int[right - left];
        int index = 0;
        int start = left;
        int among = mid;

        while (index < help.length && left < among && mid < right){

            if (nums[left] <= nums[mid]) {
                help[index++] = nums[left++];
            } else {
                help[index++] = nums[mid++];
                ans += among - left;
            }

        }

        while (mid < right) {
            help[index++] = nums[mid++];
        }

        while (left < among) {
            help[index++] = nums[left++];
        }

        for (int i = 0; i < help.length; i++) {
            nums[start++] = help[i];
        }
    }

    /**
     * 超时
     * @param nums
     * @return
     */
    public int reversePairs1(int[] nums) {
        Deque<Integer> deque = new ArrayDeque<>();
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            if (deque.isEmpty() || deque.peekLast() > nums[i]) {
                ans += deque.size();
                deque.addLast(nums[i]);
            } else if (!deque.isEmpty() && deque.peekFirst() <= nums[i]) {
                deque.addFirst(nums[i]);
            }  else {
                int lastDiff = nums[i] - deque.peekLast();
                int firstiDiff = deque.peekFirst() - nums[i];

                if (lastDiff >= firstiDiff) {
                    Deque<Integer> help = new ArrayDeque<>();
                    while (!deque.isEmpty() && deque.peekFirst() > nums[i]) {
                        help.addLast(deque.pollFirst());
                    }
                    ans += help.size();
                    deque.addFirst(nums[i]);
                    while (!help.isEmpty()) {
                        deque.addFirst(help.pollLast());
                    }
                } else {
                    Deque<Integer> help = new ArrayDeque<>();
                    while (!deque.isEmpty() && deque.peekLast() <= nums[i]) {
                        help.addLast(deque.pollLast());
                    }
                    ans += deque.size();
                    deque.addLast(nums[i]);
                    while (!help.isEmpty()) {
                        deque.addLast(help.pollLast());
                    }
                }
            }
        }

        return ans;
    }

}
