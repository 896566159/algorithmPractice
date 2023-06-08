package ltcd.stringExercise;

public class _2559_统计范围内的元音字符串数 {

    public static void main(String[] args) {
        _2559_统计范围内的元音字符串数 v = new _2559_统计范围内的元音字符串数();
        v.vowelStrings(new String[] {"aba","bcb","ece","aa","e"}, new int[][]{{0,2},{1,4},{1,1}});
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        int[] preSum = new int[words.length + 1];

        for (int i = 0; i < words.length; i++) {
            char start = words[i].charAt(0);
            char end = words[i].charAt(words[i].length() - 1);
            if (isVowel(start) && isVowel(end)) {
                preSum[i + 1] = preSum[i] + 1;
            } else {
                preSum[i + 1] = preSum[i];
            }
        }

        for (int i = 0; i < n; i++) {
            ans[i] = preSum[queries[i][1] + 1] - preSum[queries[i][0]];
        }

        return ans;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' ||c == 'i' ||c == 'o' ||c == 'u';
    }

}
