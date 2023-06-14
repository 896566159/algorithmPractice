package nowcoder.outd.Y22Q4;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 一条长的笔直的街道上有n个路灯，若这条街的起点为 0，终点为 l，第 i 个路灯坐标为 a[i]，每盏灯可以覆盖到的最远距离为 d，为了照明需求，所有灯的灯光必须覆盖整条街，但是为了省电，要使这个 d 最小，请找到这个最小的 d。
 * 输入描述:
 *  每组数据第一行两个整数 n 和 l (n 大于 0 小于等于 1000，l 小于等于 1000000000 大于 0)
 *  第二行有 n 个整数(均大于等于 0 小于等于 l)，为每盖灯的坐标，多个路灯可以在同一点。
 * 输出描述:
 *  输出答案，保留两位小数
 *
 * 示例1:
 * 输入
 *  7 15
 *  15 5 3 7 9 14 0
 * 输出
 *  2.50
 */
public class _路灯照明_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int points = Integer.parseInt(split[0]);
        int[] arr  = new int[points];
        int len = Integer.parseInt(split[1]);

        String[] line = scanner.nextLine().split(" ");
        for (int i = 0; i < points; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        Arrays.sort(arr);
        int max = Integer.MIN_VALUE;
        int mxIdx = 0;
        for (int i = 1; i < points; i++) {
            if (max <  arr[i] - arr[i - 1]) {
                max = arr[i] - arr[i - 1];
                mxIdx = i;
            }
        }

        // 中间位置的两个灯泡只需要照亮两个灯泡之间的距离的一半就行了
        float mid = (float) (arr[mxIdx] - arr[mxIdx - 1]) / 2;
        // 最左边第一个灯泡需要照亮到 0 位置
        int left = arr[0] - 0;
        // 最右边第一个灯泡需要照亮到 l 位置
        int right = len - arr[points - 1];

        // 取三个照亮的最小值
        Float bound = Float.valueOf(Math.max(left, right));
        Float res = Math.max(bound, mid);

        // 保留两位小数
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        System.out.println(decimalFormat.format(res));
    }

}
