package ltcd.stringExercise;

public class _392_判断子序列 {

    public boolean isSubsequence(String s, String t) {
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        int index1 = 0;
        int index2 = 0;

        while (index1 < t.length() && index2 < s.length()) {

            if (charsS[index2] == charsT[index1]) {
                index2++;
            }

            index1++;
        }

        return index2 == charsS.length;
    }

}
