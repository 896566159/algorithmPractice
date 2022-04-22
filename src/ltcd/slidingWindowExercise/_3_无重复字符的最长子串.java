package ltcd.slidingWindowExercise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _3_无重复字符的最长子串 {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int len = 0;
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            char c = s.charAt(right);

            right++;

            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);

            len = Math.max(right - left, len);
        }

        return len == 0 ? s.length() : len - 1;
    }

    public int lengthOfLongestSubstring1(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        Map<Character, Integer> map = new HashMap<>();
        int len = 0;

        int left = 0;
        int right = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            right++;

            //缩小窗口
            while (map.get(c) > 1) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            len = Math.max(right - left, len);
        }

        return len == 0 ? s.length() : len - 1;
    }

    public static void main(String[] args) {
        new _3_无重复字符的最长子串().lengthOfLongestSubstring("aff");
    }
}
