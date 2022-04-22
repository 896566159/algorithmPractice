package ltcd.dynamicProgrammingExercise;

public class _647_回文子串 {

    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int count = 0;
        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            //dp[i][j] : 从i位置到j位置的串是否是回文
            dp[i][i] = true;
            count++;
        }

        //从 indexi 到 indexj 是否是回文串
        for (int indexj = 0; indexj < len; indexj++) {
            for (int indexi = 0; indexi < len && indexi < indexj; indexi++) {
                if (chars[indexi] != chars[indexj]) {
                    continue;
                } else {
                    if (indexj - indexi < 3) {
                        dp[indexi][indexj] = true;
                    } else {
                        dp[indexi][indexj] = dp[indexi + 1][indexj - 1];
                    }
                }


                if (dp[indexi][indexj]) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        new _647_回文子串().countSubstrings("aaa");
    }

}
