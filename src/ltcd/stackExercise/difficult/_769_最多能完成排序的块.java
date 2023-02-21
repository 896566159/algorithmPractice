package ltcd.stackExercise.difficult;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 如果 arr[i] 位置能够分块，则说明 从 0~i 这个元素中，arr[i]是最大的。 如：arr = [4, 3, 2, 1, 0, 4]中，遍历到第一个4、第二个4时可以分块
 * 如果 arr[i] 是 0~i 这写元素中最小的，则 0~i 所有元素只能做为一个块。 如：arr = [4, 3, 2, 1, 0, 4]中，遍历到3、2、1、0时，都只能不能分块，只能从4开始到当前数作为一个块
 */
public class _769_最多能完成排序的块 {

    public static void main(String[] args) {
        System.out.println(maxChunksToSorted(new int[]{4, 3, 2, 1, 0, 4,3,5}));
    }

    public static int maxChunksToSorted(int[] arr) {

        LinkedList<Integer> stack = new LinkedList<>();
        for (int num : arr) {

            if (!stack.isEmpty() && num < stack.getLast()) {
                int cur = stack.removeLast();

                while (!stack.isEmpty() && num < stack.getLast()) {
                    stack.removeLast();
                }
                stack.addLast(cur);
            } else {
                stack.addLast(num);
            }
        }
        
        return stack.size();
    }

    public static int maxChunksToSorted1(int[] arr) {

        int max = 0, ans = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
            if (max == i) {
                ans++;
            }
        }
        
        return ans;
    }

}
