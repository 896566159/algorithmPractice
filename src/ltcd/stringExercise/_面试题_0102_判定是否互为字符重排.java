package ltcd.stringExercise;

public class _面试题_0102_判定是否互为字符重排 {

    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] arr = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            if (arr[s2.charAt(i) - 'a']-- < 0) {
                return false;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        _面试题_0102_判定是否互为字符重排 v = new _面试题_0102_判定是否互为字符重排();
        System.out.println(v.CheckPermutation("caa", "bas"));
    }

}
