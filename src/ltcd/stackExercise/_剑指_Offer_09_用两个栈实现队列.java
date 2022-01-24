package ltcd.stackExercise;

import java.util.Stack;

public class _剑指_Offer_09_用两个栈实现队列 {

    Stack<Integer> in = null;
    Stack<Integer> out = null;

    public _剑指_Offer_09_用两个栈实现队列() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        if (!out.isEmpty()) {
            return out.pop();
        }

        while (!in.isEmpty()) {
            out.push(in.pop());
        }

        if (out.isEmpty()) {
            return -1;
        }

        return out.pop();
    }

}
