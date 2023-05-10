package ltcd.stackExercise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class _84_柱状图中最大的矩形 {

    public static void main(String[] args) {
        _84_柱状图中最大的矩形 v = new _84_柱状图中最大的矩形();
//        System.out.println(v.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(v.largestRectangleArea(new int[]{1,2,2}));
    }

    public int largestRectangleArea(int[] heights) {
        // 为了方便计算，在元素组的首位都添加一个 0
        int[] copy = new int[heights.length + 2];
//        for (int i = 0; i < heights.length; i++) {
//            copy[i + 1] = heights[i];
//        }
        System.arraycopy(heights, 0, copy, 1, heights.length);
        Deque<Integer> stack =  new ArrayDeque<>();
        int area = 0;

        for (int i = 0; i < copy.length; i++) {
            // 对栈中柱体来说，占中的下一个柱体就是其 [左边第一个比该柱体低的柱体]
            // 若当前柱体 i 的高度小于栈顶柱体的高度，说明 i 是栈顶柱体的 [右边第一个小于栈顶柱体的柱体]
            // 因此就确定了栈顶柱体 左边、右边第一个 比栈顶柱体低的柱体，即确定了 左右宽度。乘上栈顶柱体的高度即可求出以栈顶元素为高度围成的矩形面积
            while (!stack.isEmpty() && copy[stack.peek()] > copy[i]) {
                // 计算
                int height = copy[stack.pop()];
                area = Math.max(area, height * (i - stack.peek() - 1));
            }

            // 入栈
            stack.push(i);
        }

        return area;
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
