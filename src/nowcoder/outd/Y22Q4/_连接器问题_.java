package nowcoder.outd.Y22Q4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 有一组区间[a0，b0]，[a1，b1]，…（a，b表示起点，终点），区间有可能重叠、相邻，重叠或相邻则可以合并为更大的区间；
 * 给定一组连接器[x1，x2，x3，…]（x表示连接器的最大可连接长度，即 x >= gap），可用于将分离的区间连接起来，但两个分离区间之间只能使用 1 个连接器；
 * 请编程实现使用连接器后，最少的区间数结果。
 *
 * 区间数量 < 10000，a,b均 <= 10000
 * 连接器数量 < 10000；x <= 10000
 *
 * 输入描述：
 * 	区间组：[1,10],[15,20],[18,30],[33，40]
 * 	连接器组：[5,4,3,2]
 * 输出描述：
 * 	1
 * 说明：
 * 	合并后：[1,10],[15,30],[33,40]，使用5, 3两个连接器连接后只剩下 [1, 40]。
 *
 * 示例1：
 * 	输入：
 * 		[1,10],[15,20],[18,30],[33,40]
 * 		[5,4,3,2]
 * 	输出：
 * 		1
 * 说明：
 * 	合并后：[1,10], [15,30], [33,40]，使用5, 3两个连接器连接后只剩下[1,40]。
 */
public class _连接器问题_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().replace("[", "").replace("]", "").split(",");
        String[] split1 = scanner.nextLine().replace("[", "").replace("]", "").split(",");
        int n = split.length;
        int[][] intervals = new int[n / 2][2];
        int[] connectors = new int[split1.length];

        // 区间
        int index = 0;
        for (int i = 0; i < n; i += 2) {
            intervals[index++] = new int[] {Integer.parseInt(split[i]), Integer.parseInt(split[i + 1])};
        }
        // 链接器
        for (int i = 0; i < split1.length; i++) {
            connectors[i] = Integer.parseInt(split1[i]);
        }

        // 排序
        Arrays.sort(intervals, (a, b)->{return a[0] != b[0] ? a[0] - b[0] : a[1] - b[1];});
        Arrays.sort(connectors);

        // 合并有交集的区间
        List<int[]> merge = new ArrayList<>();
        int[] pre = intervals[0];
        merge.add(pre);
        for (int i = 1; i < n / 2; i++) {
            // 如果上一个区间的结束 >= 当前区间的结束，说明两个区间有交集
            if (pre[1] >= intervals[i][0]) {
                pre = new int[] {pre[0], Math.max(pre[1], intervals[i][1])};
                merge.set(merge.size() - 1, pre);
            } else {
                // 没有交集
                merge.add(intervals[i]);
                pre = intervals[i];
            }
        }

        // 开始使用链接器来连接没有交集的区间
        for (int i = 0; i < connectors.length; i++) {
            int connector = connectors[i];
            int min = 0;
            index = -1;

            for (int j = 0; j < merge.size(); j++) {
                if (j + 1 < merge.size()) {
                    if (merge.get(j + 1)[0] - merge.get(j)[1] <= connector && merge.get(j + 1)[0] - merge.get(j)[1] >= min) {
                        min = merge.get(j + 1)[0] - merge.get(j)[1];
                        index = j;
                    }
                }
            }

            // 链接器太短，不足以连接任何两个区间
            if (index == -1) {
                continue;
            }

            // 合并 index 和 index + 1 这两个区间
            merge.get(index)[1] = merge.get(index + 1)[1];
            merge.remove(index + 1);
        }

        System.out.println(merge.size());
    }

}
