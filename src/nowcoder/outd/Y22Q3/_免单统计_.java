package nowcoder.outd.Y22Q3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 某商城举办了一个促销活动，
 * 如果某顾客是某一秒内第一个下单的顾客（可能是多个人），则可以 获取免单。
 * 请你编程计算有多少顾客可以获取免单。
 * 解答要求：
 * 	时间限制：3000ms, 内存限制：64MB ，
 * 输入：
 * 	输入为n行数据，每一行表示一位顾客的下单时间。
 * 	以（年-月-日 时-分-秒.毫秒）yyyy-MM-dd HH:mm:ss.fff形式给出。
 * 	0<n<50000
 * 	2000<yyyy<2020
 * 	0<MM<=12
 * 	0<dd<=28
 * 	0<=HH<=23
 * 	0<=mm<=59
 * 	0<=ss<=59
 * 	0<=fff<=999
 * 	所有输入保证合法。
 * 输出：
 * 	输出一个整数，表示有多少顾客可以获取免单。
 *
 * 样例：
 * 	输入：
 * 		2019-01-01 00:00:00.001
 * 		2019-01-01 00:00:00.002
 * 		2019-01-01 00:00:00.003
 * 	输出：
 * 		1
 *
 *
 * 样例2：
 * 	输入：
 * 		2019-01-01 08:59:00.123
 * 		2019-01-01 08:59:00.123
 * 		2018-12-28 10:08:00.999
 * 	输出：
 * 		3
 */
public class _免单统计_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> map = new HashMap<>();
        int count = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("")) {
                break;
            }

            // 截取出秒钟
            String s1 = line.substring(0, line.length() - 4);

            if (!map.containsKey(s1)) {
                map.put(s1, line);
                count++;
            } else {
                // 同一时间多人购买
                if (line.equals(map.get(s1))) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

}
