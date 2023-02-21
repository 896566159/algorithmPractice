package ltcd.stackExercise.difficult;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 如果 arr[i] 位置能够分块，则说明 从 0~i 这个元素中，arr[i]是最大的。 如：arr = [4, 3, 2, 1, 0, 4]中，遍历到第一个4、第二个4时可以分块
 * 如果 arr[i] 是 0~i 这写元素中最小的，则 0~i 所有元素只能做为一个块。 如：arr = [4, 3, 2, 1, 0, 4]中，遍历到3、2、1、0时，都只能不能分块，只能从4开始到当前数作为一个块
 */
public class _768_最多能完成排序的块_II {
    public static int maxChunksToSorted2(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        int ans = 0;
        int nonzero = 0;

        int[] except = arr.clone();
        Arrays.sort(except);

        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            int y = except[i];

            count.put(x, count.getOrDefault(x, 0) + 1);
            if (count.get(x) == 0) {
                nonzero--;
            }
            if (count.get(x) == 1) {
                nonzero++;
            }

            count.put(y, count.getOrDefault(y, 0) - 1);
            if (count.get(y) == -1) {
                nonzero++;
            }
            if (count.get(y) == 0) {
                nonzero--;
            }

            if (nonzero == 0) {
                ans++;
            }
        }

        return ans;
    }

    public static int maxChunksToSorted(int[] arr) {
        LinkedList<Integer> stack = new LinkedList<>();

        for (int num : arr) {

            //遇到一个臂展丁晓的元素，而前面的快不应该有比 a 小的
            //而栈中每一个元素都是一个块，并且占存储的是块的最大值，因此占中比 a 小的都需要 pop 出来
            if (!stack.isEmpty() && num < stack.getLast()) {
                //我们需要将融合后的区块的最大值重新方放回栈
                //而 stack 是递增的，因此 stack[-1] 是最大的
                int cur = stack.removeLast();
                //维持单调递增栈
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

    public static void main(String[] args) {
        System.out.println(maxChunksToSorted2(new int[]{2,1,3,4,4,1}));
    }
}
