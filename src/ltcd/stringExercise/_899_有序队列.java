package ltcd.stringExercise;

import java.util.*;

public class _899_有序队列 {

    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            //模拟往后移一个元素
            StringBuilder sb = new StringBuilder(s);
            for (int i = 1; i < s.length(); i++) {
                //第一个元素移动到最后
                sb.append(sb.charAt(0)).deleteCharAt(0);
                if (sb.toString().compareTo(s) < 0) {
                    s = sb.toString();
                }
            }
            return s;
        } else {
            //直接排序
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }

}
