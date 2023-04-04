package ltcd.backtrackingExecise;

public class _1641_统计字典序元音字符串的数目 {

    int ans = 0;

    public int countVowelStrings(int n) {

        char[] chars = new char[]{'a','e','i','o','u'};
        backTrack(0, chars,  n, 'a');

        return ans;
    }


    private void backTrack(int index, char[] chars, int n, char last) {
        if (index == n) {
            ans++;
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            // 判断当前的字母和最后的一个字母大小
            if (chars[i] >= last) {
                backTrack(index + 1, chars, n, chars[i]);
            }
        }

    }

}
