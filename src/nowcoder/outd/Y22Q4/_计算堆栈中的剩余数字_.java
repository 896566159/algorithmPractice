package nowcoder.outd.Y22Q4;

import java.util.*;

public class _计算堆栈中的剩余数字_ {

    // 自己写的模拟过程
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        //解析为int数组
        String[] nums_str_list = line.split(" ");
        int[] nums = new int[nums_str_list.length];
        for (int i = 0; i < nums_str_list.length; i++) {
            nums[i] = Integer.parseInt(nums_str_list[i]);
        }

        int index = 0;
        int[] res = new int[nums_str_list.length];
        // 第一个元素先入栈
        res[index++] = nums[0];
        int tmp = 0;
        int sum = 0;
        // 模拟入栈过程
        for (int i = 1; i < nums.length; i++) {
            // 检查 连续的栈顶之和 与 num[i] 的大小关系
            tmp = index - 1;
            sum = nums[i];
            while (tmp >= 0 && sum > 0) {
                sum -= res[tmp--];
            }

            // 连续好几个数加起来和当前将要入栈的数相等
            if (sum == 0) {
                // 弹出这些数，即将数组下标移动到 tmp + 1 的地方，后面的数据是失效的弹出数据
                index = tmp + 1;
                // 将当前元素乘以 2，并且 延迟入栈，因为新的元素值可能有可以和前面的元素之和抵消掉
                nums[i] = nums[i] * 2;
                i--;
            } else {
                // 栈顶的几个数之和不等于当前数，立即入栈
                res[index++] = nums[i];
            }
        }

        // 直接从 index - 1 出开始输出即可
        while (index-- > 0) {
            System.out.print(res[index] + " ");
        }
    }


    public static Stack<Integer> num_stack = new Stack<>();

    public static void main1(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        //解析为int数组
        String[] nums_str_list = line.split(" ");
        int[] nums = new int[nums_str_list.length];
        for (int i = 0; i < nums_str_list.length; i++) {
            nums[i] = Integer.parseInt(nums_str_list[i]);
        }

        // 模拟入栈过程
        for (int i = 0; i < nums.length; i++) {
            push_attempt(nums[i]);
        }

        String result = "";
        while (!num_stack.empty()) {
            result += num_stack.pop() + " ";
        }
        System.out.println(result.trim());
    }

    //自定义入栈过程
    public static void push_attempt(int num) {
        int temp = 0;
        for (int i = num_stack.size() - 1; i >= 0; i--) {
            temp += num_stack.get(i);
            if (temp == num) {
                int stackSize = num_stack.size();
                for (int j = i; j < stackSize; j++) {
                    num_stack.pop();
                }

                // 在此处递归
                push_attempt(temp * 2);
                return;
            } else if (temp > num) {
                break;
            }
        }
        num_stack.push(num);
    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String[] split = scanner.nextLine().split(" ");
//        Deque<Integer> stack = new ArrayDeque<>();
//
//        for (String s : split) {
//            int cur = Integer.parseInt(s);
//            if (!stack.isEmpty() && cur >= stack.peek()) {
//                stack = recur(stack, cur);
//            } else {
//                stack.push(cur);
//            }
//        }
//
//        while (!stack.isEmpty()) {
//            System.out.println(stack.pop() + " ");
//        }
//    }
//
//    private static Deque<Integer> recur(Deque<Integer> stack, int target) {
//        if (stack.isEmpty() || target < stack.peek()) {
//            return stack;
//        }
//
//        int newTarget = target << 1;
//        Deque<Integer> tmp = new ArrayDeque<>(stack);
//
//        while (!stack.isEmpty() && target > 0) {
//            target -= stack.pop();
//        }
//
//        // 将要入栈的元素和栈顶的几个元素可以相互抵消
//        if (target == 0) {
//            if (stack.isEmpty()) {
//                stack.push(newTarget);
//                return stack;
//            } else {
//                return recur(stack, newTarget);
//            }
//        } else {
//            tmp.push(newTarget >> 1);
//            return tmp;
//        }
//    }

}
