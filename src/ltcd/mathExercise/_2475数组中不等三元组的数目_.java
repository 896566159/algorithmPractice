package ltcd.mathExercise;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class _2475数组中不等三元组的数目_ {

    public static void main(String[] args) {
        _2475数组中不等三元组的数目_ v = new _2475数组中不等三元组的数目_();
        System.out.println(v.unequalTriplets(new int[]{1, 3, 1, 2, 4}));
    }

    public int unequalTriplets(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        if (map.size() < 3) {
            return 0;
        }

        int sum = 0;
        int a = 0;
        int n = nums.length;

        for (Integer b : map.values()) {
            int c = n - a - b;
            sum += a * b * c;
            a += b;
        }

        return sum;
    }

}
