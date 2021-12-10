package ltcd.dualPointerExercise;

public class _2000_反转单词前缀 {

    public String reversePrefix(String word, char ch) {
        char[] chars = word.toCharArray();
        int right = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ch) {
                right = i;
                break;
            }
        }

        int left = 0;
        while (left < right) {
            ch = chars[left];
            chars[left++] = chars[right];
            chars[right--] = ch;
        }

        return new String(chars);
    }

}
