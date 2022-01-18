package ltcd.stringExercise;

public class _1576_替换所有的问号 {

    public String modifyString(String s) {
        if (s == null) {
            return null;
        }

        char[] chars = s.toCharArray();
        int index = 0;
        char pre = '0';

        while (index < chars.length) {
            if (chars[index] == '?') {
                if (index + 1 < chars.length && chars[index + 1] != '?') {
                    for (int i = 0; i < 26; i++) {
                        if ((char)(i + 'a') != pre && (char)(i + 'a') != chars[index + 1]) {
                            chars[index] = (char)(i + 'a');
                            break;
                        }
                    }
                } else {
                    for (int i = 0; i < 26; i++) {
                        if ((char)(i + 'a') != pre) {
                            chars[index] = (char)(i + 'a');
                            break;
                        }
                    }
                }
            }

            pre = chars[index];
            index++;
        }

        return new String(chars);
    }

}
