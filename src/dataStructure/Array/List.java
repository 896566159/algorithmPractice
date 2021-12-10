package dataStructure.Array;

public interface List<E> {
    static final int ELEMENT_NOT_FOUND = -1;

    /**
     * remove all element， reset size = 0
     */
    void clear();

    /**
     * the number of elements
     * @return number of elements
     */
    int size();

    /**
     * the array is empty or not
     * @return size =?= 0
     */
    boolean isEmpty();

    /**
     * list contains the element or not
     * @param element target element
     * @return contains the target element or not
     */
    boolean contains(E element);

    /**
     * add element to the tail
     * @param element the add element
     */
    void add(E element);

    /**
     * get element of the index
     * @param index target index
     * @return element of the index
     */
    E get(int index);

    /**
     * reset the element of index, meanwhile return the old element
     * @param index target index
     * @param element new element
     * @return old element
     */
    E set(int index, E element);

    /**
     * add element to target index
     * @param index target index
     * @param element add element
     */
    void add(int index, E element);

    /**
     * remove element of the index
     * @param index target index
     * @return remove element
     */
    E remove(int index);

    /**
     * the element index in the list
     * @param element target element
     * @return the element index in the list
     */
    int indexOf(E element);
}
