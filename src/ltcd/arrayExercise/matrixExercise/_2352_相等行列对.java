package ltcd.arrayExercise.matrixExercise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _2352_相等行列对 {

    public int equalPairs(int[][] grid) {
        Map<String, Integer> map = new HashMap<>();
        int ans = 0;
        for (int[] ints : grid) {
            StringBuilder sb = new StringBuilder();
            for (int anInt : ints) {
                sb.append(anInt).append('#');
            }
            String key = sb.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int n = grid.length;
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(grid[j][i]).append("#");
            }

            String key = sb.toString();
            if (map.containsKey(key)) {
                ans += map.get(key);
            }
        }

        return ans;
    }

}
