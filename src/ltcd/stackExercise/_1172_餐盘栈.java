package ltcd.stackExercise;

import java.util.*;

public class _1172_餐盘栈 {
    public static void main(String[] args) {
        // ["DinnerPlates","push","push","push","push","push",
        // "popAtStack",
        // "push","push",
        // "popAtStack","popAtStack",
        // "pop","pop","pop","pop","pop"]
        // [2],[1],[2],[3],[4],[5],[0],[20],[21],[0],[2],[],[],[],[],[]]
        _1172_餐盘栈 v = new _1172_餐盘栈(2);
        v.push(1);
        v.push(2);
        v.push(3);
        v.push(4);
        v.push(5);

        System.out.println(v.popAtStack(0));

        v.push(20);
        v.push(21);

        System.out.println(v.popAtStack(0));
        System.out.println(v.popAtStack(2));

        System.out.println(v.pop());
        System.out.println(v.pop());
        System.out.println(v.pop());
        System.out.println(v.pop());
        System.out.println(v.pop());

        v = new _1172_餐盘栈(1);
        v.push(1);
        v.push(2);
        v.push(3);
        System.out.println(v.popAtStack(1));
        System.out.println(v.pop());
        System.out.println(v.pop());

        v = new _1172_餐盘栈(1);
        v.push(1);
        v.push(2);

        System.out.println(v.popAtStack(1));
        System.out.println(v.pop());

        v.push(1);
        v.push(2);

        System.out.println(v.pop());
        System.out.println(v.pop());
    }

    private int capacity;
    // 保存每一个栈的下标和栈顶
    private Map<Integer, Integer> map;
    // 保存所有的栈
    private List<int[]> stacks = new ArrayList<>();

    private int size = 0;

    public _1172_餐盘栈(int capacity) {
        this.capacity = capacity;
        map = new TreeMap<>();
    }

    // 所有栈
    private List<Deque<Integer>> stack = new ArrayList<>();
    // 最小堆，保存未满栈的的下标
    private PriorityQueue<Integer> idx = new PriorityQueue<>();

    public void push(int val) {
        if (!idx.isEmpty() && idx.peek() >= stack.size()) {
            // 清除堆中的越界下标
            idx.clear();
        }

        // 没有不满的栈
        if (idx.isEmpty()) {
            Deque<Integer> sta = new ArrayDeque<>();
            sta.push(val);
            stack.add(sta);
            if (capacity > 1) {
                // 新栈未满
                idx.add(stack.size() - 1);
            }
        } else {
            // 有未满的栈
            Deque<Integer> sta = stack.get(idx.peek());
            sta.push(val);

            // 如果栈满了，删除
            if (sta.size() == capacity) {
                idx.poll();
            }
        }
    }

    public int pop() {
        // 等价为 popAtStack 最后一个非空栈
        return popAtStack(stack.size() - 1);
    }

    public int popAtStack(int index) {
        if (index < 0 || index >= stack.size() || stack.get(index).isEmpty()) {
            return -1;
        }

        Deque<Integer> sta = stack.get(index);
        // 满栈->不满
        if (sta.size() == capacity) {
            idx.add(index);
        }

        Integer res = sta.pop();

        // 去掉末尾为空的栈（idx懒删除，堆中下标在 push 时清理）
        while (!stack.isEmpty() && stack.get(stack.size() - 1).isEmpty()) {
            stack.remove(stack.size() - 1);
        }

        return res;
    }

    /**
     * 超时
     */
//    // 将给出的正整数 val 推入 从左往右第一个 没有满的栈。
//    public void push(int val) {
//        size++;
//        Iterator<Integer> iterator = map.keySet().iterator();
//        while (iterator.hasNext()) {
//            // 从左到右找到第一个没有满的栈
//            Integer key = iterator.next();
//            Integer top = map.get(key);
//            if (top < capacity) {
//                int[] sta = stacks.get(key);
//                sta[top] = val;
//
//                // 设置该栈的栈顶 + 1
//                map.put(key, top + 1);
//                return;
//            }
//        }
//
//        // 所有的栈都是满的，需要创建一个新的栈
//        int[] sta = new int[capacity];
//        // 元素入栈
//        sta[0] = val;
//        // 栈添加到链表中
//        stacks.add(sta);
//
//        // 维护新的栈及其栈顶
//        map.put(stacks.size() - 1, 1);
//    }
//
//    // 返回 从右往左第一个 非空栈顶部的值，并将其从栈中删除；如果所有的栈都是空的，请返回 -1。
//    public int pop() {
//        if (size == 0 || stacks.isEmpty()) {
//            return -1;
//        }
//
//        // 最右边、不为空的栈
//        Iterator<Integer> iterator = map.keySet().iterator();
//        int index = stacks.size() - 1;
//        while (iterator.hasNext()) {
//            Integer key = iterator.next();
//            if (map.get(key) > 0) {
//                index = key;
//                // break;
//            }
//        }
//
//        int[] ints = stacks.get(index);
//        // 最右边的栈的栈顶
//        Integer top = map.get(index);
//        int res = ints[--top];
//
////        // 最后一个元素已经将要被弹出，删除该栈
////        if (top == 0) {
////            stacks.remove(index);
////            map.remove(index);
////        } else {
//        // 重置栈顶
//        map.put(index, top);
////        }
//
//        size--;
//        return res;
//    }
//
//    // 返回编号 index 的栈顶部的值，并将其从栈中删除；如果编号 index 的栈是空的，请返回 -1。
//    public int popAtStack(int index) {
//        if (size == 0 || index < 0 || index >= stacks.size()) {
//            return -1;
//        }
//
//        // 定位到该栈
//        int[] ints = stacks.get(index);
//        if (ints == null) {
//            return -1;
//        }
//
//        // 该栈的栈顶
//        Integer top = map.get(index);
//        if (top == 0) {
//            return -1;
//        }
//        int res = ints[--top];
//
//        // 最后一个元素已经将要被弹出，删除该栈
////        if (top == 0) {
////            stacks.remove(index);
////
////            Map<Integer, Integer> tmp = new TreeMap<>(map);
////            map.remove(index);
////
////            // 将所有的栈下标重新排序
////            Iterator<Integer> iterator = map.keySet().iterator();
////            while (iterator.hasNext()) {
////                Integer key = iterator.next();
////                if (key > index) {
////                    top = map.get(key);
////                    tmp.put(key - 1, top);
////                    tmp.remove(key);
////                }
////            }
////            map = tmp;
////        } else {
//        // 重置栈顶
//        map.put(index, top);
////        }
//
//        size--;
//        return res;
//    }


/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */

}
