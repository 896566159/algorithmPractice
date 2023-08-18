package nowcoder.outd.Y22Q3;

import java.util.*;

/**
 * 现在有多组整数数组，需要将它们合并成一个新的数组。
 * 合并规则：
 * 	从每个数组里按顺序取出固定长度的内容合并到新的数组中，取完的内容会删除掉，
 * 	如果该行不足固定长度或者已经为空，则直接取出剩余部分的内容放到新的数组中，继续下一行。
 * 输入描述：
 * 	第一行是每次读取的固定长度，0< 长度 <10
 * 	第二行是整数数组的数目，0< 数目 <1000
 * 	第 3-n 行是需要合并的数组，不同的数组用回车换行分隔，数组内部用逗号分隔，最大不超过100个元素。
 *
 * 输出描述：
 * 	输出一个新的数组，用逗号分隔。
 *
 * 示例1：
 * 	输入：
 * 		3
 * 		2
 * 		2,5,6,7,9,5,7
 * 		1,7,4,3,4
 * 	输出：
 * 		2,5,6,1,7,4,7,9,5,3,4,7
 */
public class _数组拼接_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        Map<Integer, List<Integer>> res = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] split = scanner.nextLine().split(",");
            for (int j = 0; j < split.length; j++) {
                int key = j / m;
                if (!res.containsKey(key)) {
                    res.put(key, new ArrayList<>());
                }
                res.get(key).add(Integer.parseInt(split[j]));
            }
        }

        int index = 0;
        for (List<Integer> value : res.values()) {
            for (Integer item : value) {
                if (index++ > 0) {
                    System.out.print(",");
                }
                System.out.print(item);
            }
        }
    }

    private static void m1() {
        Scanner scanner = new Scanner(System.in);
        int m = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer>[] arrs = new List[n];
        // 记录每行数组还有多少元素未合并
        int[] remain = new int[n];
        List<Integer> res = new ArrayList<>();
        int countNum = 0;

        // 需要合并的 n 行数组
        for (int i = 0; i < n; i++) {
            String[] split = scanner.nextLine().split(",");
            arrs[i] = new ArrayList<>();
            for (int j = 0; j < split.length; j++) {
                arrs[i].add(Integer.parseInt(split[j]));
                // 记录所有元素的个数
                countNum++;
            }
            // 更新数组还剩余未合并的元数数量
            remain[i] = arrs[i].size();
        }

        while (countNum > 0) {
            for (int i = 0; i < n; i++) {
                if (remain[i] > 0) {
                    int j = m;
                    while (!arrs[i].isEmpty() && j-- > 0) {
                        res.add(arrs[i].remove(0));
                        countNum--;
                    }
                    // 更新数组还剩余未合并的元数数量
                    remain[i] = arrs[i].size();
                }
            }
        }

        // 输出结果
        for (int i = 0; i < res.size(); i++) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print(res.get(i));
        }
    }

}
