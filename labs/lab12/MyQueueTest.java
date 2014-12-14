import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MyQueueTest {

	MyQueue<Integer> queue;
	
	@Before
	public void setUp() throws Exception {
		queue = new MyQueue<Integer>();
	}

	@After
	public void tearDown() throws Exception {
		queue = null;
	}

	@Test
	public void testEnqueue() {
		queue.enqueue(19);
		assert (!queue.isEmpty());
		assert (queue.peek() == 19);
	}

	@Test
	public void testDequeue() {
		assert (queue.dequeue() == 19);
	}
	
	@Test
	public void testPeek() {
		queue.enqueue(20);
		queue.enqueue(24);
		queue.enqueue(98);
		assert (queue.peek() == 20);
	}

    @Test
    public void testIsEmpty() {
        assert (queue.isEmpty() == false);
    }
}
