package ltcd.stringExercise;

import java.util.Arrays;

public class _面试题_0106_字符串压缩 {

    public String compressString(String S) {
        StringBuffer sb = new StringBuffer();
        int count = 1;
        char[] chars = S.toCharArray();
        int length = chars.length;

        for (int i = 0; i < length; i++) {
            while (i + 1 < length && chars[i] == chars[i + 1]) {
                count++;
                i++;
            }

            if (count > 1) {
                sb.append(chars[i]).append(count);
                count = 1;
            } else {
                sb.append(chars[i]).append(1);
            }
        }

        return sb.length() > length ? S : sb.toString();
    }

}
