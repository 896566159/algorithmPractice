package ltcd.stackExercise;

import java.util.Stack;

public class _155_最小栈 {

    Stack<Integer> stack = null;

    public _155_最小栈() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(val);
            stack.push(val);
        } else {
            Integer peek = stack.peek();
            if (peek > val) {
                stack.push(val);
                stack.push(val);
            } else {
                stack.push(val);
                stack.push(peek);
            }
        }
    }

    public void pop() {
        stack.pop();
        stack.pop();
    }

    public int top() {
        Integer pop = stack.pop();
        Integer peek = stack.peek();
        stack.push(pop);
        return peek;
    }

    public int getMin() {
        return stack.peek();
    }

}
