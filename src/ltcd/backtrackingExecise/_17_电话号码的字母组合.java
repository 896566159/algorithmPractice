package ltcd.backtrackingExecise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _17_电话号码的字母组合 {

    char[] chars = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        dfs(0, "", digits);

        return ans;
    }

    private void dfs(int index, String str, String digits) {
        if (index == digits.length()) {
            ans.add(str);
            return;
        }

        int num = digits.charAt(index) - '0';
        int start = 0;
        int end = 0;
        if (num < 7) {
            start = (num - 2) * 3;
            end = start + 2;
        } else if (num == 7) {
            start = (num - 2) * 3;
            end = start + 3;
        } else if (num == 8) {
            start = (num - 2) * 3 + 1;
            end = start + 2;
        } else if (num == 9) {
            start = (num - 2) * 3 + 1;
            end = start + 3;
        }

        for (int i = start; i <= end; i++) {
            dfs(index + 1, str + chars[i], digits);
        }
    }

}
