package nowcoder.outd.Y23Q2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 一个有N个选手参加比赛，选手编号为1~N（3<=N<=100），有M（3<=M<=10）个评委对选手进行打分。
 * 打分规则为每个评委对选手打分，最高分10分，最低分1分。
 * 请计算得分最多的3位选手的编号。
 * 如果得分相同，则得分高分值最多的选手排名靠前
 * (10分数量相同，则比较9分的数量，以此类推，用例中不会出现多个选手得分完全相同的情况)。
 *
 * 输入描述:
 * 	第一行为半角逗号分割的两个正整数，第一个数字表示M（3<= M <=10）个评委，第二个数字表示N（3<= N <=100）个选手。
 * 	第2到M+1行是半角逗号分割的整数序列，表示评委为每个选手的打分，0号下标数字表示1号选手分数，1号下标数字表示2号选手分数，依次类推。
 *
 * 输出描述:
 * 	选手前3名的编号。
 * 	注：若输入为异常，输出-1，如M、N、打分不在范围内。
 *
 * 示例1：
 * 	输入：
 * 		4,5
 * 		10,6,9,7,6
 * 		9,10,6,7,5
 * 		8,10,6,5,10
 * 		9,10,8,4,9
 * 	输出：
 * 		2,1,5
 * 说明：
 * 	第一行代表有4个评委，5个选手参加比赛
 * 	矩阵代表是4*5，每个数字是选手的编号，每一行代表一个评委对选手的打分排序，
 * 	2号选手得分36分排第1，1号选手36分排第2，5号选手30分(2号10分值有3个，1号10分值只有1个，所以2号排第一)
 *
 * 示例2：
 * 	输入：
 * 		2,5
 * 		7,3,5,4,2
 * 		8,5,4,4,3
 * 	输出：
 * 		-1
 * 说明：
 * 	只有2个评委，要求最少为3个评委
 *
 * 示例3：
 * 	输入：
 * 		4,2
 * 		8,5
 * 		5,6
 * 		10,4
 * 		8,9
 * 	输出：
 * 		-1
 * 说明：只有2名选手参加，要求最少为3名
 *
 * 示例4：
 * 	输入：
 * 		4,5
 * 		11,6,9,7,8
 * 		9,10,6,7,8
 * 		8,10,6,9,7
 * 		9,10,8,6,7
 * 	输出：
 * 		-1
 * 说明：第一个评委给第一个选手打分11，无效分数
 */
public class _比赛_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            String[] split = scanner.nextLine().split(",");
            if (split.length < 2) {
                System.out.println("-1");
                return;
            }

            int m = Integer.parseInt(split[0]);
            int n = Integer.parseInt(split[1]);
            if (m < 3 || m > 10 || n < 3 || n > 100) {
                System.out.println("-1");
                return;
            }

            // 初始化每个选手的信息
            Object[][] candidates = new Object[n][3];
            for (int i = 0; i < n; i++) {
                candidates[i][0] = 0;
                candidates[i][1] = new ArrayList<>();
                candidates[i][2] = i;
            }

            for (int i = 0; i < m; i++) {
                String[] line = scanner.nextLine().split(",");
                if (line.length < n) {
                    System.out.println("-1");
                    return;
                }

                for (int j = 0; j < n; j++) {
                    int tmp = Integer.parseInt(line[j]);
                    if (tmp < 1 || tmp > 10) {
                        System.out.println("-1");
                        return;
                    }

                    candidates[j][0] = (Integer)candidates[j][0] + tmp;
                    ((ArrayList)(candidates[j][1])).add((char)(tmp + 'a'));
                }
            }

            // 排序
            for (int i = 0; i < n; i++) {
                Collections.sort((ArrayList)(candidates[i][1]), (a, b)->{
                    return (char)b - (char) a;
                });
            }
            Arrays.sort(candidates, (a, b)->{
                if (!a[0].equals(b[0])) {
                    return (Integer)b[0] - (Integer)a[0];
                }
                return ((ArrayList)b[1]).toString().compareTo(((ArrayList)a[1]).toString());
            });

            // 输出
            for (int i = 0; i < 3 && i < n; i++) {
                System.out.println((Integer) candidates[i][2] + 1);
            }
        } catch (Exception e) {
            System.out.println("-1");
        }
    }

}
