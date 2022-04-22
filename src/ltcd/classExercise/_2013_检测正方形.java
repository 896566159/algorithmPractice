package ltcd.classExercise;

import java.util.HashMap;
import java.util.Map;

public class _2013_检测正方形 {

    Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

    public _2013_检测正方形() {
    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];

        Map<Integer, Integer> ymap = map.getOrDefault(x, new HashMap<>());
        ymap.put(y, ymap.getOrDefault(y, 0) + 1);

        map.put(x, ymap);
    }

    public int count(int[] point) {
        int x = point[0];
        int y = point[1];
        int ans = 0;
        Map<Integer, Integer> ymap = map.getOrDefault(x, new HashMap<>());

        for (int ny : ymap.keySet()) {
            if (ny == y) continue;

            int c1 = ymap.get(ny);
            int len = y - ny;
            int[] nums = new int[] {x + len, x - len};

            for (int nx : nums) {
                Map<Integer, Integer> temp = map.getOrDefault(nx, new HashMap<>());
                int c2 = temp.getOrDefault(y, 0);
                int c3 = temp.getOrDefault(ny, 0);

                ans += c1 * c2 * c3;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        _2013_检测正方形 v = new _2013_检测正方形();
        v.add(new int[]{3,10});
        v.add(new int[]{11,2});
        v.add(new int[]{3,2});
        v.count(new int[]{11,10});
    }

}
