package ltcd.stackExercise;

import java.util.Stack;

public class _面试题_0305_栈排序 {

    Stack<Integer> in = null;
    Stack<Integer> out = null;

    public _面试题_0305_栈排序() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void push(int val) {
        while (val > in.peek()) {
            out.push(in.pop());
        }

        in.push(val);
        while (!out.isEmpty()) {
            in.push(out.pop());
        }
    }

    public void pop() {
        if (!in.isEmpty()) {
            in.pop();
        }
    }

    public int peek() {
        if (!in.isEmpty()) {
            return in.peek();
        }

        return -1;
    }

    public boolean isEmpty() {
        return in.isEmpty();
    }

}
