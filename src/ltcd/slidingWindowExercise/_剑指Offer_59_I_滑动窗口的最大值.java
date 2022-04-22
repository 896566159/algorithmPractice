package ltcd.slidingWindowExercise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class _剑指Offer_59_I_滑动窗口的最大值 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k < 2 || nums == null) {
            return nums;
        }

        int length = nums.length;
        int[] ans = new int[length - k + 1];
        int left = 0;
        int right = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        while (right < length) {
            //如果队列不为空，且队尾元素小于 nums[right]
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[right]) {
                deque.removeLast();
            }

            //队列为空 或者 队尾元素 <= nums[right]，right坐标入队
            deque.addLast(right);

            //当 right >= k - 1 时，说明窗口长度为 k 了，需要向答案数组输出数据了
            if (right >= k - 1) {
                //判断队首元素是否在窗口内，不在的话将其移出
                if (deque.peekFirst() < left) {
                    deque.removeFirst();
                }

                //因为已经排除了队首元素不可能不在窗口的可能
                //队首元素就是当前窗口的最大值
                ans[left] = nums[deque.peekFirst()];
                left++;//窗口左边界右移
            }

            //窗口有边界右移
            right++;
        }

        return ans;
    }

    public static void main(String[] args) {
        new _剑指Offer_59_I_滑动窗口的最大值().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
    }

}
