import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayQueueTest {

    // TC01
    @Test
    void tc01_emptyQueueBehavior() {
        QueueADT<Integer> q = new ArrayQueue<>(5);
        assertTrue(q.isEmpty());
        assertEquals(0, q.size());
        assertNull(q.first());
        assertNull(q.dequeue());
    }

    // TC02
    @Test
    void tc02_fifoOrder() {
        QueueADT<Integer> q = new ArrayQueue<>(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        assertEquals(10, q.first());
        assertEquals(10, q.dequeue());
        assertEquals(20, q.dequeue());
        assertEquals(30, q.dequeue());
        assertTrue(q.isEmpty());
    }

    // TC03
    @Test
    void tc03_wrapAroundWorks() {
        ArrayQueue<Integer> q = new ArrayQueue<>(4);

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        assertEquals(1, q.dequeue());
        assertEquals(2, q.dequeue());

        q.enqueue(4);
        q.enqueue(5);

        assertEquals(3, q.dequeue());
        assertEquals(4, q.dequeue());
        assertEquals(5, q.dequeue());
        assertTrue(q.isEmpty());
    }

    // TC04
    @Test
    void tc04_fullQueueThrows() {
        QueueADT<Integer> q = new ArrayQueue<>(3);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        assertThrows(IllegalStateException.class, () -> q.enqueue(4));
    }

    // TC05
    @Test
    void tc05_sizeTracksCorrectly() {
        QueueADT<String> q = new ArrayQueue<>(3);
        assertEquals(0, q.size());
        q.enqueue("A");
        assertEquals(1, q.size());
        q.enqueue("B");
        assertEquals(2, q.size());
        q.dequeue();
        assertEquals(1, q.size());
        q.dequeue();
        assertEquals(0, q.size());
        assertTrue(q.isEmpty());
    }

    // TC06
    @Test
    void tc06_alternatingOps() {
        QueueADT<Integer> q = new ArrayQueue<>(5);
        q.enqueue(1);
        q.enqueue(2);
        assertEquals(1, q.dequeue());

        q.enqueue(3);
        assertEquals(2, q.dequeue());

        q.enqueue(4);
        q.enqueue(5);

        assertEquals(3, q.dequeue());
        assertEquals(4, q.dequeue());
        assertEquals(5, q.dequeue());
        assertNull(q.dequeue());
    }

    // TC07
    @Test
    void tc07_multipleWrapCycles() {
        ArrayQueue<Integer> q = new ArrayQueue<>(3);

        // cycle 1
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        assertEquals(1, q.dequeue());
        q.enqueue(4); // wrap

        // queue should be 2,3,4
        assertEquals(2, q.dequeue());
        assertEquals(3, q.dequeue());
        assertEquals(4, q.dequeue());
        assertTrue(q.isEmpty());

        // cycle 2
        q.enqueue(10);
        q.enqueue(20);
        assertEquals(10, q.dequeue());
        q.enqueue(30);
        assertEquals(20, q.dequeue());
        assertEquals(30, q.dequeue());
        assertTrue(q.isEmpty());
    }

    // TC08
    @Test
    void tc08_firstDoesNotRemove() {
        QueueADT<String> q = new ArrayQueue<>(4);
        q.enqueue("X");
        q.enqueue("Y");

        assertEquals("X", q.first());
        assertEquals(2, q.size());         // first() must not change size
        assertEquals("X", q.dequeue());
        assertEquals("Y", q.dequeue());
        assertNull(q.first());
    }

    // TC09
    @Test
    void tc09_dequeueUntilEmpty() {
        QueueADT<Integer> q = new ArrayQueue<>(4);
        q.enqueue(7);
        q.enqueue(8);

        assertEquals(7, q.dequeue());
        assertEquals(8, q.dequeue());
        assertTrue(q.isEmpty());
        assertNull(q.dequeue()); // extra dequeue should return null
    }

    // TC10
    @Test
    void tc10_capacityOneEdge() {
        QueueADT<Integer> q = new ArrayQueue<>(1);

        assertTrue(q.isEmpty());
        q.enqueue(99);
        assertEquals(1, q.size());
        assertEquals(99, q.first());

        assertThrows(IllegalStateException.class, () -> q.enqueue(100));

        assertEquals(99, q.dequeue());
        assertTrue(q.isEmpty());
        assertNull(q.dequeue());
    }
}
