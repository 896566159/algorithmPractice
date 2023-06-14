package ltcd.stringExercise;

public class _1234_替换子串得到平衡字符串 {

    public static void main(String[] args) {
        balancedString(new String("WWEQERQWQWWRWWERQWEQ"));
    }

    public static int balancedString(String s) {
        char[] chars = s.toCharArray();
        int[] cnt = new int['X'];
        for (char c : chars) {
            ++cnt[c];
        }

        int n = s.length();
        int m = n / 4;

        // 已经是平衡字符串
        if (cnt['Q'] == m && cnt['W'] == m && cnt['E'] == m && cnt['R'] == m) {
            return 0;
        }

        int ans = n;
        int left = 0;
        // 枚举子串右端点
        for (int right = 0; right < n; right++) {
            --cnt[chars[right]];

            while (cnt['Q'] <= m && cnt['W'] <= m && cnt['E'] <= m && cnt['R'] <= m) {
                ans = Math.min(ans, right - left + 1);
                ++cnt[chars[left++]];
            }
        }

        return ans;
    }


    // ---------------自己写的，不正确--------------------------
    public static int balancedString1(String s) {
        char[] chars = s.toCharArray();
        int[] count = new int[4];
        int ans = 0;
        int len = chars.length / 4;

        for (char c: chars) {
            if (c == 'Q') {
                count[0]++;
            } else if (c == 'W') {
                count[1]++;
            }  else if (c == 'E') {
                count[2]++;
            } else {
                count[3]++;
            }
        }

        for (int i = 0; i < 4; i++) {
            if (count[i] > len) {
                ans += count[i] - len;
            }
        }

        return ans;
    }

}
