package ltcd.mathExercise;

public class _2485_找出中枢整数 {

    public int pivotInteger(int n) {
        int ans = -1;
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        int resum = 0;
        for (int i = 1; i <= n; i++) {
            if (resum == sum - resum - i) {
                return i;
            }

            resum += i;
        }

        return ans;
    }

}
