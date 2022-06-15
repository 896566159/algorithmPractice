package ltcd.preSum;

public class _926_将字符串翻转到单调递增 {

    public static int minFlipsMonoIncr(String s) {
        int length = s.length();
        int[] preSum = new int[length + 1];
        preSum[0] = 0;
        char[] chars = s.toCharArray();
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < length; i++) {
            preSum[i + 1] = preSum[i] + (chars[i] - '0');
        }

        for (int i = 0; i <= length; i++) {
            ans = Math.min(ans, preSum[i] + (length - i - (preSum[length] - preSum[i])));
        }

        return ans;
    }

}
