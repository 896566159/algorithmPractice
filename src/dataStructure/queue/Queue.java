package dataStructure.queue;

import dataStructure.list.ArrayList;

public class Queue<E> {
    ArrayList<E> list = new ArrayList<>();

    public void offer(E element) {
        list.add(element);
    }

    public E pop() {
        E element = list.remove(0);
        return element;
    }
}
