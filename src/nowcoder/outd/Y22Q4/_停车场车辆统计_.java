package nowcoder.outd.Y22Q4;

import java.util.Scanner;

/**
 * 特定大小的停车场，数组cars[]表示，其中1表示有车，0表示没车。
 * 车辆大小不一，小车占一个车位（长度1），货车占两个车位（长度2），卡车占三个车位（长度3）。
 * 统计停车场最少可以停多少辆车，返回具体的数目。
 *
 * 输入描述:
 * 	整型字符串数组cars[]，其中1表示有车，0表示没车，数组长度小于1000。
 *
 * 输出描述：
 * 	整型数字字符串，表示最少停车数目。
 *
 * 示例1：
 * 	输入：
 * 		1,0,1
 * 		1
 * 	输出：
 * 		2
 * 说明：
 * 	1个小车占第1个车位
 * 	第二个车位空
 * 	1个小车占第3个车位
 * 	最少有两辆车
 *
 * 示例 2：
 * 输入：
 * 	1,1,0,0,1,1,1,0,1
 * 	1
 * 输出：
 * 	3
 * 说明：
 * 	1个货车占第1、2个车位
 * 	第3、4个车位空
 * 	1个卡车占第5、6、7个车位
 * 	第8个车位空
 * 	1个小车占第9个车位
 * 	最少3辆车
 */
public class _停车场车辆统计_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().replace(",", "").toCharArray();
        int car = 0;
        int length = chars.length;

        for (int left = 0; left < length; left++) {
            // 如果是1，表示有车占用
            if (chars[left] == '1') {
                int right = left + 1;

                // 统计被连续占用的车位数量
                while (right < length && chars[right] == '1') {
                    right++;
                }

                // 先用卡车来占车位、再用货车占车用，最后用小车来占车位
                int size = right - left;
                car += (size / 3);
                size %= 3;
                car += (size / 2);
                size %= 2;
                car += size;
                left = right;
            }
        }

        System.out.println(car);
    }

}
