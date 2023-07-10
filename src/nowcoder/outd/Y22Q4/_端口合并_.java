package nowcoder.outd.Y22Q4;

import java.util.*;

/**
 * 有 M(1 <=M<= 10) 个端口组
 * 每个端口组是长度为 N(1<=N<=100)的整数数组，如果端口组间存在2个及以上不同端口相同，则认为这2个端口组 互相关联，可以合并
 * 第一行输入端口组个数M，再输入M行，每行逗号分隔，代表端口组。输出合并后的端口组，用二维数组表示
 *
 * 输入描述：
 * 	第一行输入一个数字M
 * 	第二行开始输入M行，每行是长度为 N 的整数数组，用逗号分割
 *
 * 输出描述：
 * 	合并后的二维数组，用二维数组表示
 * 	1：组合内同端口仅保留一个，并从小到大排序。
 * 	2：组合外顺序保持输入顺序。
 *
 * 示例1：
 * 	输入：
 * 		4
 * 		4
 * 		2,3,2
 * 		1,2
 * 		5
 * 	输出：
 * 		[[4],[2,3],[1,2],[5]]
 *
 * 示例2：
 * 	输入：
 * 		3
 * 		2,3,1
 * 		4,3,2
 * 		5
 * 	输出：
 * 		[[1,2,3,4],[5]]
 *
 * 示例3：
 * 	输入：
 * 		6
 * 		10
 * 		4,2,1
 * 		9
 * 		3,6,9,2
 * 		6,3,4
 * 		8
 * 	输出：
 * 		[[10],[1,2,3,4,6,9],[9],[8]]
 */
public class _端口合并_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = Integer.parseInt(scanner.nextLine());
        List<Set<Integer>> ports = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] split = scanner.nextLine().split(",");
            Set<Integer> port = new HashSet<>();
            for (String s : split) {
                port.add(Integer.parseInt(s));
            }
            ports.add(port);
        }

        // 合并端口组
        while (true) {
            Set<int[]> mergeIndex = new HashSet<>();
            // 两两检查是否可以合并
            for (int i = 0; i < ports.size(); i++) {
                for (int j = i + 1; j < ports.size(); j++) {
                    int countSame = 0;
                    Set<Integer> cur = ports.get(i);
                    Set<Integer> pre = ports.get(j);

                    for (Integer element : cur) {
                        if (pre.contains(element) && countSame++ >= 2) {
                            break;
                        }
                    }
                    // 两个端口组可以合并成一个
                    if (countSame >= 2) {
                        mergeIndex.add(new int[] {Math.min(i, j), Math.max(i, j)});
                    }
                }
            }

            // 需要合并
            if (!mergeIndex.isEmpty()) {
                List<Set<Integer>> tmp = new ArrayList<>();
                int size = ports.size();
                // 标记有那些端口组已经被访问过了
                int[] visite = new int[size];
                for (int i = 0; i < size; i++) {
                    if (visite[i] >= 1) {
                        // 被访问过了
                        continue;
                    }

                    Set<Integer> set = ports.get(i);
                    for (int[] index : mergeIndex) {
                        if (index[0] == i || index[1] == i) {
                            if (index[0] == i) {
                                set.addAll(ports.get(index[1]));
                            } else {
                                set.addAll(ports.get(index[0]));
                            }
                            // 标记两个已经被访问过的端口组为访问过
                            visite[index[0]]++;
                            visite[index[1]]++;
                        }
                    }

                    // 合并之后的端口组添加到临时的结果中
                    tmp.add(set);
                }
                // 更新合并后的端口组
                ports = tmp;
            } else {
                // 不存在有两个相同元素的不同组了
                break;
            }
        }

        // 输出
        System.out.print("[");
        for (int i = 0; i < ports.size(); i++) {
            if (i != 0) {
                System.out.print(",[");
            } else {
                System.out.print("[");
            }

            Set<Integer> set = ports.get(i);
            int index = 0;
            for (Integer element : set) {
                if (index++ == 0) {
                    System.out.print(element);
                } else {
                    System.out.print("," + element);
                }
            }
            System.out.print("]");
        }
        System.out.print("]");
    }

}
