package ltcd.binarySearchExercise;

public class _剑指_Offer_53_I_在排序数组中查找数字I {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = (left + right) >> 1;

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        while (right < nums.length && nums[right] == nums[left]) {
            right++;
        }

        return left >= 0 && left < nums.length && nums[left] == target ? right - left : 0;
    }

    public static void main(String[] args) {
        System.out.println(new _剑指_Offer_53_I_在排序数组中查找数字I().search(new int[]{3}, 3));
    }

}
