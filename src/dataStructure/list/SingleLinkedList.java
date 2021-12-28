package dataStructure.list;

public class SingleLinkedList<E> extends AbstractList<E> {

    Node<E> head = new Node<>(null, null);

    private class Node<E> {
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
            this.next = null;
        }

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            head = null;
            size = 0;
        }
    }

    @Override
    public E get(int index) {
        return getNode(index).element;
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);

        Node<E> node = getNode(index);
        E olgElement = node.element;
        node.element = element;

        return olgElement;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);

        Node<E> prev = index == 0 ? head : getNode(index - 1);
        prev.next = new Node<>(element, prev.next);
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);

        Node<E> prev = index == 0 ? head : getNode(index - 1);
        Node<E> node = prev.next;
        prev.next = node.next;
        size--;
        return null;
    }

    @Override
    public int indexOf(E element) {
        Node<E> p = head.next;
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (p.element == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (p.element.equals(element)) {
                    return i;
                }
            }
        }

        return 0;
    }

    private Node<E> getNode(int index) {
        rangeCheck(index);

        Node<E> p = head.next;
        while (index-- > 0) {
            p = p.next;
        }

        return p;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Node<E> p = head.next;
        sb.append("size:").append(size).append(", [");
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
