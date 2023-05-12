package ltcd.backtrackingExecise;

public class _面试题0805递归乘法_ {

    public static void main(String[] args) {
        _面试题0805递归乘法_ c = new _面试题0805递归乘法_();
        System.out.println(c.multiply(1, 10));
    }

    int x;
    public int multiply(int A, int B) {
        if (B == 0 || A == 0) {
            return 0;
        }

        x = A;
        return dfs(0, B);
    }

    private int dfs(int res, int b) {
        if (b == 0) {
            return res;
        }

        return dfs(res + x, b - 1);
    }

}
