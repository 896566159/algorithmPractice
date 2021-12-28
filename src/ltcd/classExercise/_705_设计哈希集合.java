package ltcd.classExercise;

import ltcd.linkedListExercise.ListNode;

public class _705_设计哈希集合 {

    boolean[] nodes = null;

    public _705_设计哈希集合() {
        nodes = new boolean[1000009];
    }

    public void add(int key) {
        nodes[key] = true;
    }

    public void remove(int key) {
        nodes[key] = false;
    }

    public boolean contains(int key) {
        return  nodes[key];
    }

}
