import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackUsingQueueTest {

    // TC11
    @Test
    void tc11_emptyStackBehavior() {
        StackADT<Integer> s = new StackUsingQueue<>(5);
        assertTrue(s.isEmpty());
        assertEquals(0, s.size());
        assertNull(s.top());
        assertNull(s.pop());
    }

    // TC12
    @Test
    void tc12_lifoOrder() {
        StackADT<Integer> s = new StackUsingQueue<>(10);
        s.push(1);
        s.push(2);
        s.push(3);

        assertEquals(3, s.top());
        assertEquals(3, s.pop());
        assertEquals(2, s.pop());
        assertEquals(1, s.pop());
        assertTrue(s.isEmpty());
    }

    // TC13
    @Test
    void tc13_interleavedOps() {
        StackADT<String> s = new StackUsingQueue<>(10);
        s.push("A");
        s.push("B");
        assertEquals("B", s.pop());
        s.push("C");
        assertEquals("C", s.top());
        assertEquals("C", s.pop());
        assertEquals("A", s.pop());
        assertNull(s.pop());
    }

    // TC14
    @Test
    void tc14_topDoesNotRemove() {
        StackADT<Integer> s = new StackUsingQueue<>(10);
        s.push(5);
        s.push(6);

        assertEquals(6, s.top());
        assertEquals(2, s.size());   // top() must not change size
        assertEquals(6, s.pop());
        assertEquals(5, s.pop());
    }

    // TC15
    @Test
    void tc15_sizeTracksCorrectly() {
        StackADT<Integer> s = new StackUsingQueue<>(10);
        assertEquals(0, s.size());

        s.push(10);
        assertEquals(1, s.size());

        s.push(20);
        assertEquals(2, s.size());

        s.pop();
        assertEquals(1, s.size());

        s.pop();
        assertEquals(0, s.size());
        assertTrue(s.isEmpty());
    }

    // TC16
    @Test
    void tc16_popUntilEmpty() {
        StackADT<Integer> s = new StackUsingQueue<>(10);
        s.push(100);

        assertEquals(100, s.pop());
        assertTrue(s.isEmpty());
        assertNull(s.pop());
        assertNull(s.top());
    }

    // TC17
    @Test
    void tc17_capacityLimitThrows() {
        StackADT<Integer> s = new StackUsingQueue<>(2);
        s.push(10);
        s.push(20);
        assertThrows(IllegalStateException.class, () -> s.push(30));
    }

    // TC18
    @Test
    void tc18_manyPushesAndPops() {
        StackADT<Integer> s = new StackUsingQueue<>(50);

        for (int i = 1; i <= 20; i++) {
            s.push(i);
        }

        assertEquals(20, s.top());
        assertEquals(20, s.size());

        for (int i = 20; i >= 1; i--) {
            assertEquals(i, s.pop());
        }

        assertTrue(s.isEmpty());
        assertNull(s.pop());
    }

    // TC19
    @Test
    void tc19_alternatingPattern() {
        StackADT<Integer> s = new StackUsingQueue<>(10);

        s.push(1);
        s.push(2);
        assertEquals(2, s.pop());

        s.push(3);
        assertEquals(3, s.pop());

        s.push(4);
        s.push(5);
        assertEquals(5, s.pop());
        assertEquals(4, s.pop());

        assertEquals(1, s.pop());
        assertTrue(s.isEmpty());
    }

    // TC20
    @Test
    void tc20_capacityOneEdge() {
        StackADT<String> s = new StackUsingQueue<>(1);

        s.push("X");
        assertEquals("X", s.top());
        assertThrows(IllegalStateException.class, () -> s.push("Y"));

        assertEquals("X", s.pop());
        assertNull(s.pop());
        assertNull(s.top());
    }
}
