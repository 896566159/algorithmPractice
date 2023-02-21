package ltcd.stackExercise;

import java.util.*;

public class _面试题59_II_队列的最大值 {

    private Deque<Integer> queue;
    private Deque<Integer> max;

    public static void main(String[] args) {
        _面试题59_II_队列的最大值 v = new _面试题59_II_队列的最大值();
        v.push_back(1);
        v.push_back(2);
        v.push_back(4);
        v.push_back(2);
        v.push_back(3);
        System.out.println(v.max_value());
        System.out.println(v.pop_front());
        System.out.println(v.max_value());

    }

    public _面试题59_II_队列的最大值() {
        queue = new ArrayDeque<>();
        max = new ArrayDeque<>();
    }

    public int max_value() {
        if (queue.isEmpty()) {
            return -1;
        }
        return max.peekLast();
    }

    public void push_back(int value) {
        while (!max.isEmpty() && value > max.peekLast()) {
            max.pollLast();
        }
        max.push(value);
        queue.offer(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }

        Integer poll = queue.poll();
        if (poll.equals(max.peekFirst())) {
            max.pollFirst();
        }

        return poll;
    }

}
