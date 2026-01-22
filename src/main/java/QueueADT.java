public interface QueueADT<E> {
    int size();
    boolean isEmpty();

    /**
     * Returns the front element without removing it.
     * If empty, returns null.
     */
    E first();

    /**
     * Adds an element to the rear of the queue.
     * If the queue is full (array capacity), throw IllegalStateException.
     */
    void enqueue(E e);

    /**
     * Removes and returns the front element.
     * If empty, returns null.
     */
    E dequeue();
}
