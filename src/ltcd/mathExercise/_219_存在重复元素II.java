package ltcd.mathExercise;

import java.util.HashMap;
import java.util.Map;

public class _219_存在重复元素II {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (Math.abs(i - map.get(nums[i])) <= k) {
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            } else if (map.containsKey(nums[i])){
                continue;
            } else {
                map.put(nums[i], i);
            }

        }

        return false;
    }

    public static void main(String[] args) {
        new _219_存在重复元素II().containsNearbyDuplicate(new int[]{99, 99}, 2);
    }
}
