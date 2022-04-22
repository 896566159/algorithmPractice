package ltcd.heapExercise;

import java.util.PriorityQueue;

public class _剑指_Offer_40_最小的k个数 {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || arr.length == k) {
            return arr;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int index = 0;

        while (index < arr.length) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(arr[index++]);
                continue;
            }

            Integer peek = priorityQueue.peek();
            if (peek > arr[index]) {
                priorityQueue.remove(peek);
                priorityQueue.add(arr[index]);
            }
            index++;
        }

        int[] res = new int[k];
        index = 0;

        while (!priorityQueue.isEmpty()) {
            res[index++] = priorityQueue.poll();
        }

        return res;
    }

    public static void main(String[] args) {
        new _剑指_Offer_40_最小的k个数().getLeastNumbers(new int[]{4,3,2,5,7,1}, 2);
    }

}
