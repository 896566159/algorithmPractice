package ltcd.stringExercise;

import java.util.LinkedList;

public class _520_检测大写字母 {

    public boolean detectCapitalUse(String word) {
        if (word == null || word.length() == 0) {
            return true;
        }

        char[] chars = word.toCharArray();

        //the last character is capital letter: must all letter is capital letter
        if (chars[chars.length - 1] >= 65 & chars[chars.length - 1] <= 90) {
            return isLowerOrCapital(chars, 0, chars.length - 1, true);
        } else {//last character is lower case letter or capital character
            return isLowerOrCapital(chars, 1, chars.length - 1, false);
        }
    }

    private boolean isLowerOrCapital(char[] chars, int start, int end, boolean flag) {
        if (flag) {
            for (int i = start; i < end; i++) {
                if (!(chars[i] >= 65 & chars[i] <= 90)) {
                    return false;
                }
            }
        } else {
            for (int i = start; i < end; i++) {
                if (!(chars[i] >= 97 & chars[i] <= 122)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        _520_检测大写字母 v = new _520_检测大写字母();
        v.detectCapitalUse("USA");
        LinkedList<Integer> a = new LinkedList<>();
        Object[] objects = a.toArray();
    }

}
