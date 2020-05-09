package synthesizer;
import edu.princeton.cs.algs4.In;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer(4);
        assertEquals(true, arb.isEmpty());
        arb.enqueue(1);
        arb.enqueue(2);
        assertEquals(false, arb.isFull());
        arb.enqueue(6);
        arb.enqueue(5);
        assertEquals(true, arb.isFull());
        Integer x = arb.dequeue();
        assertEquals(1, (long) x);
        arb.enqueue(19);
        assertEquals(4, arb.fillCount());
        for (Integer arb1 : arb) {
                System.out.println("item: " + arb1);
            }
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
