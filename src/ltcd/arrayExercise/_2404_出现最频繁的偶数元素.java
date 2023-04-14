package ltcd.arrayExercise;

import java.util.HashMap;
import java.util.Map;

public class _2404_出现最频繁的偶数元素 {

    public int mostFrequentEven(int[] nums) {
        int ans = -1;
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for (int num : nums) {
            if (num % 2 == 0) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                if (max == map.get(num)) {
                    ans = Math.min(ans, num);
                } else if (max < map.get(num)) {
                    max = Math.max(max, map.get(num));
                    ans = num;
                }
            }
        }

        return ans;
    }

}
