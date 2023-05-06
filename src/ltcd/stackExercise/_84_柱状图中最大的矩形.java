package ltcd.stackExercise;

public class _84_柱状图中最大的矩形 {

    public static void main(String[] args) {
        _84_柱状图中最大的矩形 v = new _84_柱状图中最大的矩形();
        System.out.println(v.largestRectangleArea(new int[]{2, 1, 1, 2, 5, 6, 2, 3}));
    }

    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        int length = heights.length;
        int[] preMax = new int[length];
        int[] sufMax = new int[length];

        int minIndex = 0;
        preMax[0] = 0;
        for (int i = 1; i < length; i++) {
            // 前一个和当前比较，如果前一个小于当前，则就是 i - 1
            if (heights[i - 1] < heights[i]) {
                preMax[i] = i - 1;
            } else if (heights[i - 1] > heights[i]){
                // 如果前一个元素大于当前元素，则用最小的和当前比
                if (heights[i] > heights[minIndex]) {
                    preMax[i] = minIndex;
                } else {
                    // 遍历到此，当前元素是最小的元素，前面没有比当前元素更小的元素
                    preMax[i] = i;
                    minIndex = i;
                }
            } else {
                preMax[i] = preMax[i - 1];
            }
        }

        minIndex = length - 1;
        sufMax[length - 1] = minIndex;
        for (int i = length - 2; i >= 0; i--) {
            // 后一个和最小的相比，取大的那个
            if (heights[sufMax[minIndex]] > heights[i + 1]) {
                minIndex = i + 1;
                sufMax[i] = minIndex;
            } else {
                sufMax[i] = minIndex;
            }
        }

        for (int i = 0; i < length; i++) {
            int curHeight = heights[i];
            int left = preMax[i];
            int right = sufMax[i];
            int area = (right - left - 1) * curHeight;
            ans = Math.max(ans, area);
        }

        return ans;
    }

    // 暴力解法
    public int largestRectangleArea1(int[] heights) {
        int ans = 0;
        int length = heights.length;

        for (int i = 0; i < length; i++) {
            int curHeight = heights[i];
            int right = i + 1;
            int left = i - 1;

            // 从 [i + 1, length) 中找出第一个比当前小的元素
            for (; right < length; right++) {
                if (curHeight > heights[right]) {
                    break;
                }
            }

            // 从 [0, i- 1) 中找出第一个比当前小的元素
            for (; left >= 0; left--) {
                if (curHeight > heights[left]) {
                    break;
                }
            }

            int area = (right - left - 1) * curHeight;
            ans = Math.max(ans, area);
        }

        return ans;
    }

}
