package nowcoder.outd.Y22Q4;

import java.util.*;

/**
 * VLAN是一种对局域网设备进行逻辑划分的技术，为了标识不同的VLAN，引入VLAN ID(1-4094之间的整数)的概念。
 * 定义一个 VLAN ID 的资源池(下称VLAN资源池)，资源池中连续的 VLAN 用 开始VLAN-结束VLAN 表示，不连续的用单个整数表示，所有的VLAN用英文逗号连接起来。
 * 现在有一个VLAN资源池，业务需要从资源池中申请一个VLAN，需要你输出从 VLAN资源池中移除申请的VLAN后的资源池。
 * 输入描述:
 * 	第一行为字符串格式的VLAN资源池，
 * 	第二行为业务要申请的VLAN，VLAN的取值范围为[1,4094]之间的整数。
 * 输出描述:
 * 	从输入VLAN资源池中移除申请的VLAN后字符串格式的VLAN资源池，输出要求满足题目描述中的格式，并且按照VLAN从小到大升序输出。
 * 	如果申请的VLAN不在原VLAN资源池内，输出原VLAN资源池升序排序后的字符串即可。
 *
 * 示例1：
 * 	输入:
 * 		1-5
 * 		2
 * 	输出:
 * 		1,3-5
 * 说明:
 * 	原VLAN资源池中有VLAN 1、2、3、4、5，从资源池中移除2后，剩下VLAN 1、3、4、5，按照题目描述格式并升序后的结果为1,3-5。
 *
 * 示例2：
 * 	输入:
 * 		20-21,15,18,30,5-10
 * 		15
 * 	输出:
 * 		5-10,18,20-21,30
 * 说明:
 * 	原VLAN资源池中有VLAN 5、6、7、8、9、10、15、18、20、21、30，从资源池中移除15后，资源池中剩下的VLAN为 5、6、7、8、9、10、18、20、21、30，按照题目描述格式并升序后的结果为5-10,18,20-21,30。
 *
 * 示例3：
 * 	输入:
 * 		5,1-3
 * 		10
 * 	输出:
 * 		1-3,5
 * 说明:
 * 	原VLAN资源池中有VLAN 1、2、3，5，申请的VLAN 10不在原资源池中，将原资源池按照题目描述格式并按升序排序后输出的结果为1-3,5。
 *
 * 备注：
 * 	输入VLAN资源池中VLAN的数量取值范围为[2-4094]间的整数，资源池中VLAN不重复且合法([1,4094]之间的整数)，输入是乱序的。
 */
public class _VLAN资源池_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int vlanId = Integer.parseInt(scanner.nextLine());
        String[] split = line.split(",");
        int n = split.length;
        List<int[]> intervals = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String id = split[i];

            int[] interval = new int[2];
            // 有 “-” 符号说明是一个区间
            if (id.contains("-")) {
                String[] points = id.split("-");
                interval[0] = Integer.parseInt(points[0]);
                interval[1] = Integer.parseInt(points[1]);
            } else {
                interval[0] = Integer.parseInt(id);
                interval[1] = Integer.parseInt(id);
            }

            intervals.add(interval);
        }

        // 排序
        Collections.sort(intervals, (a, b)->a[0] - b[0]);

        // 删除申请的 VLAN
        for (int i = 0; i < n; i++) {
            // 要删除的 id 不会包含在后面的任何一个区间内
            if (intervals.get(i)[0] > vlanId) {
                break;
            }

            // 要删除的 id 所在区间已经被找到
            if (intervals.get(i)[0] <= vlanId && intervals.get(i)[1] >= vlanId) {
                if (intervals.get(i)[0] == intervals.get(i)[1]) {
                    // 如果该区间只有一个 id
                    intervals.remove(i);
                } else {
                    // 该区间有多个 id，且删除目标 id 后区间一分为二
                    intervals.add(i, new int[]{vlanId + 1, intervals.get(i)[1]});
                    intervals.add(i, new int[]{intervals.get(i + 1)[0], vlanId - 1});
                    intervals.remove(i + 2);
                }

                break;
            }
        }

        // 输出
        int size = intervals.size();
        for (int i = 0; i < size - 1; i++) {
            if (intervals.get(i)[0] == intervals.get(i)[1]) {
                System.out.print(intervals.get(i)[0] + ",");
            } else {
                System.out.print(intervals.get(i)[0] + "-" + intervals.get(i)[1] + ",");
            }
        }
        if (intervals.get(size - 1)[0] == intervals.get(size - 1)[1]) {
            System.out.println(intervals.get(size - 1)[0]);
        } else {
            System.out.println(intervals.get(size - 1)[0] + "-" + intervals.get(size - 1)[1]);
        }

    }

}
