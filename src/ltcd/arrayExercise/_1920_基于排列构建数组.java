package ltcd.arrayExercise;

public class _1920_基于排列构建数组 {

    public static int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(buildArray(new int[]{0,2,1,5,3,4}).toString());
    }

}
