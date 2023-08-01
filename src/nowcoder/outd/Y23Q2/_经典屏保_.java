package nowcoder.outd.Y23Q2;

import java.util.Scanner;

/**
 * DVD机在视频输出时，为了保护电视显像管，在待机状态会显示“屏保动画”，如下图所示，DVD Logo在屏幕内来回运动，碰到边缘会反弹:
 * 请根据如下要求，实现屏保Logo坐标的计算算法
 * 	1、屏幕是一个800*600像素的矩形，规定屏幕的左上角点坐标原点，沿横边向右方向为X轴，沿竖边向下方向为Y轴
 * 	2、Logo是一个50*25像素的矩形，初始状态下，左上角点坐标记做(x，)，它在X和Y方向上均以1像素/秒的速度开始运动;
 * 	3、遇到屏幕四个边缘后，会发生镜面反弹，即以45°碰撞边缘，再改变方向以45°弹出:
 * 	   当Logo和四个角碰撞时，两个边缘同时反弹的效果是Logo会原路返回。
 * 请编码实现，t秒后Logo左上角点的坐标
 *
 * 输入描述:
 * 	输入3个数字，以空格分隔:
 * 	x y t
 * 	第一个数字表示Logo左上角点的初始X坐标
 * 	第二个数字表示Logo左上角点的初始Y坐标:
 * 	第三个数字表示时间t，题目要求即求t秒后Logo左上角点的位置
 * 输出描述:
 * 	输出2个数字，以空格分隔:
 * 	x y
 * 	第一个数字表示t秒后，Logo左上角点的X坐标，第二个数字表示t秒后，Logo左上角点的Y坐标
 * 补充说明:
 * 	所有用例均保证:
 * 	1、输入的x和y坐标会保证整个Logo都在屏幕范围内，Logo不会出画;
 * 	2、所有输入数据都是合法的数值，且不会出现负数:
 * 	3、t的最大值为100000。
 *
 * 示例1
 * 	输入:
 * 		0 0 10
 * 	输出:
 * 		10 10
 * 说明:
 * 	输入样例表示Logo初始位置在屏幕的左上角点，10s后，Logo在X和Y方向都移动了10像素，因此输出10 10.
 *
 * 示例2:
 * 	输入:
 * 		500 570 10
 * 	输出:
 * 		510 570
 * 说明:
 * 	输入样例表示初始状态下，Loo的下边缘再有5像素就碰到屏幕下边缘了，5s后，会与屏幕碰撞，
 * 	碰撞后，斜向45”弹出，又经过5s后，Logo与起始位置相比，水平移动了10像素，垂直方向回到了原来的高度。
 */
public class _经典屏保_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // x:[0-750], y:[0,575]
        String[] split = scanner.nextLine().split(" ");
        int x = Integer.parseInt(split[0]);
        int y = Integer.parseInt(split[1]);
        int t = Integer.parseInt(split[2]);

        // 横向，0-右，1-左
        int transverse = x == 750 ? 1 : 0;
        // 纵向，0-下，1-上
        int direction = y == 575 ? 1 : 0;
        while (t > 0) {
            if (transverse == 0) {
                x++;
            } else {
                x--;
            }
            if (direction == 0) {
                y++;
            } else {
                y--;
            }

            if (x == 750 || x == 0) {
                transverse = transverse == 0 ? 1 : 0;
            }
            if (y == 575 || y == 0) {
                direction = direction == 0 ? 1 : 0;
            }
            t--;
        }

        System.out.println(x + " " + y);
    }

}
