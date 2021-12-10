package ltcd.dualPointerExercise;

public class _557_反转字符串中的单词_III {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0){
            return "";
        }

        char[] chars = s.toCharArray();
        int right = 0;
        int left = 0;

        while (right < chars.length) {
            if (chars[right] == ' ') {
                reverseWord(chars, left, right);
                left = right;
            }
            right++;
        }

        return new String(chars);
    }

    private void reverseWord(char[] s, int left, int right) {
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = s[tmp];
            left++;
            right--;
        }
    }

}
