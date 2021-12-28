package dataStructure.list;

public class SingleCircleLinkedList<E> extends AbstractList<E>{
    Node<E> head;

    private class Node<E>{
        E element;
        Node<E> next;

        public Node(E element){
            this.element = element;
            this.next = null;
        }

        public Node(E element, Node<E> next){
            this.element = element;
            this.next = next;
        }
    }

    @Override
    public void clear() {
        head = null;
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

        Node<E> newHead;
        if (index == 0) {//add to head
            newHead = new Node<>(element, head);
            Node<E> last = size == 0 ? newHead : getNode(size - 1);
            last.next = head;
            head = newHead;
        } else {
            newHead = getNode(index - 1);
            newHead.next = new Node<>(element, newHead.next);
        }
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);

        E element;
        if (index == 0) {
            Node<E> last = size == 0 ? head : getNode(size - 1);
            element = head.element;
            last.next = head.next;
            head = head.next;
        } else {
            Node<E> node = getNode(index - 1);
            element = node.next.element;
            node.next = node.next.next;
        }

        size--;

        return element;
    }

    @Override
    public int indexOf(E element) {
        if (element == null) {
            Node<E> p = head;
            for (int i = 0; i < size; i++) {
                if (p.element == null) {
                    return i;
                }
                p = p.next;
            }
        } else {
            Node<E> p = head;
            for (int i = 0; i < size; i++) {
                if (p.element.equals(element)) {
                    return i;
                }
                p = p.next;
            }
        }

        return ELEMENT_NOT_FOUND;
    }

    private Node<E> getNode(int index) {
        rangeCheck(index);

        Node<E> p = head;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }

        return p;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("size: ").append(size).append(", [");
        Node<E> p = head;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(p.element);
            p = p.next;
        }
        sb.append("]");

        return sb.toString();
    }
}
