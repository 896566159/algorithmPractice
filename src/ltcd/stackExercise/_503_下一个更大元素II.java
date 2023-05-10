package ltcd.stackExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class _503_下一个更大元素II {

    public static void main(String[] args) {
        _503_下一个更大元素II ii = new _503_下一个更大元素II();
        ii.nextGreaterElements(new int[] {1,2,3,4,3});
    }

    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        // 单调递减栈，栈中的元素保存数组的下标
        Deque<Integer> stack = new ArrayDeque<>();
        int length = nums.length;

        // 遍历两次数组 length * 2 - 1，即模拟出循环数组
        for (int i = 0; i < length * 2 - 1; i++) {
            // 如果当前元素 > 栈顶元素，则说明当前元素就是栈顶元素右边第一个比 (栈顶元素大的数)
            while (!stack.isEmpty() && nums[i % length] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i % length];
            }

            // 入栈
            stack.push(i % length);
        }

        return res;
    }

    // 暴力
    public int[] nextGreaterElements1(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            // 先从右边 [i + 1，length] 找出第一个大于当前元素的
            // 如果在 [i + 1，length] 中没有找到，则从 [0, i] 找出第一个大于当前元素的
            // [i + 1，length] 和 [0, i] 合并起来相当于是一个循环
            for (int j = i + 1; j < length + i; j++) {
                if (nums[j % length] > nums[i]) {
                    res[i] = nums[j % length];
                    break;
                }
            }
        }

        return res;
    }

}
