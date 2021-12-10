package ltcd.dualPointerExercise;

public class _344_反转字符串 {

    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }

        int lefft = 0;
        int right = s.length - 1;

        while (lefft < right) {
            swap(s, lefft, right);
            lefft++;
            right--;
        }
    }

    private void swap(char[] s, int lefft, int right) {
        char tmp = s[lefft];
        s[lefft] = s[right];
        s[right] = tmp;
    }

}
