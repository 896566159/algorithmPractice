package ltcd.backtrackingExecise;

public class _2582_递枕头 {

    public static void main(String[] args) {
        _2582_递枕头 v = new _2582_递枕头();
        System.out.println(v.passThePillow(3, 2));
    }

    public int passThePillow(int n, int time) {
        return dfs(n, 1, 1, time);
    }

    private int dfs(int n, int res, int direction, int time) {
        if (time == 0) {
            return res;
        }

        if (direction == 1) {
            if (res == n) {
                return dfs(n, n - 1, -1, time - 1);
            }
            return dfs(n, res + 1, 1, time - 1);
        } else {
            if (res == 1) {
                return dfs(n, 2, 1, time - 1);
            }
            return dfs(n, res - 1, -1, time - 1);
        }
    }

}
