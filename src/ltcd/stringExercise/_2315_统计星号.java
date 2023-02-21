package ltcd.stringExercise;

public class _2315_统计星号 {

    public static int countAsterisks(String s) {
        int count = 0;
        int ans = 0;
        int flag = 0;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '|') {
                ans = chars[i] == '*' ? ans + 1 : ans;
            } else {
                i++;
                for ( ; i < chars.length && chars[i] != '|'; i++) {
                    count = chars[i] == '*' ? count + 1 : count;
                }

                if (i < chars.length  && chars[i] != '|') {
                    ans += count;
                }

                count = 0;
            }

        }

        return ans;
    }

}
