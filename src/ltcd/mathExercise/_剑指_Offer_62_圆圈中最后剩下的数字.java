package ltcd.mathExercise;

public class _剑指_Offer_62_圆圈中最后剩下的数字 {

    public int lastRemaining(int n, int m) {
        int ans = 0;

        for (int i = 2; i < n; i++) {
            ans = (ans + m) % i;
        }

        return ans;
    }

}
