package ltcd.stringExercise;

import java.util.HashMap;
import java.util.Map;

public class _205_同构字符串 {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> map1 = new HashMap<>();
        char[] charsT = t.toCharArray();
        char[] charsB = s.toCharArray();
        int length = charsB.length;

        for (int i = 0; i < length; i++) {
            if (map.containsKey(charsB[i]) && map.get(charsB[i]) != charsT[i]
                     || map1.containsKey(charsT[i]) && map1.get(charsT[i]) != charsB[i]) {
                return false;
            }
            map.put(charsB[i], charsT[i]);
            map1.put(charsT[i], charsB[i]);
        }

        return true;
    }

}
