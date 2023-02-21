package ltcd.greedyExercise;

import java.util.Arrays;
import java.util.Comparator;

public class _646_最长数对链 {

    public static int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int pre = pairs[0][1];
        int ans = 1;
        for (int i = 1; i < pairs.length; i++) {
            if (pre < pairs[i][0]) {
                ans++;
                pre = pairs[i][1];
            }
        }

        return ans;
    }

}
