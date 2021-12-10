package ltcd.sort;

public class _1351_统计有序矩阵中的负数 {

    public int countNegatives(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int index = m - 1;
        int res = 0;
        int start = 0;//previous row negative index

        while (index >= 0) {
            // search the negative of current row
            int left = start;
            int right = n - 1;
            int neg = -1;

            while (left <= right) {
                int mid = left + ((right - left) >> 1);

                if (grid[index][mid] < 0) {//sharp the search scope to [left, mid - 1]
                    neg = mid;//update negative index
                    right = mid - 1;
                } else {//sharp the search scope to [mid + 1, right]
                    left = mid + 1;
                }
            }

            if (neg == -1) { // 全是正数
                break;
            } else {
                res += n - neg;
                start = neg;//update previous row negative index
            }
            index--;
        }

        return res;
    }
}
