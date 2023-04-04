package ltcd.stringExercise;

public class _1638_统计只差一个字符的子串数目 {

    public static void main(String[] args) {
        _1638_统计只差一个字符的子串数目 v = new _1638_统计只差一个字符的子串数目();
        System.out.println(v.countSubstrings("aaaaaa", "abaaba"));
    }

    public int countSubstrings(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        int ans = 0;
        int n = s.length();
        int m = t.length();

        for (int d = 1 - m; d < n; ++d) {
            int i = Math.max(d, 0);

            for (int k0 = i - 1, k1 = k0; i < n && i - d < m; ++i) {
                if (sChars[i] != tChars[i - d]) {
                    k0 = k1; // 上上一个不同
                    k1 = i; //上一个不同
                }

                ans += k1 - k0;
            }
        }

        return ans;
    }

}
