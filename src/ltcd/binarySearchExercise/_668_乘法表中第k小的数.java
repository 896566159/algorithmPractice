package ltcd.binarySearchExercise;

public class _668_乘法表中第k小的数 {

    public int findKthNumber(int m, int n, int k) {
        if (n == 1 || m == 1) {
            return k;
        }

        int left = 1;
        int right = m * n;

        while (left < right) {

            int mid = (left + right) >> 1;
            //统计 <= mid 数有多少个
            int count = countLessEquals(m, n, mid);

            //count < k，说明 mid 比答案小，需要增大
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    /**
     * 统计 <= threshold 的个数
     * @param m
     * @param n
     * @param threshold
     * @return
     */
    private int countLessEquals(int m, int n, int threshold) {
        int count = 0;

        //从第一行开始统计
        for (int i = 1; i <= m; i++) {

            if (i <= threshold) {
                //每一行的开始和结束
                int left = 1;
                int right = n;

                while (left < right) {
                    int mid = ((left + right + 1) >> 1) * i;

                    if (mid > threshold) {
                        right = mid / i - 1;
                    } else {
                        left = mid / i;
                    }
                }

                count += left;
            }
        }

        return count;
    }

}
