package ltcd.stackExercise;

public class _856_括号的分数 {

    public static int scoreOfParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        char[] chars = s.toCharArray();
        int sum = 0;
        int n = 0;

        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == '(') {
                if (n == 0) {
                    n = 1;
                } else {
                    n = n << 1;
                }
            } else if (chars[i] == ')') {
                if (chars[i - 1] == '(') {
                    sum += n;
                }
                n = n >> 1;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        scoreOfParentheses("(()(()))");
    }

}
