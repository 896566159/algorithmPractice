package ltcd.stringExercise;

public class _777_在LR字符串中交换相邻字符 {

    public boolean canTransform(String start, String end) {

        char[] charsStart = start.toCharArray();
        char[] charsEnd = end.toCharArray();
        int n = charsEnd.length;
        int i = 0;
        int j = 0;

        while (i < n || j < n) {
            //找到start中第一个不是X的字符
            while (i < n && charsStart[i] == 'X') {
                i++;
            }
            //找到end中第一个不是X的字符
            while (j < n && charsEnd[j] == 'X') {
                j++;
            }

            //如果i和j遍历到了结尾，i和j必须相等
            if (i == n && j == n) {
                return i == j;
            }

            //如果这两个字符不相等，则返回false
            if (charsEnd[j] != charsStart[i]) {
                return false;
            }

            //如果都是L，且 i 小于 j，则返回false
            if (charsStart[i] == 'L' && i < j) {
                return false;
            }

            //如果都是R，且 i 大于 j，则返回false
            if (charsStart[i] == 'R' && i > j) {
                return false;
            }

            i++;
            j++;
        }

        return true;
    }

}
