package nowcoder.outd.Y22Q4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 给定两个数组a，b，若a[i] == b[j] 则称 [i, j] 为一个二元组，求在给定的两个数组中，二元组的个数。
 *
 * 输入描述：
 * 	第一行输入 m
 * 	第二行输入 m 个数，表示第一个数组
 * 	第三行输入 n
 * 	第四行输入n个数，表示第二个数组
 *
 * 输出描述：
 * 	二元组个数。
 *
 * 示例1：
 * 	输入：
 * 		4
 * 		1 2 3 4
 * 		1
 * 		1
 * 	输出：
 * 		1
 * 说明：二元组个数为 1个
 *
 * 示例2：
 * 	输入：
 * 		4
 * 		1 1 2 2
 * 		3
 * 		2 2 4
 * 	输出：
 * 		4
 * 说明：二元组个数为 4 个
 */
public class _二元组个数_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = Integer.parseInt(scanner.nextLine());
        String[] num1 = scanner.nextLine().split(" ");
        int n2 = Integer.parseInt(scanner.nextLine());
        String[] num2 = scanner.nextLine().split(" ");

        int res = 0;
        // 暴力计算
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (num1[i].equals(num2[j])) {
                    res++;
                }
            }
        }

        System.out.println(res);

        // 使用map结构来优化
        // 统计出第一个数组中的各元素数量
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < n1; i++) {
            int key = Integer.parseInt(num1[i]);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int i = 0; i < n2; i++) {
            int key = Integer.parseInt(num2[i]);
            if (map.containsKey(key)) {
                count += map.get(key);
            }
        }
        System.out.println(count);
    }

}
