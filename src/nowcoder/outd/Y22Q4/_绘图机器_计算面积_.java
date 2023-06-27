package nowcoder.outd.Y22Q4;

import java.util.Scanner;

/**
 * 绘图机器的绘图笔初始位置在原点(0,0)机器启动后按照以下规则来进行绘制直线。
 * 1. 尝试沿着横线坐标正向绘制直线直到给定的终点E
 * 2. 期间可以通过指令在纵坐标轴方向进行偏移，offsetY 为正数表示正向偏移,为负数表示负向偏移
 * 给定的横坐标终点值 E 以及若干条绘制指令，
 * 请计算绘制的直线和横坐标轴以及 x = E 的直线组成的图形面积。
 * 输入描述:
 * 	首行为两个整数 N 和 E
 * 	表示有 N 条指令, 机器运行的横坐标终点值 E
 * 	接下来 N 行, 每行两个整数表示一条绘制指令 x offsetY
 * 	用例保证横坐标 x 以递增排序的方式出现,且不会出现相同横坐标x
 * 取值范围:
 * 0 < N <= 10000
 * 0 <= x <= E <= 20000
 * -10000 <= offsetY <= 10000
 * 输出描述:
 * 	一个整数表示计算得到的面积 用例保证结果范围在0到4294967295之内。
 * 示例1:
 * 输入:
 * 	4 10
 * 	1 1
 * 	2 1
 * 	3 1
 * 	4 -2
 * 输出:
 * 	12
 *
 * 示例2:
 * 输入:
 * 	2 4
 * 	0 1
 * 	2 -2
 * 输出:
 * 	4
 */
public class _绘图机器_计算面积_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int e = Integer.parseInt(split[1]);
        int[][] point = new int[n][2];

        // 输入的 n 个点
        for (int i = 0; i < n; i++) {
            split = scanner.nextLine().split(" ");
            int[] p = {Integer.parseInt(split[0]), Integer.parseInt(split[1])};
            point[i] = p;
        }

        int areaSum= 0;
        int[] prePoint = point[0];
        int hight = point[0][1];
        for (int i = 1; i < n; i++) {
            int[] cur = point[i];
            // 计算上一个点到改点位置围城的矩形面积
            int width = cur[0] - prePoint[0];
            areaSum += Math.abs(width * hight);

            // 更新新的 hight、prePoint
            hight += cur[1];
            prePoint = cur;
        }

        // 计算最后一个点到 e 点围城的面积
        if (e > prePoint[0]) {
            int width = e - prePoint[0];
            areaSum += Math.abs(width * hight);
        }

        System.out.println(areaSum);
    }

}
