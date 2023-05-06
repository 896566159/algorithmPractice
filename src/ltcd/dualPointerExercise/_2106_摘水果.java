package ltcd.dualPointerExercise;

public class _2106_摘水果 {

    public static void main(String[] args) {
        _2106_摘水果 v = new _2106_摘水果();
        v.maxTotalFruits(new int[][]{{0,9},{4,1},{5,7},{6,2},{7,4},{10,9}}, 5, 4);
    }

    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        // 向左最远能到 fruit[left][0]
        int left = lowerBound(fruits, startPos - k);
        int right = left;
        int s = 0;
        int n = fruits.length;

        // 计算从 [left, startPos] 之间的水果数量和
        for (; right < n && fruits[right][0] <= startPos; right++) {
            // 从 fruits[left][0] 到 startpos 的水果数
            s += fruits[right][1];
        }

        int ans = s;
        // 使用双指针来计算在 距离 <= k 的 [left, right] 之间的水果数
        for (; right < n && fruits[right][0] <= startPos + k; right++) {
            // 枚举最右位置为 fruits[right][0]
            s += fruits[right][1];
            while (fruits[right][0] * 2 - fruits[left][0] - startPos > k
                && fruits[right][0] - fruits[left][0] * 2 + startPos > k) {
                // fruits[left][0] 无法到达
                s -= fruits[left++][1];
            }
            ans = Math.max(ans, s);
        }

        return ans;
    }

    private int lowerBound(int[][] fruits, int target) {

        int left = -1;
        int right = fruits.length;

        // 开区间 (left, right) 不为空
        while (left + 1 < right) {
            // 循环不变量
            int mid = (left + right) >>> 1;
            if (fruits[mid][0] < target) {
                // 收缩范围：(mid, right)
                left = mid;
            } else {
                // 收缩范围：(left, mid)
                right = mid;
            }
        }

        return right;
    }

}
