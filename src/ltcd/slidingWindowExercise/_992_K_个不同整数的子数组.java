package ltcd.slidingWindowExercise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _992_K_个不同整数的子数组 {

    public static void main(String[] args) {
        System.out.println(new _992_K_个不同整数的子数组().subarraysWithKDistinct(new int[]{1,2,1,3,4}, 3));
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        if (nums.length < k) {
            return 0;
        }

        int ans = 0;
        Set<Integer> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int length = nums.length;

        while (right < length) {
            set.add(nums[right]);
            right++;//窗口扩大

            //如果 窗口中 的元素个数小于 K ，则直接遍历下一个
            if (set.size() < k) {
                continue;
            }

            if (set.size() > k) {
                left = right - 1;
                int pre = nums[left];
                int count = 0;
                left--;

                while (left >= 0 && count < k) {
                    if (pre != nums[left]) {
                        count++;
                    }
                    pre = nums[left];
                    left--;
                }

                set.remove(nums[left + 1]);
            }

            if (set.size() == k) {
                int pre = nums[right - 1];
                int indx = right - 2;

                while (indx >= 0 && pre == nums[indx]) {
                    indx--;
                }

                left = indx == right - 2 ? right - k - 1 : indx - k;

                while (left >= 0 && set.contains(nums[left])) {
                    left--;
                    ans++;
                }

                ans++;
            }
        }

        return ans;
    }

}
