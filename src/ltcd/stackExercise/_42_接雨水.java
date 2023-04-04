package ltcd.stackExercise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class _42_接雨水 {

    public int trap2(int[] height) {
        int len = height.length;
        int left = 0;
        int right = len - 1;
        int ans = 0;
        int preMax = 0;
        int sufMax = 0;

        while (left < right) {
            preMax = Math.max(preMax, height[left]);
            sufMax = Math.max(sufMax, height[right]);

            if (preMax < sufMax) {
                ans += preMax - height[left];
                left++;
            } else {
                ans += sufMax - height[right];
                right--;
            }
        }

        return ans;
    }

    // 使用两个辅助数组，分别记录从左到右、从右到左的最高木板高度
    public int trap1(int[] height) {
        int len = height.length;
        int ans = 0;
        // 从左到右的最高木板高度
        int[] preMax = new int[len];
        preMax[0] = height[0];
        // 从右到左的最高木板高度
        int[] sufMax = new int[len];
        sufMax[sufMax.length - 1] = height[len - 1];

        // 填充辅助数组
        for (int i = 1; i < len; i++) {
            preMax[i] = Math.max(preMax[i - 1], height[i]);
            sufMax[sufMax.length - i - 1] = Math.max(sufMax[sufMax.length - i], height[len - i - 1]);
        }

        // 统计：height[i] 可以接水量 = min(preMax[i], sufMax[i]) - height，即 (左右两边最低的木板 - 当前木板的高度) * 1,乘 1 省去
        for (int i = 0; i < len; i++) {
            ans += Math.min(preMax[i], sufMax[i]) - height[i];
        }

        return ans;
    }

    /**
     * 用栈
     * @param height
     * @return
     */
    public int trap(int[] height) {
//        Stack<Integer> stack = new Stack<>();
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;

        for (int i = 0; i < height.length; i++) {

            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                Integer cur = stack.pop();

                if (stack.isEmpty()) {
                    break;
                }

                Integer left = stack.peek();
                int right = i;
                int high = Math.min(height[left], height[right]) - height[cur];
                ans += (right - left - 1) * high;

            }
            stack.push(i);

        }

        return ans;
    }

}
