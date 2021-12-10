package ltcd.dualPointerExercise;

import java.util.LinkedList;
import java.util.List;

public class _763_划分字母区间 {

    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new LinkedList<>();
        char[] chars = s.toCharArray();
        int[] scope = new int[26];//record the character's right bound

        for (int i = 0; i < chars.length; i++) {
            scope[chars[i] - 'a'] = i;
        }

        int last = -1;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            index = Math.max(index, scope[chars[i] - 'a']);
            if (i == index) {
                list.add(index - last);
                last = i;
            }
        }

        return list;
    }

}
