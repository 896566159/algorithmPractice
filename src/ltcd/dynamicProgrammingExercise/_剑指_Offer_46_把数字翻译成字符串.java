package ltcd.dynamicProgrammingExercise;

import java.util.ArrayList;
import java.util.List;

public class _剑指_Offer_46_把数字翻译成字符串 {

    public int translateNum(int num) {

        int[] digits = digits(num);
        int[] dp = new int[digits.length + 1];
        dp[0] = 0;
        dp[1] = 1;
        boolean flag = true;

        for (int i = 2; i <= digits.length; i++) {
            if ((digits[i - 1] > 5 && digits[i - 2] == 2)
                    || digits[i - 2] == 0
                    || digits[i - 2] > 2) {//当前数字 > 5 并且 前一个数字 > 2，即超过 25 的数,或者前一个数是 0
                dp[i] = dp[i - 1];
                flag = false;
            } else if ( flag
                    && ((digits[i - 1] < 6 && digits[i - 2] == 2) //当前数字 < 6 并且 前一个数字 等于2
                    || (digits[i - 2] == 1))) {//前一个数字 等于1
                if (i == 2) {
                    dp[i] = 2;
                } else {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            }  else if (!flag
                    && ((digits[i - 1] < 6 && digits[i - 2] == 2) //当前数字 < 6 并且 前一个数字 等于2
                    || (digits[i - 2] == 1))) {//前一个数字 等于1
                if (i == 2) {
                    dp[i] = 2;
                } else {
                    dp[i] = dp[i - 1] * 2;
                }
                flag = true;
            }
        }

        return dp[digits.length];
    }

    private int[] digits(int num) {
        List<Integer> list = new ArrayList<>();

        do {
            list.add(0, num % 10);
            num /= 10;
        } while (num != 0);

        int[] ans = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }

}
