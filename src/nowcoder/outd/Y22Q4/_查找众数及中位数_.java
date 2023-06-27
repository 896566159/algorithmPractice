package nowcoder.outd.Y22Q4;

import java.util.*;

/**
 * 众数是指一组数据中出现次数量多的那个数，众数可以是多个。
 * 中位数是指把一组数据从小到大排列，最中间的那个数，如果这组数据的个数是奇数，那最中间那个就是中位数，如果这组数据的个数为偶数，那就把中间的两个数之和除以2，所得的结果就是中位数。
 * 查找整型数组中元素的众数并组成一个新的数组，求新数组的中位数。
 * 输入描述:
 * 	输入一个一维整型数组，数组大小取值范围 0<N<1000，数组中每个元素取值范围 0<E<1000
 * 输出描述:
 * 	输出众数组成的新数组的中位数
 * 示例1:
 * 	输入:
 * 		10 11 21 19 21 17 21 16 21 18 15
 * 	输出:
 * 		21
 *
 * 示例2:
 * 	输入:
 * 		2 1 5 4 3 3 9 2 7 4 6 2 15 4 2 4
 * 	输出:
 * 		3
 * 示例3:
 * 	输入:
 * 		5 1 5 3 5 2 5 5 7 6 7 3 7 11 7 55 7 9 98 9 17 9 15 9 9 1 39
 * 	输出:
 * 		7
 */
public class _查找众数及中位数_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        // 这里使用treeMap，可以在找中位数的时候省去排序的步骤
        Map<Integer, Integer> map = new TreeMap<>();
        int max = 0;

        for (String s : split) {
            int num = Integer.parseInt(s);
            map.put(num, map.getOrDefault(num, 0) + 1);
            max = Math.max(max, map.get(num));
        }

        List<Integer> list = new ArrayList<>();
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            if (map.get(key) == max) {
                list.add(key);
            }
        }

        int ans = list.get(list.size() / 2);
        if (list.size() % 2 == 0) {
            ans += list.get(list.size() / 2 - 1);
            ans /= 2;
        }

        System.out.println(ans);
    }

}
