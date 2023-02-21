package ltcd.queenExercise;

public class _622_设计循环队列 {

    int[] arr = null;
    int size = 0;
    int front = 0;
    int rear = 0;

    public static void main(String[] args) {
        _622_设计循环队列 v = new _622_设计循环队列(3);
        v.enQueue(1);
        v.enQueue(2);
        v.deQueue();
        v.enQueue(3);
        v.deQueue();
        v.enQueue(3);
        v.deQueue();
        v.enQueue(3);
        System.out.println(v.Front());
    }

    public _622_设计循环队列(int k) {
        arr = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        rear = (front + size) % arr.length;
        arr[rear] = value;

        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        front = front + 1 < arr.length ? front + 1 : (front + 1) % arr.length;
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }

        return arr[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }

        return arr[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == arr.length;
    }

}
