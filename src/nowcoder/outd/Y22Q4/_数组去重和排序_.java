package nowcoder.outd.Y22Q4;

import java.util.*;

/**
 * 给定一个乱序的数组，删除所有的重复元素，使得每个元素只出现一次，并且按照出现的次数从高到低进行排序，相同出现次数按照第一次出现顺序进行先后排序。
 *
 * 输入描述：
 * 	一个数组
 *
 * 输出描述：
 * 	去重排序后的数组
 *
 * 示例 1：
 * 	输入：
 * 		1,3,3,3,2,4,4,4,5
 * 	输出：
 * 		3,4,1,2,5
 * 备注：数组大小不超过100 数组元素值大小不超过100
 */
public class _数组去重和排序_ {

    public static void main(String[] args) {
        //处理输入
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(",");
        int n = split.length;
        Map<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(split[i]);
            if (!map.containsKey(cur)) {
                map.put(cur, new int[] {1, i});
            } else {
                map.get(cur)[0]++;
            }
        }

        // 将 map 中的元素提取数来
        List<Map.Entry<Integer, int[]>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, (a, b)->{
            int[] valueA = a.getValue();
            int[] valueB = b.getValue();
            if (valueA[0] != valueB[0]) {
                return valueB[0] - valueA[0];
            } else {
                return valueA[1] - valueB[1];
            }
        });

        // 输出
        int size = entries.size();
        for (int i = 0; i < size - 1; i++) {
            System.out.print(entries.get(i).getKey() + ",");
        }
        System.out.print(entries.get(size - 1).getKey());
    }

}
