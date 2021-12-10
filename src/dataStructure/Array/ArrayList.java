package dataStructure.Array;

import java.util.Arrays;

public class ArrayList<E> extends AbstractList<E> {

    private E[] elements;
    private static final int DEFAULT_APACITY = 10;

    /**
     * initial Arraylist
     * @param capacity ArrayList Capacity
     */
    public ArrayList(int capacity) {
        capacity = (capacity < DEFAULT_APACITY) ? DEFAULT_APACITY : capacity;
        elements = (E[]) new Object[capacity];
    }

    /**
     * initial Arraylist
     */
    public ArrayList() {
        elements = (E[]) new Object[DEFAULT_APACITY];
    }

    @Override
    public void clear() {
        //reset elements to null
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }

        size = 0;//reset number of element to 0

        if (elements != null && elements.length > DEFAULT_APACITY) {
            elements = (E[]) new Object[DEFAULT_APACITY];
        }
    }

    @Override
    public E get(int index) {
        rangeCheck(index);

        return elements[index];
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);

        E old = elements[index];
        elements[index] = element;

        return old;
    }


    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);

        ensureCapacity(size + 1);

        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }

        elements[index] = element;
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);

        E element = elements[index];
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        elements[--size] = null;

        shrink();

        return element;
    }

    @Override
    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) {
                    return i;
                }
            }
        }

        return ELEMENT_NOT_FOUND;
    }

    /**
     * ensure elements Capacity enough to add new element
     * if array can't add new element, need to expand capacity
     * expanding capacity to 1.5 times or 2 times
     * @param capacity number of elements + 1
     */
    private void ensureCapacity(int capacity) {
        if (elements.length >= capacity) {
            return;
        }

        int oldCapacity = elements.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);//1.5 times
//        int newCapacity = oldCapacity << 1;//2 times
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;

        System.out.println("expand the Array capacity to: " + elements.length);
    }


    private void shrink() {
        int oldCapacity = elements.length;
        int newCapacity = oldCapacity >> 1;

        if (size > newCapacity || oldCapacity <= DEFAULT_APACITY) return;

        //if elements has too mach empty memory, need to shrink elements capacity
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;

        System.out.println("shrink the Array capacity to: " + elements.length);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("size: ").append(size).append(", [");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(elements[i]);
        }

        sb.append("]");
        return sb.toString();
    }
}
