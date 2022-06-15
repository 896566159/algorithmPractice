package ltcd.stringExercise;

public class _面试题_0104_回文排列 {

    public boolean canPermutePalindrome(String s) {
        int[] count = new int[128];
        char[] chars = s.toCharArray();
        int length = chars.length;
        int flag = 0;

        for (int i = 0; i < length; i++) {
            count[chars[i] - 0]++;
        }

        for (int i = 0; i < 128; i++) {
            if (chars[i] % 2 != 0) {
                flag++;
            }
        }

        return flag <= 1;
    }

}
