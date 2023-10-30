package nowcoder.outd.Y22Q4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 孙悟空喜欢吃蟠桃，一天他趁守卫蟠桃园的天兵天将离开了而偷偷的来到王母娘娘的蟠桃园偷吃蟠桃。
 * 已知蟠桃园有 N 棵蟠桃树，第 i 棵蟠桃树上有 N[i]（大于 0）个蟠桃，天兵天将将在 H（不小于蟠桃树棵数）小时后回来。
 * 孙悟空可以决定他吃蟠桃的速度 K（单位：个/小时），每个小时他会选择一颗蟠桃树，从中吃掉 K 个蟠桃，如果这棵树上的蟠桃数小于 K，他将吃掉这棵树上所有蟠桃，然后这一小时内不再吃其余蟠桃树上的蟠桃。
 * 孙悟空喜欢慢慢吃，但仍想在天兵天将回来前将所有蟠桃吃完。
 * 求孙悟空可以在 H 小时内吃掉所有蟠桃的最小速度 K（K 为整数）。
 *
 * 输入描述:
 * 	从标准输入中读取一行数字，前面数字表示每棵数上蟠桃个数，最后的数字表示天兵天将将离开的时间。
 * 输出描述：
 * 	吃掉所有蟠桃的 最小速度 K（K 为整数）或 输入异常时输出 -1。
 *
 * 示例1：
 * 	输入：
 * 		3 11 6 7 8
 * 	输出：
 * 		4
 * 说明：
 * 	天兵天将8个小时后回来，孙悟空吃掉所有蟠桃的最小速度4。
 * 	第1小时全部吃完第一棵树，吃3个，
 * 	第2小时吃4个，第二棵树剩7个，
 * 	第3小时吃4个，第二棵树剩3个，
 * 	第4小时吃3个，第二棵树吃完，
 * 	第5小时吃4个，第三棵树剩2个，
 * 	第6小时吃2个，第三棵树吃完，
 * 	第7小时吃4个，第4棵树剩3个，
 * 	第8小时吃3个，第4棵树吃完。
 */
public class _猴子吃桃_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            String[] input = scanner.nextLine().split(" ");
            int n = input.length;
            int[] peachs = new int[n - 1];
            int hours = Integer.parseInt(input[n - 1]);

            for (int i = 0; i < n - 1; i++) {
                peachs[i] = Integer.parseInt(input[i]);
            }

            // 每个小时最多只能吃一棵树，不能吃完所有树
            if (peachs.length > hours) {
                System.out.println(-1);
                return;
            }

            // 排序
            Arrays.sort(peachs);

            // 速度在 [1, peachs[peachs.length - 1]] 之间，二分求取
            int right = peachs[peachs.length - 1];
            int left = 1;

            while (left + 1 < right) {
                int mid = (right - left) / 2 + left;

                if (canEat(peachs, mid, hours)) {
                    right = mid;
                } else {
                    left = mid;
                }
            }

            System.out.println(right);
        } catch (Exception e) {
            // 输入异常
            System.out.println(-1);
        }

    }

    private static boolean canEat(int[] peachs, int k, int hours) {
        int sum = 0;

        for (int peach : peachs) {
            // 一个小时只能吃 k 个，且一个小时内只能吃一棵树上的
            sum += peach % k == 0 ? peach / k : peach / k + 1;

            // 吃的速度太慢，已经超时了
            if (sum > hours) {
                return false;
            }
        }

        return sum <= hours;
    }

}
