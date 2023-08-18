package nowcoder.outd.Y22Q3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 服务之间交换的接口成功率作为服务调用关键质量特性，
 * 某个时间段内的接口失败率使用一个数组表示，数组中每个元素都是单位时间内失败率数值，数组中的数值为0~100的整数，
 * 给定一个数值(minAverageLost)表示某个时间段内平均失败率容忍值，即平均失败率 小于等于minAverageLost.
 * 找出数组中最长时间段，如果未找到则直接返回NULL。
 *
 * 输入描述：
 * 	输入有两行内容，
 * 	第一行为minAverageLost，
 * 	第二行为数组，数组元素通过空格(" ")分隔,
 * 	minAverageLost及数组中元素取值范围为 0~100 的整数，数组元素的个数不会超过100个
 *
 * 输出描述：
 * 	找出平均值小于等于minAverageLost的最长时间段，
 * 	输出数组下标对，格式{beginIndex}-{endIndex}%(下标从0开始)，
 * 	如果同时存在多个最长时间段，则输出多个下标对且下标对之间使用空格(" ")拼接，
 * 	多个下标对按下标从小到大排序。
 *
 * 示例1：
 * 	输入：
 * 		1
 * 		0 1 2 3 4
 * 	输出：
 * 		0 2
 * 解释：minAverageLost=1，数组[0,1,2,3,4]前3个元素的平均值为1，因此数组第一个至第三个数组下标，即0-2
 *
 * 示例2：
 * 	输入：
 * 	    2
 * 		0 0 100 2 2 99 0 2
 * 	输出：
 * 		0-1 3-4 6-7
 * 说明：
 * 	minAverageLost=2，数组[0,0,100,2,2,99,0,2]
 * 	通过计算小于等于2的最长时间段为:
 * 		数组下标为0-1即[0,0]，
 * 		数组下标为3-4即[2,2]，
 * 		数组下标为6-7即[0,2]，
 * 	这三个部分都满足平均值小于等于2的要求，
 * 	因此输出：0-1 3-4 6-7
 */
public class _查找接口成功率最优时间段_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int minAverageLost = Integer.parseInt(scanner.nextLine());
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();



        m1(array, minAverageLost);
    }

    private static void m1(int[] array, int minAverageLost) {
        List<int[]> res = new ArrayList<>();
        int max = 0;
        int n = array.length;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += array[j];
                if (minAverageLost * (j - i + 1) >= sum) {
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        res.clear();
                        res.add(new int[] {i, j});
                    } else if (j - i + 1 == max){
                        res.add(new int[] {i, j});
                    }
                }
            }
        }

        for (int i = 0; i < res.size(); i++) {
            if (i != 0) {
                System.out.print(" ");
            }
            System.out.print(res.get(i)[0] + "-" + res.get(i)[1]);
        }
    }

}
