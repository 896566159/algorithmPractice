package ltcd.stringExercise;

import java.util.Set;
import java.util.TreeSet;

public class _面试题_0101_判定字符是否唯一 {

    public boolean isUnique(String astr) {
        Set<Character> set = new TreeSet<>();
        for (int i = 0; i < astr.length(); i++) {
            char c = astr.charAt(i);
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }

        return true;
    }

}
