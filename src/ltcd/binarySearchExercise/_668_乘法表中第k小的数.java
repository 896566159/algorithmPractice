package ltcd.binarySearchExercise;

public class _668_乘法表中第k小的数 {

    public int findKthNumber(int m, int n, int k) {
        int left = 0;
        int right = m * n;

        while (left < right) {

            int mid = (left + right) >> 1;
            int count = countLessEquals(m, n, mid);

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
        for (int i = 0; i < n; i++) {

            int left = i + 1;
            int right = (i + 1) * n;

            while (left < right) {
                int mid = (left + right) >> 1;

                if (mid > threshold) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }

            count += left / (i + 1);
        }

        return count;
    }

}
