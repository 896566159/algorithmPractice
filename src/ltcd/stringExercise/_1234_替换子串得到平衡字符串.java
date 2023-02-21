package ltcd.stringExercise;

public class _1234_替换子串得到平衡字符串 {

    public static void main(String[] args) {
        balancedString(new String("WWEQERQWQWWRWWERQWEQ"));
    }

    public static int balancedString(String s) {
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
