package ltcd.dualPointerExercise;

public class _剑指_Offer_II_009_乘积小于K的子数组 {

    public static void main(String[] args) {
//        System.out.println(numSubarrayProductLessThanK(new int[]{10,9,10,4,3,8,3,3,6,2,10,10,9,3}, 19));
        System.out.println(numSubarrayProductLessThanK(new int[]{10,2,2,5,4,4,4,3,7,7}, 299));
//        System.out.println(numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;
        int rigth = 0;
        int left = 0;
        int length = nums.length;
        long multiply = 1;

        while (rigth < length) {
            multiply *= nums[rigth++];

            while (rigth > left && multiply >= k) {
                multiply /= nums[left++];
            }

            ans += rigth - left;
        }

        return ans;
    }

}
