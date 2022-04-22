package ltcd.backtrackingExecise;

import java.util.ArrayList;
import java.util.List;

public class _386_字典序排数 {

    List<Integer> ans = new ArrayList<>();

    public List<Integer> lexicalOrder(int n) {

        for (int i = 1; i <= 9; i++) {
            backtracking(i, n);
        }

        return ans;
    }

    private void backtracking(int pre, int n) {
        if (pre > n) {
            return;
        }

        ans.add(pre);

        for (int i = 0; i < 10; i++) {
            if (pre * 10 + i <= n) {
                backtracking(pre * 10 + i, n);
            }
        }
    }

}
