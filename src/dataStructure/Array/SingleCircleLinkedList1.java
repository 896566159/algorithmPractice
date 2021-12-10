package dataStructure.Array;

public class SingleCircleLinkedList1<E> extends AbstractList<E>{
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
            Node<E> last = size == 0 ? head : getNode(size - 1);
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
        return null;
    }

    @Override
    public int indexOf(E element) {
        return 0;
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
