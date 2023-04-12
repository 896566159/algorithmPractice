package ltcd.dynamicProgrammingExercise;

import java.util.HashSet;
import java.util.Set;

public class _1147_段式回文_ {

    public static void main(String[] args) {
        _1147_段式回文_ v = new _1147_段式回文_();
        System.out.println(v.longestDecomposition("elvtoelvto"));
    }

    public int longestDecomposition(String text) {
        if (text.isEmpty()) {
            return 0;
        }

        for (int i = 1, n = text.length(); i <= n / 2; i++) {
            if (text.substring(0, i).equals(text.substring(n - i))) {
                return 2 + longestDecomposition(text.substring(i, n - i));
            }
        }

        // 无法分割
        return 1;
    }

    public int longestDecomposition1(String text) {
        int ans = 0;

        char[] chars = text.toCharArray();
        int left = 0;
        int length = chars.length;
        int right = length;

        while (left < right) {

            int n = 1;
            while (n < right - left) {
                String text1 = text.substring(left, left + n);
                String text2 = text.substring(right - n, right);

                if (text1.equals(text2)) {
                    ans += 2;
                    break;
                }
                n++;
            }

            left += n;
            right -= n;
        }

        return left == right ? ans + 1 : ans;
    }

}
