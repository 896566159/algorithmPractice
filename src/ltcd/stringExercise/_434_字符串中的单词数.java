package ltcd.stringExercise;

public class _434_字符串中的单词数 {

    public int countSegments(String s) {
        int len = s.length();
        int count = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < len; ) {
            if (chars[i] == ' ' && i++ >= 0) {
                continue;
            }

            while (i < len && chars[i] != ' ') {
                i++;
            }

            count++;
        }

        return  count;
    }

}
