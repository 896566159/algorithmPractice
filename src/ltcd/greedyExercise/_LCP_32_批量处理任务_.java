package ltcd.greedyExercise;

import java.util.*;

public class _LCP_32_批量处理任务_ {

    public static void main(String[] args) {
        _LCP_32_批量处理任务_ v = new _LCP_32_批量处理任务_();
        System.out.println(v.processTasks2(new int[][]{{1, 3, 2}, {2, 5, 3}, {5, 6, 2}}));
    }

    // 方法二：二分查找
    public int processTasks2(int[][] tasks) {
        // 排序
        Arrays.sort(tasks, (a, b)->a[1] - b[1]);
        List<int[]> st = new ArrayList<>();
        // 闭区间左右端点，栈底到栈顶的区间长度和
        st.add(new int[] {-2, -2, 0});

        for (int[] task : tasks) {
            // 任务起始/结束时间/任务耗时时长
            int start = task[0];
            int end = task[1];
            int d = task[2];

            int[] e = st.get(lowerBound(st, start) - 1);
            // 去掉运行中的时间点
            d -= st.get(st.size() - 1)[2] - e[2];

            // start 在区间 st[i]内
            if (start <= e[1]) {
                // 去掉运行中的时间点
                d -= e[1] - start + 1;
            }
            if (d <= 0) {
                continue;
            }

            // 剩余的 d 填充区间后缀
            while (end - st.get(st.size() - 1)[1] <= d) {
                e = st.remove(st.size() - 1);
                // 合并区间
                d += e[1] - e[0] + 1;
            }
            st.add(new int[] {end - d + 1, end, st.get(st.size() - 1)[2] + d});
        }

        return st.get(st.size() - 1)[2];
    }

    // 二分查找，开区间写法
    private int lowerBound(List<int[]> st, int target) {
        // 开区间： (left, right)
        int left = -1;
        int right = st.size();

        // 区间不为空
        while (left + 1 < right) {
            // 循环不变量
            // st[left] < target
            // st[right] >= target
//            int mid = (right - left) / 2 + left;
            int mid = (left + right) >>> 1;
            if (st.get(mid)[0] < target) {
                // 缩小范围到 (mid, right)
                left = mid;
            } else {
                // 缩小范围到 (left, mid)
                right = mid;
            }
        }

        // 或者 left+1
        return right;
    }

    // 方法一：暴力，超时
    public int processTasks(int[][] tasks) {
        // 排序
        Arrays.sort(tasks, (a, b)->a[1] - b[1]);
        int ans = 0;
        boolean[] run = new boolean[tasks[tasks.length - 1][1] + 1];

        for (int[] task : tasks) {
            // 任务起始/结束时间/任务耗时时长
            int start = task[0];
            int end = task[1];
            int d = task[2];

            for (int i = start; i < end; i++) {
                if (run[i]) {
                    // 去掉运行中的时间点
                    --d;
                }
            }

            // 剩余的 d 填充区间后缀
            for (int i = end; d > 0; i--) {
                if (!run[i]) {
                    run[i] = true;
                    --d;
                    ++ans;
                }
            }
        }

        return ans;
    }

    // 方法一：暴力，优化
    public int processTasks3(int[][] tasks) {
        // 排序
        Arrays.sort(tasks, (a, b)->a[1] - b[1]);
        int ans = 0;
        Set<Integer> run = new HashSet<>();

        for (int[] task : tasks) {
            // 任务起始/结束时间/任务耗时时长
            int start = task[0];
            int end = task[1];
            int d = task[2];

            for (int i = start; i < end; i++) {
                if (run.contains(i)) {
                    // 去掉运行中的时间点
                    --d;
                }
            }

            // 剩余的 d 填充区间后缀
            for (int i = end; d > 0; i--) {
                if (!run.contains(i)) {
                    run.add(i);
                    --d;
                    ++ans;
                }
            }
        }

        return ans;
    }


}
