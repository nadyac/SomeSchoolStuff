import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MyStackTest {

	MyStack<Integer> stack;
	
	@Before
	public void setUp() throws Exception {
		stack = new MyStack<Integer>();
	}

	@After
	public void tearDown() throws Exception {
		stack = null;
	}

    @Test
	public void testPeek() {
		assert (stack.peek() == null);
	}
    
	@Test
	public void testPush() {
		stack.push(55);
		stack.push(43);
		stack.push(100);
		assert (stack.peek() == 100);
	}
	
	@Test
	public void testPop() {
		assert (stack.pop() == 100);
		assert (stack.pop() == 43);
	}

    @Test
    public void testIsEmpty() {
        assert (!stack.isEmpty());
    }
}
