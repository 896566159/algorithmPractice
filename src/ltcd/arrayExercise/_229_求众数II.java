package ltcd.arrayExercise;

import java.util.*;

public class _229_求众数II {

    //摩尔投票法
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = 0;
        int candidate2 = 0;
        int count1 = 0;
        int count2 = 0;

        //投票：
        // 1.遍历到的当前数等于候选人中的一个，这该候选人的计数器++
        // 2.遍历到的当前数不等于任何候选人，则将候选人替换成当前数，并将计数器赋值为1
        for (int num: nums) {
            if (count1 != 0 && num == candidate1) {
                count1++;
            } else if (count2 != 0 && num == candidate2) {
                count2++;
            } else if (count1 == 0 && ++count1 >= 0) {
                candidate1 = num;
            } else if (count2 == 0 && ++count2 >= 0) {
                candidate2 = num;
            } else {
                count1--;
                count2--;
            }
        }

        //计数阶段
        count1 = 0;
        count2 = 0;
        for (int num: nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        LinkedList<Integer> list = new LinkedList<>();
        if (count1 > (nums.length / 3)) {
            list.add(candidate1);
        }
        if (count2 > (nums.length / 3)) {
            list.add(candidate2);
        }

        return list;
    }

    public List<Integer> majorityElement1(int[] nums) {

        List<Integer> res = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            if (next.getValue() > (nums.length) / 3) {
                res.add(next.getKey());
            }
        }

        return res;
    }

}
