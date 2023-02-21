package ltcd.greedyExercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class _870_优势洗牌 {

    public static int[] advantageCount(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return nums1;
        }

        int n = nums1.length;
        TreeSet<Integer> tset = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums1) {
            map.put(x, map.getOrDefault(x, 0) + 1);

            if (map.get(x) == 1) {
                tset.add(x);
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            Integer cur = tset.ceiling(nums2[i] + 1);

            if (cur == null) {
                cur = tset.ceiling(-1);
            }
            ans[i] = cur;
            map.put(cur, map.get(cur) - 1);
            if (map.get(cur) == 0) {
                tset.remove(cur);
            }
        }

        return nums1;
    }

    public static void main(String[] args) {
        advantageCount(new int[]{2,7,11,15}, new int[]{1,10,4,11});
    }

}
