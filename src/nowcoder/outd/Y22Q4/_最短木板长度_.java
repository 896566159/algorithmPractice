package nowcoder.outd.Y22Q4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 小明有 n 块木板，第 i ( 1 ≤ i ≤ n ) 块木板长度为 ai。
 * 小明买了一块长度为 m 的木料，这块木料可以切割成任意块，
 * 拼接到已有的木板上，用来加长木板。
 * 小明想让最短的木板尽量长。
 * 请问小明加长木板后，最短木板的长度可以为多少？
 *
 * 输入描述：
 * 	输入的第一行包含两个正整数，n(1≤n≤10^3),m(1≤m≤10^6)
 * 	n表示木板数，m表示木板长度。输入的第二行包含n个正整数，a1,a2,...an(1≤ai≤10^6)。
 * 输出描述：
 * 	输出的唯一一行包含一个正整数，表示加长木板后，最短木板的长度最大可以为多少？
 *
 * 示例一：
 * 输入：
 * 	5 3
 * 	4 5 3 5 5
 * 输出：
 * 	5
 *
 * 说明：
 * 	给第1块木板长度增加1，给第3块木板长度增加2后，
 * 	这5块木板长度变为[5,5,5,5,5]，最短的木板的长度最大为5。
 *
 * 示例二：
 * 输入：
 * 	5 2
 * 	4 5 3 5 5
 * 输出：
 * 	4
 *
 * 给第3块木板长度增加1后，
 * 这5块木板长度变为[4,5,4,5,5]，剩余的木料长度为1。此时剩余木料无论给哪块木板加长，最短木料的长度都为4。
 */
public class _最短木板长度_ {

    public static void main(String[] args) {
        //处理输入
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int[] nums = new int[n];

        split = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }

        if (n == 1) {
            System.out.println(nums[0] + m);
            return;
        }

        while (m > 0) {
            // 排序
            Arrays.sort(nums);

            // 给最短的木板数量
            int index = 1;
            while (index < n && nums[index - 1] == nums[index]) {
                index++;
            }

            // 如果长度都一样，把 m 均分，接在每一块板子上
            if (index == n) {
                System.out.println(m / n + nums[0]);
                return;
            } else {
                // 最短和第二短之间相差多少米
                int diff = nums[index] - nums[index - 1];

                if (index * diff <= m) {
                    // 让最短和第二短的木板长度一致
                    m -= index * diff;
                    while (index > 0) {
                        nums[--index] += diff;
                    }
                } else {
                    // m 长度不足以让最短和第二短的木板长度一致
                    System.out.println(nums[0] + m / index);
                    return;
                }
            }
        }

        System.out.println(nums[0]);

    }

}
