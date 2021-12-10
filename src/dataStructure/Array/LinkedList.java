package dataStructure.Array;

public class LinkedList<E> extends AbstractList<E> {

    private Node<E> first;
    private Node<E> last;

    private static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        public Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            if (prev != null) {
                sb.append(prev.element);
            } else {
                sb.append("null");
            }

            sb.append("_").append(element).append("_");

            if (next != null) {
                sb.append(next.element);
            } else {
                sb.append("null");
            }

            return sb.toString();
        }
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public E get(int index) {
        return getNode(index).element;
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);

        Node<E> node = getNode(index);
        E old = node.element;
        node.element = element;

        return old;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);

        //size == 0
        //index == 0
        if (index == size) {//add element to tail
            Node<E> oldLast = last;
            last = new Node<>(oldLast, element, null);
            if (oldLast == null) {//first time to add element
                first = last;
            } else {
                oldLast.next = last;
            }
        } else {
            Node<E> next = getNode(index);
            Node<E> prev = next.prev;
            Node<E> node = new Node<>(prev, element, next);
            next.prev = node;

            if (prev == null) {//index == 0
                first = node;
            } else {
                prev.next = node;
            }
        }

        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);

        Node<E> node = getNode(index);
        Node<E> prev = node.prev;
        Node<E> next = node.next;

        if (prev == null) {//index == 0
            first = next;
        } else {
            prev.next = next;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
        }

        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {

        Node<E> node = first;
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (node.element == null) return i;
                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (node.element.equals(element)) return i;
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * get the target element of the index
     * @param index target index
     * @return element
     */
    private Node<E> getNode(int index) {
        rangeCheck(index);

        Node<E> node = first;
        if (index < (size >> 1)) {//target element in the left list
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {//target element in the right list
            node = last;
            for (int i = 0; i < index; i++) {
                node = node.prev;
            }
        }

        return node;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(", ");
            }

            string.append(node);

            node = node.next;
        }
        string.append("]");
        return string.toString();
    }
}
