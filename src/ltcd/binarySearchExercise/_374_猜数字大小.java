package ltcd.binarySearchExercise;

public class _374_猜数字大小 {

    public int guessNumber(int n) {
        int left = 1;
        int ans;

        while (left <= n) {
            ans = (int) Math.floor((left + n) >> 1);
            if (guessNumber(ans) <= 0) {
                n = ans;
            } else {
                left = ans + 1;
            }
        }

        return n;
    }

}
