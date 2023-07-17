package nowcoder.outd.Y22Q4;

import java.util.*;

/**
 * 某通信网络中有N个网络结点，用1到N进行标识。
 * 网络中的结点互联互通，且结点之间的消息传递有时延，相连结点的时延均为一个时间单位。
 * 现给定网络结点的连接关系 link[i]={u，v}，其中u和v表示网络结点。
 * 当指定一个结点向其他结点进行广播，所有被广播结点收到消息后都会在原路径上回复一条响应消息，请计算发送结点至少需要等待几个时间单位才能收到所有被广播结点的响应消息。
 * 注：
 * 	N的取值范围为[1，100];
 * 	连接关系link的长度不超过3000，且1 <= u,v <= N;
 * 	网络中任意结点间均是可达的;
 * 输入描述：
 * 	输入的第一行为两个正整数，分别表示网络结点的个数N，以及时延列表的长度T；
 * 	接下来的T行输入，表示结点间的连接关系列表；
 * 	最后一行的输入为一个正整数，表示指定的广播结点序号；
 * 输出描述：
 * 	输出一个整数，表示发送结点接收到所有响应消息至少需要等待的时长。
 *
 * 示例：
 * 	输入：
 * 		5 7
 * 		1 4
 * 		2 1
 * 		2 3
 * 		2 4
 * 		3 4
 * 		3 5
 * 		4 5
 * 		2
 * 	输出：
 * 		4
 * 说明：
 * 	结点2到5的最小时延为2，到剩余结点的最小时延均为1，所以至少要等待2*2=4s。
 */
public class _最长广播响应_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int m = Integer.parseInt(split[0]);
        int n = Integer.parseInt(split[1]);

        // 使用hashMap存储节点的连接关系
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            if (!map.containsKey(start)) {
                map.put(start, new HashSet<>());
            }
            if (!map.containsKey(end)) {
                map.put(end, new HashSet<>());
            }
            map.get(start).add(end);
            map.get(end).add(start);
        }

        int head = scanner.nextInt();
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(head);
        // 判断是否访问过了
        Set<Integer> visited = new HashSet<>();
        // 最短路径数组
        int[] d = new int[m + 1];
        while (!queue.isEmpty()) {
            Integer poll = queue.pollFirst();
            for (Integer node : map.get(poll)) {
                if (!visited.contains(node)) {
                    visited.add(node);
                    d[node] = d[poll] + 1;
                    queue.add(node);
                }
            }
        }

        // 最远最短路径
        int res = 0;
        for (int i = 0; i < m + 1; i++) {
            res = Math.max(res, d[i]);
        }
        System.out.println(res * 2);
    }

}
