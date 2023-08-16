package nowcoder.outd.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 某实验室计算机待处理任务以 [start,end,period] 格式记于二维数组 tasks，
 * 表示完成该任务的时间范围：为起始时间 start 至结束时间 end 之间，需要计算机投入 period 的时长，
 * 注意：
 * 	period 可为不连续时间
 * 	首尾时间均包含在内
 * 处于开机状态的计算机可同时处理任意多个任务，请返回电脑最少开机多久，可处理完所有任务。
 * 提示：
 * 	2 <= tasks.length <= 10^5
 * 	tasks[i].length == 3
 * 	0 <= tasks[i][0] <= tasks[i][1] <= 10^9
 * 	1 <= tasks[i][2] <= tasks[i][1]-tasks[i][0] + 1
 *
 * 示例1：
 * 	输入：
 * 		tasks = [[1,3,2],[2,5,3],[5,6,2]]
 * 	输出：
 * 		4
 * 解释：
 * 	tasks[0] 选择时间点 2、3；
 * 	tasks[1] 选择时间点 2、3、5；
 * 	tasks[2] 选择时间点 5、6；
 * 	因此计算机仅需在时间点 2、3、5、6 四个时刻保持开机即可完成任务。
 *
 * 示例2：
 * 	输入：
 * 		tasks = [[2,3,1],[5,5,1],[5,6,2]]
 * 	输出：
 * 		3
 * 解释：
 * 	tasks[0] 选择时间点 2 或 3；
 * 	tasks[1] 选择时间点 5；
 * 	tasks[2] 选择时间点 5、6；
 * 	因此计算机仅需在时间点 2、5、6 或 3、5、6 三个时刻保持开机即可完成任务。
 */
public class _批量处理任务_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int index = line.indexOf("[");
        String[] split = line.substring(index + 2, line.length() - 2).replace("],[", "#").split("#");
        int n = split.length;
        int[][] tasks = new int[n][3];

        for (int i = 0; i < n; i++) {
            String[] tmp = split[i].split(",");
            tasks[i][0] = Integer.parseInt(tmp[0]);
            tasks[i][1] = Integer.parseInt(tmp[1]);
            tasks[i][2] = Integer.parseInt(tmp[2]);
        }

        System.out.println("二分查找优化贪心后的结果：");
        binary(tasks);
        System.out.println("暴力贪心结果：");

        // 按照每个任务的 end 时间点进行排序
        Arrays.sort(tasks, (a, b)->a[1] - b[1]);
        // 以最后一个任务的结束时间为长度，创建一个：标记计算机在某时间点是否在运行
        boolean[] run = new boolean[tasks[n - 1][1] + 1];
        int res = 0;

        for (int[] item : tasks) {
            // 任务的起始时间、结束时间、运行时间
            int start = item[0];
            int end = item[1];
            int period = item[2];

            // 从任务的的结束时间开始遍历，减去已经运行掉的时间
            for (int i = end; i >= start && period > 0; i--) {
                if (run[i]) {
                    period--;
                }
            }

            // 如果该任务还需要额外的时间才能运行结束，优先开启靠结束时间近的时间点
            for (int i = end; i >= start && period > 0; i--) {
                if (!run[i]) {
                    run[i] = true;
                    period--;
                    res++;
                }
            }
        }

        // 统计运行的时间
        System.out.println(res);
    }

    private static void binary(int[][] tasks) {
        // 按照每个任务的 end 时间点进行排序
        Arrays.sort(tasks, (a, b)->a[1] - b[1]);
        List<int[]> st = new ArrayList<>();
        // 闭区间左右端点，栈底到栈顶的区间长度和
        st.add(new int[] {-2, -2, 0});

        for (int[] item : tasks) {
            // 任务的起始时间、结束时间、运行时间
            int start = item[0];
            int end = item[1];
            int period = item[2];

            int index = lowerBound(st, start);
            int[] e = st.get(index - 1);
            // 去掉运行了的时间点
            period -= st.get(st.size() - 1)[2] -e[2];

            // start 在区间 st[i]内
            if (start <= e[1]) {
                // 去掉运行中的时间点
                period -= e[1] - start + 1;
            }

            // 已经完成该任务
            if (period <= 0) {
                continue;
            }

            // 剩余的 period 填充区间后缀
            while (end - st.get(st.size() - 1)[1] <= period) {
                e = st.remove(st.size() - 1);
                // 合并区间
                period += e[1] - e[0] + 1;
            }
            st.add(new int[] {end - period + 1, end, st.get(st.size() - 1)[2] + period});
        }

        System.out.println(st.get(st.size() - 1)[2]);
    }

    // 二分查找，开区间写法
    private static int lowerBound(List<int[]> st, int target) {
        // 开区间：(left, right)
        int left = -1;
        int right = st.size();

        // 区间不为空
        while (left + 1 < right) {
            // 循环不变量
            int mid = (right - left) / 2 + left;
            if (st.get(mid)[0] < target) {
                // 缩小范围大到 (mid, right)
                left = mid;
            } else {
                // 缩小范围大到 (left, mid)
                right = mid;
            }
        }

        return right;
    }

}
