package ltcd;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _1790_仅执行一次字符串交换能否使两个字符串相等 {

    public static boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int count = 0, m = -1, n = -1;
        for (int i = 0, j = 0; i < s1.length(); i++, j++) {
            if (s1.charAt(i) != s2.charAt(j)) {
                if (++count > 2) {
                    return false;
                }

                if (m == -1) {
                    m = i;
                }
                if (n == -1 && m != i) {
                    n = i;
                }
            }
        }

        if (m != -1 && n != -1 && s1.charAt(m) == s2.charAt(n) && s2.charAt(m) == s1.charAt(n)){
            return true;
        }

        return m != -1 || n != -1;
    }

}
