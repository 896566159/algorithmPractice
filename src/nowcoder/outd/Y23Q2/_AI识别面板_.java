package nowcoder.outd.Y23Q2;

import java.util.*;

/**
 * AI识别到面板上有N (1 ≤N ≤ 100) 个指示灯，灯大小一样，任意两个之间无重叠。
 * 由于AI识别误差，每次别到的指示灯位置可能有差异，以4个坐标值描述AI识别的指示灯的大小和位置(左上角x1,y1，右下角x2,y2)。
 * 请输出先行后列排序的指示灯的编号，排序规则:
 * 	1.每次在尚未排序的灯中挑选最高的灯作为的基准灯
 * 	2.找出和基准灯属于同一行所有的灯进行排序。两个灯高低偏差不超过灯半径算同一行(即两个灯坐标的差灯高度的一半)。
 * 输入描述：
 * 	第一行为N，表示灯的个数
 * 	接下来N行，每行为1个灯的坐标信息，格式为:
 * 	编号x1 y1 x2 y2
 * 	1：编号全局唯一
 * 	2：1< 编号 ≤100
 * 	3：0≤ x1 < x2 ≤1000
 * 	4：0≤ y1 < y2 ≤ 1000
 * 输出描述：
 * 	排序后的编号列表，编号之间以空格分隔
 *
 * 示例1：
 * 	输入：
 * 		5
 * 		1 0 0 2 2
 * 		2 6 1 8 3
 * 		3 3 2 5 4
 * 		5 5 4 7 6
 * 		4 0 4 2 6
 * 	输出：
 * 		1 2 3 4 5
 */
public class _AI识别面板_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] lanterns = new int[n][4];

        // 根据灯泡的左上角和右下角的左边，计算出其中心坐标和半径
        for (int i = 0; i < n; i++) {
            String[] split = scanner.nextLine().split(" ");
            lanterns[i][0] = Integer.parseInt(split[0]);
            // 中心坐标的 x
            lanterns[i][1] = (Integer.parseInt(split[1]) + Integer.parseInt(split[3])) / 2;
            // 中心坐标的 y
            lanterns[i][2] = (Integer.parseInt(split[2]) + Integer.parseInt(split[4])) / 2;
            // 半径 r
            lanterns[i][3] = (Integer.parseInt(split[3]) - Integer.parseInt(split[1])) / 2;
        }

        // 先按照，纵坐标排序(即题目中的高度，高度值越小代表越高)，众坐标相等，则按照横坐标排序
        Arrays.sort(lanterns, (a, b)->a[2] != b[2] ? a[2] - b[2] : a[1] - b[1]);
        List<int[]> sameRowLanterns = new ArrayList<>();
        int[] base = lanterns[0];
        sameRowLanterns.add(base);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++) {

            // 两个灯高低偏差不超过灯半径算同一行(即两个灯坐标的差灯高度的一半)
            if (lanterns[i][2] - base[2] <= base[3]) {
                sameRowLanterns.add(lanterns[i]);
            } else {
                // 从未排序的灯中挑选出最高的那颗
                base = lanterns[i];
                sameRowLanterns.add(base);
            }
        }

        // 输出结果
        if (!sameRowLanterns.isEmpty()) {
            for (int[] lantern : sameRowLanterns) {
                sb.append(lantern[0] + " ");
            }
        }

        System.out.println(sb.substring(0, sb.length() - 1).toString());
    }

}
