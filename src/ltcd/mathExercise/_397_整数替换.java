package ltcd.mathExercise;

public class _397_整数替换 {

    public int integerReplacement(int n) {
        return help(n * 1L);
    }

    private int help(long n) {
        if (n == 1) {
            return 0;
        }

        if (n == 2147483647) {
            return 1 + help(n - 1);
        }

        if (n % 2 == 0) {
            return 1 + help(n / 2);
        }

        return 1 + Math.min(help(n + 1), help(n - 1));
    }

}
