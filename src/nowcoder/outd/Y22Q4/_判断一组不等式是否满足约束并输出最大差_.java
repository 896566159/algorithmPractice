package nowcoder.outd.Y22Q4;

import java.util.Scanner;

/**
 * 给定一组不等式，判断是否成立并输出不等式的最大差(输出浮点数的整数部分)
 * 要求:
 * 1)不等式系数为 double类型，是一个二维数组
 * 2)不等式的变量为 int 类型，是一维数组;
 * 3)不等式的目标值为 double 类型，是一维数组
 * 4)不等式约束为字符串数组，只能是:”>”,”>=”,”<“,”=”，
 * 例如，不等式组:
 * a11 * x1 + a12 * x2 + a13 * x3 + a14 * x4 + a15 * x5 <= b1;
 * a21 * x1 + a22 * x2 + a23 * x3 + a24 * x4 + a25 * x5 <= b2;
 * a31 * x1 + a32 * x2 + a33 * x3 + a34 * x4 + a35 * x5 <= b3;
 * 最大差 = max{(a11x1+a12x2+a13x3+a14x4+a15x5-b1),(a21x1+a22x2+a23x3+a24x4+ a25x5-b2),(a31x1+a32x2+a33x3+a34x4+a35x5-b3)},
 * 类型为整数(输出浮点数的整数部分)
 * 输入描述：
 * 1)不等式组系数(double类型):
 * 	a11,a12,a13,a14,a15
 * 	a21,a22,a23,a24,a25
 * 	a31,a32,a33,a34,a35
 * 2)不等式变量(int类型):x1, x2, x3, x4, x5
 * 3)不等式目标值(double类型): b1, b2, b3
 * 4)不等式约束(字符串类型):<=, <=, <=
 * 输入：
 * 	a11,a12,a13,a14,a15;a21,a22,a23,a24,a25;a31,a32,a33,a34,a35;x1,x2,x3,x4,x5;b1,b2,b3;<=,<=,<=
 * 输出描述：
 * 	true 或者 false，最大差
 *
 * 示例1：
 * 	输入：
 * 		2.3,3,5.6,7,6;11,3,8.6,25,1;0.3,9,5.3,66,7.8;1,3,2,7,5;340,670,80.6;<=,<=,<=
 * 	输出:
 * 		false,458
 * 说明:
 * 	2.3   ×   1   +   3   ×   3   +   5.6   ×   2   +   7   ×   7   +   6   ×   5   -   340 = -238.5
 * 	11   ×   1   +   3   ×   3   +   8.6   ×   2   +   25   ×   7   +   5   ×   1   -   670 = -452.8
 * 	0.3   ×   1   +   9   ×   3   +   5.3   ×   2   +   66   ×   7   +   7.8   ×   5   -   80.6 = 458.3
 * 	前两个不满足不等式，所以输出为false。
 * 	然后计算三个差值中的最大值，取整数部分。
 *
 * 示例2：
 * 	输入:
 * 		2.36,3,6,7.1,6;1,30,8.6,2.5,21;0.3,69,5.3,6.6,7.8;1,13,2,17,5;340,67,300.6;<=,>=,<=
 * 	输出
 * 		false 758
 */
public class _判断一组不等式是否满足约束并输出最大差_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] split = line.split(";");
        double[][] arr = new double[3][5];
        int[] coefficient  = new int[5];
        double[] inputResult = new double[3];
        int max = Integer.MIN_VALUE;

        // 初始化a11-a35
        int index = 0;
        String[] segment;
        for (int i = 0; i < 3; i++) {
            segment = split[i].split(",");
            index = 0;
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Double.parseDouble(segment[index++]);
            }
        }

        // 初始化系数
        index = 0;
        segment = split[3].split(",");
        for (int i = 0; i < 5; i++) {
            coefficient[i] = Integer.parseInt(segment[index++]);
        }

        // 初始化不等式的右边
        index = 0;
        segment = split[4].split(",");
        for (int i = 0; i < 3; i++) {
            inputResult[i] = Double.parseDouble(segment[index++]);
        }

        // 计算并判断
        index = 0;
        segment = split[5].split(",");
        boolean isRight = true;
        for (int i = 0; i < 3; i++) {
            double sum = 0;
            for (int j = 0; j < 5; j++) {
                sum += arr[i][j] * coefficient[j];
            }

            if (isRight) {
                if (segment[i].equals(">")) {
                    isRight = sum > inputResult[i];
                } else if (segment[i].equals(">=")) {
                    isRight = sum >= inputResult[i];
                } else if (segment[i].equals("=")) {
                    isRight = sum == inputResult[i];
                } else if (segment[i].equals("<=")) {
                    isRight = sum <= inputResult[i];
                } else if (segment[i].equals("<")) {
                    isRight = sum < inputResult[i];
                }
            }
            max = (int) Math.max(max, sum - inputResult[i]);
        }

        System.out.println(isRight + " " + max);
    }

}
