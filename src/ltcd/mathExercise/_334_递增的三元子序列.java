package ltcd.mathExercise;

import java.util.Map;

public class _334_递增的三元子序列 {


    public boolean increasingTriplet1(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        int[] dp = new int[nums.length];
        int min = nums[0];
        int max = Integer.MAX_VALUE;
        dp[0] = 1;
        dp[1] = nums[1] > nums[0] ? 2 : 1;
        int flag = 0;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > nums[i - 1]) {//如果当前 > 前一个
                if (nums[i] > max && flag == 1) {
                    return true;
                } else {//如果当前 > 长度为2中的那个最大值，则加上当前值就可以升序长度为3
                    flag = 1;
                    dp[i] = 2;
                }
            }else if (min >= nums[i]) {
                dp[i] = 1;
            } else if (min < nums[i]) {
                dp[i] = 2;
            }

            if (dp[i] == 2) {
                max = Math.min(max, nums[i]);
            }
        }

        return false;
    }

    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        int count = 0;
        int current = nums[0];
        int min = nums[0];
        int m = nums[0];

        for (int i = 1; i < nums.length - 1; i++) {

            if(min < nums[i] && m > nums[i]) return true;

            if (min < nums[i]) {
                count = 0;
                current = nums[i];

                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] < nums[j]) {
                        return true;
                    }

                    if (current < nums[j] || min > nums[j] || (current > nums[j] && min < nums[j])) {
                        count++;
                    }

                    if (current < nums[j]) {
                        m = nums[j];
                    }
                }

                if (count < 2) {
                    return false;
                }
            }
            min = Math.min(min, nums[i]);
        }

        return false;
    }
}
