package ltcd.stackExercise;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class _735_行星碰撞 {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int num: asteroids) {
            if (stack.isEmpty() || stack.peek() < 0 || num > 0) {//栈为空/栈顶为负数/当前星星为正数
                stack.push(num);
            } else {//栈不为空
                boolean f = true;
                while (!stack.isEmpty() && stack.peek() > 0) {
                    Integer peek = stack.peek();
                    if (peek == -num) {
                        stack.pop();
                        f = false;
                        break;
                    } else if (peek > -num){
                        break;
                    } else {
                        stack.pop();
                    }
                }

                if ((stack.isEmpty() || stack.peek() < 0) && f) {
                    stack.push(num);
                }
            }
        }

        int[] ans = new int[stack.size()];
        while (!stack.isEmpty()) {
            ans[stack.size() - 1] = stack.pop();
        }

        return ans;
    }

    public static void main(String[] args) {
        new _735_行星碰撞().asteroidCollision(new int[]{-2,-2,1,-2});
    }

}
