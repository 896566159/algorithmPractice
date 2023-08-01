package nowcoder.outd.Y23Q2;

import java.util.Scanner;

/**
 * 求从坐标零点到坐标点n的最小步数，一次只能沿横坐标轴向左或向右移动 2 或 3.
 * 注意: 途径的坐标点可以为负数
 * 输入描述：
 * 	坐标点n
 * 输出描述：
 * 	输出从坐标零点移动到坐标点n的最小步数
 * 备注：
 * 	1 <= n <= 10^9
 *
 * 示例1：
 * 	输入：
 * 		4
 * 	输出：
 * 		2
 * 说明：从坐标零点移动到4，最小需要两步，即右移2，再右移2
 */
public class _求最小步数_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = Integer.parseInt(scanner.nextLine());
        if (target == 0) {
            System.out.println(0);
        } else if (target == 1) {
            System.out.println(2);
        } else if (target == 2 || target == 3) {
            System.out.println(1);
        } else {
            System.out.println((target / 3) + (target % 3));
        }
    }

}
