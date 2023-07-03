package nowcoder.outd.Y22Q4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 运维工程师采集到某产品线网运行一天产生的日志 n 条
 * 现需根据日志时间先后顺序对日志进行排序
 * 日志时间格式为 H:M:S.N
 * H表示小时(0~23)
 * M表示分钟(0~59)
 * S表示秒(0~59)
 * N表示毫秒(0~999)
 * 时间可能并没有补全
 * 也就是说
 * 01:01:01.001也可能表示为1:1:1.1
 *
 * 输入描述:
 * 	第一行输入一个整数n表示日志条数，1 <= n <= 100000
 * 	接下来 n 行输入 n 个时间
 * 输出描述:
 * 	按时间升序排序之后的时间
 * 	如果有两个时间表示的时间相同
 * 	则保持输入顺序
 *
 * 示例1:
 * 	输入:
 * 		2
 * 		01:41:8.9
 * 		1:1:09.211
 * 	输出:
 * 		1:1:09.211
 * 		01:41:8.9
 * 示例2:
 * 	输入:
 * 		3
 * 		23:41:08.023
 * 		1:1:09.211
 * 		08:01:22.0
 * 	输出:
 * 		1:1:09.211
 * 		08:01:22.0
 * 		23:41:08.023
 * 示例3:
 * 	输入:
 * 		2
 * 		22:41:08.023
 * 		22:41:08.23
 * 	输出:
 * 		22:41:08.023
 * 		22:41:08.23
 * 注：时间相同保持输入顺序
 */
public class _运维日志排序_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Object[]> times = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            // 找到毫秒之前的分隔符
            int index = line.indexOf('.');
            // 计算毫秒数
            int sum = Integer.parseInt(line.substring(index + 1, line.length()));
            // 将 时分秒 截取出来，并转换成毫秒
            String[] hms = line.substring(0, index).split(":");
            int s = Integer.parseInt(hms[2]) + Integer.parseInt(hms[1])  * 60 + Integer.parseInt(hms[0]) * 60 * 60;
            // 将 时间 转成毫秒数输出
            sum += s;

            // 组成元组，方便排序
            Object[] item = {sum, line};
            times.add(item);
        }

        // 排序
        Collections.sort(times, (a, b)->(Integer) a[0] - (Integer) b[0]);

        // 输出
        for (int i = 0; i < n; i++) {
            System.out.println(times.get(i)[1]);
        }
    }

}
