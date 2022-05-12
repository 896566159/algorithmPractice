package ltcd.backtrackingExecise;

public class _942_增减字符串匹配 {

    public int[] diStringMatch(String s) {
        int[] ans = new int[s.length() + 1];
        int right = s.length() + 1;
        int left = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == 'I') {
                ans[i] = left;
                left++;
            } else {
                ans[i] = right;
                right--;
            }
        }

        return ans;
    }

}
