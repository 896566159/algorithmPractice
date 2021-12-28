package ltcd.linkedListExercise;

public class _707_设计链表 {

    int size = 0;
    No head = null;

    public _707_设计链表() {
        head = null;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        No p = head;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }

        return p.val;
    }

    public void addAtHead(int val) {
        if (size == 0) {
            head = new No(val);
        } else {
            head = new No(val, head);
        }
        size++;
    }

    public void addAtTail(int val) {
        if (size == 0) {
            addAtHead(val);
            return;
        }

        No p = head;

        while (p.next != null) {
            p = p.next;
        }
        p.next = new No(val);
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index <= 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else if (index > size) {
            return;
        } else {
            No p = head;
            for (int i = 0; i < index - 1; i++) {
                p = p.next;
            }

            p.next = new No(val, p.next);
        }

        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        if (index == 0) {
            head = size == 1 ? null : head.next;
            size--;
            return;
        }

        No p = head;
        for (int i = 0; i < index - 1; i++) {
            p = p.next;
        }

        p.next = p.next.next;
        size--;
    }
}

class No {
    int val;
    No next;

    public No(int val) {
        this.val = val;
    }

    public No(int val, No next) {
        this.val = val;
        this.next = next;
    }
}
