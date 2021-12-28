package dataStructure.stack;

import dataStructure.list.LinkedList;
import dataStructure.list.List;

public class Stack<E>{

    List<E> list = new LinkedList();

    public E push(E element){
        list.add(element);
        return element;
    }

    public E pop(){
        int index = list.size() - 1;
        E element = list.remove(index);
        return element;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
