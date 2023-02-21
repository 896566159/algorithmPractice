package ltcd.stackExercise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class _42_接雨水 {

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

    public static void main(String[] args) {
        System.out.println(new _42_接雨水().trap(new int[]{4,2,0,3,2,5}));
    }

}
