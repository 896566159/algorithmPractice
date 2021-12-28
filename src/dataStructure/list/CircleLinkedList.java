package dataStructure.list;

public class CircleLinkedList<E> extends AbstractList<E> {
    private Node<E> head;
    private Node<E> tail;

    private class Node<E> {
        Node<E> prev;
        Node<E> next;
        E element;

        public Node(E element) {
            this.element = element;
        }

        public Node(Node<E> prev, E element, Node<E> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
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
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        return getNode(index).element;
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);

        Node<E> node = getNode(index);
        E oldElement = node.element;
        node.element = element;
        return oldElement;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);

        if (index == 0) {//add to head
            if (size == 0) { //head == tail == null
                head = new Node(element);
                tail = head;
                head.prev = tail;
                tail.next = head;
            } else {
                Node<E> newHead = new Node(tail, element, head);
                head.prev = newHead;
                tail.next = newHead;
                head = newHead;
            }
        } else {
            if (index == size) {//add to tail
                Node node = new Node(tail, element, head);
                tail.next = node;
                head.prev = node;
                tail = node;
            } else {//add to list middle
                Node<E> prev = getNode(index - 1);
                Node node = new Node(prev, element, prev.next);
                node.prev = prev;
                node.next.prev = node;
            }
        }
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        
        E element = null;
        if (size == 1) {
            element = head.element;
            clear();
            return element;
        }

        if (index == 0) {
            element = head.element;
            head = head.next;
            head.prev = tail;
            tail.next = head;
        } else if (index > 0 && index != size - 1){
            Node<E> node = getNode(index);
            element = node.element;
            node.prev.next = node.next;
            node.next.prev = node.prev;
        } else if(index > 0 && index == size - 1) {
            element = tail.element;
            tail = tail.prev;
            tail.next = head;
            head.prev = tail;
        }
        size--;
        
        return element;
    }

    @Override
    public int indexOf(E element) {
        Node<E> p = this.head;
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (p.element == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(element)) {
                    return i;
                }
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    private Node<E> getNode(int index) {
        rangeCheck(index);

        if (index > size >> 1) {
            Node<E> p = head;

            for (int i = 0; i < index; i++) {
                p = p.next;
            }

            return p;
        } else {
            Node<E> p = tail;

            for (int i = size - 1; i > index; i--) {
                p = p.prev;
            }

            return p;
        }

    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        Node<E> node = head;
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
