package ltcd.dualPointerExercise;

public class _1156_单字符重复子串的最大长度 {

    public static void main(String[] args) {
        _1156_单字符重复子串的最大长度 v = new _1156_单字符重复子串的最大长度();
//        v.maxRepOpt1("aaabbaaa");
        v.maxRepOpt1("aaabaaa");
    }

    public int maxRepOpt1(String text) {
        int[] cnt = new int[26];
        char[] chars = text.toCharArray();
        int n = chars.length;


//        for (int i = 0; i < n; i++) {
//            cnt[chars[i] - 'a']++;
//        }

        int i = 0;
        int ans = 0;
        while (i < n) {
            // TODO 计算出 j 前面连续的单字符串和后面的单字符串长度

            int j = i + 1;
            // 找到 i 右边第一个与 chas[i] 不同的位置。j 左边单字符串长度：j - i + 1
            while (j < n && chars[i] == chars[j]) {
                j++;
            }

            int k = j + 1;
            // 找到 j 右边第一个与 chas[i] 不同的位置, j 右边单字符串长度：k - j + 1 - 2 = k - j - 1
            while (k < n && chars[k] == chars[i]) {
                k++;
            }

            // j 前面连续的单字符串和后面的单字符串长度
            int len = k - i;
//            ans = Math.max(ans, Math.min(len, cnt[chars[i] - 'a']));
            ans = Math.max(ans, len);
            i = j;
        }

        return ans;
    }

}
