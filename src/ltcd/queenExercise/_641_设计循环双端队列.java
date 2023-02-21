package ltcd.queenExercise;

public class _641_设计循环双端队列 {

    public static void main(String[] args) {
        _641_设计循环双端队列 v = new _641_设计循环双端队列(3);
        System.out.println(v.insertFront(8));
        System.out.println(v.insertLast(8));
        System.out.println(v.insertLast(2));
        System.out.println(v.getFront());
        System.out.println(v.deleteLast());
        System.out.println(v.getRear());
        System.out.println(v.insertLast(9));
        System.out.println(v.deleteFront());
        System.out.println(v.getRear());
        System.out.println(v.insertLast(2));

    }

    int[] queue;
    int front;
    int rear;
    int size;

    public _641_设计循环双端队列(int k) {
        queue = new int[k];
        front = 0;
        rear = 0;
        size = 0;
    }

    //	将一个元素添加到双端队列头部。 如果操作成功返回 true ，否则返回 false
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        queue[front] = value;
        front--;
        front = (front + queue.length) % queue.length;
        size++;
        return true;

    }

    //	将一个元素添加到双端队列尾部。如果操作成功返回 true ，否则返回 false 。
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        rear++;
        rear %= queue.length;
        queue[rear] = value;
        size++;
        return true;

    }

    //	从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false
    public boolean deleteFront() {
        if (size == 0) {
            return false;
        } else {
            front++;
            front %= queue.length;
            size--;
            return true;
        }
    }

    //	从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false 。
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        rear--;
        rear = (rear + queue.length) % queue.length;
        size--;
        return true;

    }

    //	从双端队列头部获得一个元素。如果双端队列为空，返回 -1 。
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return queue[(front + 1) % queue.length];

    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return queue[rear];

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }

}
