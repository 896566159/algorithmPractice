package ltcd.slidingWindowExercise;

import java.util.HashSet;
import java.util.Set;

public class _剑指Offer_48_最长不含重复字符的子字符串 {

    public int lengthOfLongestSubstring(String s) {

        int length = s.length();
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        int max = 0;

        while (right < length) {

            char c = s.charAt(right);

            if (set.contains(c)) {
                while (set.contains(c)) {
                    set.remove(s.charAt(left));
                    left++;
                }
            } else {
                set.add(c);
                max = max > set.size() ? max : set.size();
            }

            right++;
        }

        return max;
    }

}
