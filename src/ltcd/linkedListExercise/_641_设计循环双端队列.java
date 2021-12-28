package ltcd.linkedListExercise;

public class _641_设计循环双端队列 {

    int size = 0;
    int capacity = 0;
    MyNode head = null;
    MyNode tail = null;

    public _641_设计循环双端队列(int k) {
        capacity = k;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        } else {
            if (size == 0) {
                tail = head = new MyNode(value);
                head.pre = head.next = head;
            } else {
                MyNode node = new MyNode(tail, value, head);
                head.pre = node;
                tail.next = node;
                head = node;
            }
            size++;
            return true;
        }
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        } else {
            if (size == 0) {
                tail = head = new MyNode(value);
                head.pre = head.next = head;
            } else {
                MyNode node = new MyNode(tail, value, head);
                tail.next = node;
                head.pre = node;
                tail = node;
            }
            size++;
            return true;
        }
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        } else {
            if (size == 1) {
                head = tail = null;
            } else {
                head.next.pre = tail;
                tail.next = head.next;
                head = head.next;
            }
            size--;
            return true;
        }
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        } else {
            if (size == 1) {
                head = tail = null;
            } else {
                tail.pre.next = head;
                head.pre = tail.pre;
                tail.next = head;
                tail = tail;
            }
            size--;
            return true;
        }
    }

    public int getFront() {
        return size == 0 ? -1 : head.elemeent;
    }

    public int getRear() {
        return size == 0 ? -1 : tail.elemeent;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}

class MyNode{
    int elemeent;
    MyNode pre;
    MyNode next;

    public MyNode(int element) {
        this.elemeent = element;
    }

    public MyNode(MyNode pre, int element, MyNode next) {
        this.pre = pre;
        this.elemeent = element;
        this.next = next;
    }
}
