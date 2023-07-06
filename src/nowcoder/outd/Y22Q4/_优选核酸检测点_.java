package nowcoder.outd.Y22Q4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 张三要去外地出差，需要做核酸，需要在指定时间点前做完核酸，请帮他找到满足条件的核酸检测点。
 *         .给出一组核酸检测点的 距离和每个核酸检测点当前的人数
 *         .给出张三要去做核酸的出发时间出发时间，是10分钟的倍数，同时给出张三做核酸的最晚结束时间
 *         .题目中给出的距离是整数，单位是公里，时间1分钟为一基本单位
 * 去找核酸点时，有如下的限制：
 *         .去往核酸点的路上，每公里距离花费时间10分钟，费用是10元
 *         .核酸点每检测一个人的时间花费是1分钟
 *         .每个核酸点工作时间都是8点到20点中间不休息核酸点准时工作，早到晚到都不检测
 * .核酸检测结果可立刻知道
 *         .在张三去某个核酸点的路上花费的时间内，此核酸检测点的人数是动态变化的，变化规则是
 *         .在非核酸检测时间内，没有人排队
 *         .8点-10点每分钟增加3人
 *         .12点-14点每分钟增加10人
 * 要求将所有满足条件的核酸检测点按照优选规则排序列出：优选规则：
 *         .花费时间最少的核酸检测点排在前面。
 *         .花费时间一样,花费费用最少的核酸检测点排在前面。
 *         .时间和费用一样，则ID值最小的排在前面
 *
 * 输入描述：
 * 	H1 M1
 * 	H2 M2
 * 	N
 * 	ID1 D1 C1
 * 	ID2 D2 C2
 * 	...
 * 	IDn Dn Cn
 * 	H1：当前时间的小时数。M1：当前时间的分钟数，
 * 	H2：指定完成核算时间的小时数。M2：指定完成核算时间的分钟数。
 * 	N： 所有核酸检测点个数。
 * 	ID1：核酸点的ID值。D1：核酸检测点距离张三的距离。C1：核酸检测点当前检测的人数。
 *
 * 输出描述:
 * 	N
 * 	I2 T2 M2
 * 	I3 T3 M3
 * 	N：满足要求的核酸检测点个数
 * 	I2: 选择后的核酸检测点ID
 * 	T2: 做完核酸花费的总时间(分钟)
 * 	M2: 去该核算点花费的费用
 *
 * 示例一：
 * 输入：
 * 	10 30
 * 	14 50
 * 	3
 * 	1 10 19
 * 	2 8 20
 * 	3 21 3
 * 输出：
 * 	2
 * 	2 80 80
 * 	1 190 100
 */
public class _优选核酸检测点_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split(" ");
        // 出发时间、最晚做完核算的限制时间——转换成分钟数
        int startTime = Integer.parseInt(line[0]) * 60 + Integer.parseInt(line[1]);
        line = scanner.nextLine().split(" ");
        int endTime = Integer.parseInt(line[0]) * 60 + Integer.parseInt(line[1]);
        // n 个监测点
        int n = Integer.parseInt(scanner.nextLine());
        int[][] points = new int[n][3];
        for (int i = 0; i < n; i++) {
            line = scanner.nextLine().split(" ");
            // 监测点的Id、距离、人数
            points[i] = new int[] {Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2])};
        }

        // 8点、10点、12点、14点对应的分钟
        int eight = 8 * 60;
        int ten = 10 * 60;
        int twelve = 12 * 60;
        int fourteen = 14 * 60;
        List<int[]> res = new ArrayList<>();
        // 时间——路程时间（打车时间 + 队伍新增人时间 - 监测点监测人数减少） + 排队时间
        for (int i = 0; i < n; i++) {

            // 打车到监测点花费时间
            int car = points[i][1] * 10;
            // 打车时，正号在 [8~10]、[12~14] 之间的时间
            int peak = 0;
            //
            if (startTime + car > endTime) {
                // 坐车过去已经超出时间了
                continue;
            }

            // 在车上时，队伍新增人数
            if ((startTime >= eight && startTime <= ten) || (startTime + car >= eight && startTime + car <= ten)) {

                // 计算打车时间和 8~10 点重合的时间
                if (startTime + car <= ten) {
                    peak = startTime + car - Math.max(startTime, eight);
                } else if (startTime >= eight) {
                    peak = Math.min(startTime + car, ten) - startTime;
                }

                // 队伍新增人数变化： 不在 8~10 点区间的时候，队伍人数也在减少, 每分钟新增3个人，检测完一个人,且
                points[i][2] = Math.max(0, (points[i][2] - car - peak));
                points[i][2] += 2 * peak;
            } else if ((startTime >= twelve && startTime <= fourteen) || (startTime + car >= twelve && startTime + car <= fourteen)) {
                // 计算打车时间和 8~10 点重合的时间
                if (startTime + car <= fourteen) {
                    peak = startTime + car - Math.max(startTime, twelve);
                } else if (startTime >= twelve) {
                    peak = Math.min(startTime + car, fourteen) - startTime;
                }

                // 队伍新增人数 = 每分钟新增10个人，检测完一个人,且不在 8~10 点区间的时候，队伍人数也在减少
                points[i][2] = Math.max(0, (points[i][2] - car - peak));
                points[i][2] += 9 * peak;
            } else {
                // 打车时间不在 [8~10]、[12~14] 之间，人在车上的时候，核酸队伍人数在减少
                points[i][2] = Math.max(0, (points[i][2] - car));
            }

            // 到达核算监测点之后，排队，做完时间没有超过限制的时间，说明该监测点可以
            if (startTime + car + points[i][2] <= endTime) {
                res.add(new int[] {car + points[i][2], car, points[i][0]});
            }
        }

        // 按照时间、费用、Id排序
        Collections.sort(res, (a, b)->{
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            return a[2] - b[2];
        });

        int size = res.size();
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            System.out.println(res.get(i)[2] + " " + res.get(i)[0] + " " + res.get(i)[1]);
        }
    }

}
