import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class VectorHeapTest {

    private VectorHeap<Integer> heap;

    @Before
    public void setUp() {
        heap = new VectorHeap<>();
    }

    @Test
    public void testIsEmptyInitially() {
        assertTrue(heap.isEmpty());
    }

    @Test
    public void testAddAndSize() {
        heap.add(10);
        heap.add(5);
        heap.add(20);

        assertEquals(3, heap.size());
    }

    @Test
    public void testPeek() {
        heap.add(3);
        heap.add(1);
        heap.add(2);

        assertEquals((Integer)1, heap.peek());
    }

    @Test
    public void testRemoveOrder() {
        heap.add(5);
        heap.add(1);
        heap.add(3);

        assertEquals((Integer)1, heap.remove());
        assertEquals((Integer)3, heap.remove());
        assertEquals((Integer)5, heap.remove());
    }

    @Test
    public void testRemoveEmpty() {
        assertNull(heap.remove());
    }

    @Test
    public void testPeekEmpty() {
        assertNull(heap.peek());
    }
}