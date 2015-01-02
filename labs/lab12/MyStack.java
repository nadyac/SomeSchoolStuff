import java.util.NoSuchElementException;
import java.util.*;

/**
 * Simple implementation of Stack using two Queues
 *
 * @param <K>
 */

public class MyStack<K> {
	private Queue<K> q1, q2;

	public MyStack() {
		q1 = new LinkedList<K>();
		q2 = new LinkedList<K>();
	}
    
	/**
	 * Returns the element at the top of the stack
	 * without popping it.
	 *
	 * @return element at the top of this stack
	 */
	public K peek() throws NoSuchElementException{
		if (q2 == null || q2.isEmpty() == true)
			throw new NoSuchElementException("The element is not in the stack.");

		K elem = q2.peek();
        return elem;
	}

	/**
	 * Push an element onto the top of the stack.
	 * @param k The element to push.
	 */
	public void push(K k) {

		if (q1.size() == 0){
			q1.add(k);
		} else {
			int s = q1.size();
			for (int i = 0; i < s; i++){
				q2.add(q1.remove());

				/* enqueue the new element into q2 so it will
				 * be the last thing in q2 but the first in q1*/
				q2.add(k);

				/* dequeue all the elements from q2 to q1*/
				for (i = 0; i < s; i++){
					q1.add(q2.remove());
				}
			}
		}
	}

	/**
	 * Pops the top element off the stack. 
	 * @return The top element on the stack.
	 * @throws NoSuchElementException when popping an empty stack.
	 */
	public K pop() throws NoSuchElementException {
		if (isEmpty()){
			throw new NoSuchElementException("The stack is empty.");
		}
        return q1.remove();
	}

	public boolean isEmpty() {
        return q1.size() == 0 && q2.size() == 0;
	}
}
