package ltcd.stringExercise;

import java.util.HashSet;
import java.util.Set;

public class _1876_长度为三且各字符不同的子字符串 {

    public int countGoodSubstrings(String s) {

        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        int len = chars.length;
        int left = 0;
        int right = 0;
        int ans = 0;

        while (right < len) {
            if (!set.contains(chars[right]) && set.size() == 2) {
                ans++;
                set.add(chars[right]);
                set.remove(chars[left++]);
            } else if (!set.contains(chars[right]) && set.size() < 3) {
                set.add(chars[right]);
            } else if (set.contains(chars[right])){
                while (left < right && set.contains(chars[right])) {
                    set.remove(chars[left++]);
                }
                set.add(chars[right]);
            }

            right++;
        }

        return ans;
    }

}
