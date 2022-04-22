package ltcd.arrayExercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _954_二倍数对数组 {

    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int zorecout = 0;//0 比较特殊，因为 0 * 2 = 0

        //统计素组元素出现次数
        for (int i: arr) {
            if (i == 0) {//0 就单股统计次数
                zorecout++;
            } else {//其余数组元素统计次数
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }

        //0 * 2 = 0， 0 / 2 = 0，所以如果 0 的次数是奇数次，则直接返回 false
        if (zorecout % 2 != 0) {
            return false;
        }

        //将数组排序：不排序可能出现：【2, 4, 8, 1】组合成【2,4】剩下 1 和 8 不能成为 2倍关系的序对
        Arrays.sort(arr);


        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {//如果map中已经没有改元素了，说明已经和前面的某个数进行了匹配，直接跳过
                continue;
            } else {
                //将arr[i]看做n, 查看map中有没有 2n 的数，有的话可以组成【n, 2n】序对
                if (map.containsKey(arr[i] * 2)) {
                    //如果map中的元素可以组成【n, 2n】序对，则将map中 n 、2n 的次数减一，如果减一后为 0 直接删除

                    if (map.get(arr[i] * 2) == 1) {//对map中 key 为 2n的数做次数减一操作
                        map.remove(arr[i] * 2);
                    } else {
                        map.put(arr[i] * 2, map.get(arr[i] * 2) - 1);
                    }

                    if (map.get(arr[i]) == 1) {//对map中 key 为 n的数做次数减一操作
                        map.remove(arr[i]);
                    } else {
                        map.put(arr[i], map.get(arr[i]) - 1);
                    }
                }
            }
        }

        //如果最后map中的所有数据被匹配完（即map元素全部被删除），则说明满足题目要求
        return map.size() == 0;
    }

    public static void main(String[] args) {
        _954_二倍数对数组 v = new _954_二倍数对数组();
        System.out.println(v.canReorderDoubled(new int[]{2, 4, 0, 0, 8, 1}));
    }
}
