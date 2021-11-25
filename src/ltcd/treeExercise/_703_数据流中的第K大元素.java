package ltcd.treeExercise;

import java.util.PriorityQueue;

public class _703_数据流中的第K大元素 {

    PriorityQueue<Integer> queue = new PriorityQueue<>();
    int bound = 0;

    public _703_数据流中的第K大元素(int k, int[] nums) {
        bound = k;

        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    public int add(int val) {
        queue.offer(val);
        if (queue.size() > 0) {
            queue.poll();
        }
        return queue.peek();
    }

}
