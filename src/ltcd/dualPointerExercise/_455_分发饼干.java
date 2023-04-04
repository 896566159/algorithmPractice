package ltcd.dualPointerExercise;

import java.util.Arrays;

public class _455_分发饼干 {

    public int findContentChildren(int[] g, int[] s) {
        int ans = 0;
        int p1 = 0;
        int p2 = 0;
        int length = g.length;
        int length1 = s.length;

        Arrays.sort(g);
        Arrays.sort(s);

        while (p1 < length) {
            while (p2 < length1) {
                if (g[p1] <= s[p2]) {
                    p2++;
                    ans++;
                    break;
                }
            }
            p1++;
        }

        return ans;
    }

}
