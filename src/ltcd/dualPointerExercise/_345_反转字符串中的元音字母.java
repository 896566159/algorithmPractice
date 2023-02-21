package ltcd.dualPointerExercise;

import java.util.HashSet;
import java.util.Set;

public class _345_反转字符串中的元音字母 {

    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('A');
        set.add('e');
        set.add('E');
        set.add('i');
        set.add('I');
        set.add('o');
        set.add('O');
        set.add('u');
        set.add('U');
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();

        while (left < right) {

            while (left < right && !set.contains(chars[left])) {
                left++;
            }

            while (left < right && !set.contains(chars[right])) {
                right--;
            }

            char t = chars[left];
            chars[left] = chars[right];
            chars[right] = t;
            left++;
            right--;
        }

        return new String(chars);
    }

}
