package ltcd.binarySearchExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

public class _719_找出第_K_小的数对距离 {

    public static void main(String[] args) {
        System.out.println(new _719_找出第_K_小的数对距离().smallestDistancePair(new int[]{3, 6, 8, 10, 12, 16}, 4));
    }

    public int smallestDistancePair(int[] nums, int k) {

        int length = nums.length;
        Arrays.sort(nums);
        int left = 0;
        int right = nums[length - 1] - nums[0];

        while (left < right) {
            int mid = (left + right) >> 1;
            int count = countLessEquals(nums, mid);

            if (count < k) {
                //如果小于等于 mid 的个数严格小于 k 个，说明 mid 太小了
                //下一轮搜索区间为： [mid + 1, right]
                left = mid + 1;
            } else {
                //如果小于等于 mid 的个数大于等于 k 个，说明 k 可能是答案
                right = mid;
            }
        }

        return left;
    }

    /**
     * 统计距离（数值之差）小于等于 threshold 的个数
     * @param nums
     * @param threshold
     * @return
     */
    private int countLessEquals(int[] nums, int threshold) {
        int count = 0;
        int length = nums.length;

        for (int left = 0, right = 0; right < length; right++) {
            while (nums[right] - nums[left] > threshold) {
                left++;
            }

            //次数满足nums[right] - nums[left] <= threshold
            //right 与 [left...right - 1] 区间中的每个元素的 【绝对值/距离】 都小于 threshold
            //[left...right - 1] 区间中的元素个数为 right - left
            count += right - left;
        }
        
        return count;
    }

    public int smallestDistancePair1(int[] nums, int k) {

        int length = nums.length;
        ArrayList<Integer> help = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < length ; i++) {
            for (int j = i + 1; j < length; j++) {
                help.add(Math.abs(nums[j] - nums[i]));
            }
            if (help.size() > k * 3) {
                break;
            }
        }

        help.sort((o1, o2) -> o1 - o2);
        return help.get(k - 1);
    }

}
