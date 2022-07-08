package ltcd.mathExercise;

import java.util.ArrayList;
import java.util.List;

public class _989_数组形式的整数加法 {

    public static void main(String[] args) {
        new _989_数组形式的整数加法().addToArrayForm(new int[]{1,7,9}, 1258);
    }

    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new ArrayList<>();
        int length = num.length;

        for (int i = length - 1; i >= 0 || k != 0; i--) {
            int pre = k % 10;
            if (i >= 0) {
                pre = num[i] + k;
            }

            ans.add(0, pre % 10);
            k = pre > 10 ? k / 10 + 1 : k / 10;
        }

        return ans;
    }

}
