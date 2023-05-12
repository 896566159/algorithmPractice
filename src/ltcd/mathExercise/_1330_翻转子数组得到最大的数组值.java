package ltcd.mathExercise;

public class _1330_翻转子数组得到最大的数组值 {
    public static void main(String[] args) {
        _1330_翻转子数组得到最大的数组值 v = new _1330_翻转子数组得到最大的数组值();
        v.maxValueAfterReverse(new int[] {2,3,1,5,4});
    }

    public int maxValueAfterReverse(int[] nums) {
        int max = Integer.MIN_VALUE;
        int base = 0;
        int d = 0;
        int n = nums.length;
        int min = Integer.MAX_VALUE;

        // 枚举翻转 [1,n-1]、[2,n-2]
        for (int i = 1; i < n; i++) {
            int a = nums[i - 1], b = nums[i];
            int dab = Math.abs(a - b);
            base += dab;
            max = Math.max(max, Math.min(a, b));
            min = Math.min(min, Math.max(a, b));
            d = Math.max(d, Math.max(Math.abs(nums[0] - b) - dab, // i=0
                    Math.abs(nums[n - 1] - a) - dab)); // j=n-1
        }

        return base + Math.max(d, 2 * (max - min));
    }

}
