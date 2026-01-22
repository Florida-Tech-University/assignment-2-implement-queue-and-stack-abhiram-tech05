public interface StackADT<E> {
    int size();
    boolean isEmpty();

    /**
     * Returns the top element without removing it.
     * If empty, returns null.
     */
    E top();

    /**
     * Pushes an element onto the stack.
     */
    void push(E e);

    /**
     * Pops and returns the top element.
     * If empty, returns null.
     */
    E pop();
}
