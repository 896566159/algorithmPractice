package ltcd.stackExercise;

import java.util.Stack;

public class _739_每日温度 {

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                if (temperatures[stack.peek()] > temperatures[i]) {
                    stack.push(i);
                } else {
                    while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                        Integer pop = stack.pop();
                        ans[pop] = i - pop;
                    }
                    stack.push(i);
                }
            }
        }

        return ans;
    }

}
