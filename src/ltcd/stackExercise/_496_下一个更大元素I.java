package ltcd.stackExercise;

import java.util.*;

public class _496_下一个更大元素I {

    public static void main(String[] args) {
        _496_下一个更大元素I i = new _496_下一个更大元素I();
        i.nextGreaterElement(new int[] {4,1,2},  new int[] {1,3,4,2});
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> num2Index = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            num2Index.put(nums1[i], i);
        }

        int[] tmp = new int[nums2.length + 2];
        System.arraycopy(nums2, 0, tmp, 1, nums2.length);
        for (int i = 0; i < nums2.length; i++) {
            // 当前元素比栈顶元素大
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                Integer pop = stack.pop();
                if (num2Index.containsKey(nums2[pop])) {
                    res[num2Index.get(nums2[pop])] = nums2[i];
                }
            }

            // 入栈
            stack.push(i);
        }

        return res;
    }

}
