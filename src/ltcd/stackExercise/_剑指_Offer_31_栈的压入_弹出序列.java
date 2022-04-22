package ltcd.stackExercise;

import java.util.Stack;

public class _剑指_Offer_31_栈的压入_弹出序列 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> stack = new Stack<>();
        int j = 0;
        int i = 0;

        while (i < pushed.length) {
            stack.push(pushed[i]);

            while (!stack.isEmpty() && stack.peek() == popped[j] && j < popped.length) {
                stack.pop();
                j++;
            }

            i++;
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        new _剑指_Offer_31_栈的压入_弹出序列().validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1});
    }
}
