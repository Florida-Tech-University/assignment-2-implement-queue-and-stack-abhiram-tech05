import java.util.Objects;

public class ArrayQueue<E> implements QueueADT<E> {
    private final E[] data;
    private int front = 0;  // index of the front element
    private int size = 0;   // number of elements in the queue

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("capacity must be > 0");
        this.data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        // TODO: return current number of elements
        return -1;
    }

    @Override
    public boolean isEmpty() {
        // TODO: return true if size == 0
        return true;
    }

    @Override
    public E first() {
        // TODO: if empty return null; else return data[front]
        return null;
    }

    @Override
    public void enqueue(E e) {
        Objects.requireNonNull(e, "Null elements are not supported in this assignment.");

        // TODO:
        // 1) if full (size == data.length) throw IllegalStateException
        // 2) compute available index = (front + size) % data.length
        // 3) store e there
        // 4) increment size
    }

    @Override
    public E dequeue() {
        // TODO:
        // 1) if empty return null
        // 2) store answer = data[front]
        // 3) set data[front] = null (help GC)
        // 4) front = (front + 1) % data.length
        // 5) decrement size
        // 6) return answer
        return null;
    }

    // Helpful for debugging (not graded)
    int capacity() { return data.length; }
}
