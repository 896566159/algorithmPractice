package ltcd.stackExercise;

import java.util.Stack;

public class _1614_括号的最大嵌套深度 {

    public int maxDepth(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }

        int max = 0;
        int index = 0;
        int count = 0;

        while (index < s.length()) {

            if (s.charAt(index) == '(') {
                count++;
                max = Math.max(count, max);
            }
            if (s.charAt(index) == ')') {
                count--;
            }
        }

        return max;
    }

}
