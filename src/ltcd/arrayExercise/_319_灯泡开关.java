package ltcd.arrayExercise;

public class _319_灯泡开关 {

    public int bulbSwitch(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int count = 1;

        for (int i = 3; i <= n; i++) {
            int m = 0;
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    m++;
                }
            }
            if (m % 2 == 0) {
                count++;
            }
        }

        return count;
    }

}
