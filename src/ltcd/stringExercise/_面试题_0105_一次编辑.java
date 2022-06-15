package ltcd.stringExercise;

public class _面试题_0105_一次编辑 {

    public boolean oneEditAway(String first, String second) {
        if (first.length() < 2 && second.length() < 2) {
            return true;
        }

        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

        int count = 1;
        char[] firstChars = first.toCharArray();
        char[] secondChars = second.toCharArray();
        int blength = second.length();
        int alength = first.length();
        int a = 0;
        int b = 0;
        //删除一个字母
        if (first.length() == second.length() + 1) {
            while (b < blength) {
                if (firstChars[a] != secondChars[b]) {
                    if (--count < 0) {
                        return false;
                    }
                    b--;
                }
                b++;
                a++;
            }
        } else if (first.length() + 1 == second.length()) {//增加一个字母
            while (a < alength) {
                if (firstChars[a] != secondChars[b]) {
                    if (--count < 0) {
                        return false;
                    }
                    a--;
                }
                b++;
                a++;
            }
        } else {
            while (b < blength) {
                if (firstChars[a] != secondChars[b] && --count < 0) {
                    return false;
                }
                b++;
                a++;
            }
        }
        return true;
    }

}
