import java.util.Stack;
import java.util.NoSuchElementException;

/**
 * Simple implementation of a Queue, using two Stacks.
 * 
 * @param <K>
 */

public class MyQueue<K> {

	private Stack<K> left; //1
	private Stack<K> right; //2
	
	public MyQueue(){
		left = new Stack<K>();
		right = new Stack<K>();
	}

	/**
	 * Returns the element at the front of the queue
	 * without removing it.
	 * 
	 * @return element at the front of this queue
	 */
	public K peek() throws NoSuchElementException {
		if (isEmpty()){
			throw new NoSuchElementException("The queue is empty.");
		} else {
			if (right.isEmpty()){
				//pop everything from left stack and push to right stack
				while(!left.isEmpty()){
					right.push(left.pop());
				}
			}
		}		
		return null;
	}

	/**
	 * Adds the specified element e at the back of this queue.
	 * @param k
	 */
	public void enqueue(final K k) {
		left.push(k);
	}

	/**
	 * Deletes and returns the element at the front of this queue.
	 * @return element at the front of this queue
	 */
	public K dequeue() throws NoSuchElementException {
		if (isEmpty())
			throw new NoSuchElementException("Queue is empty.");

		if (right.isEmpty()){
			while (!left.isEmpty()){
				right.push(left.pop());
			}
		}
		return right.pop();
	}

	/**
	 * Tests if this queue is empty.
	 * @return True on empty false otherwise.
	 */
	public boolean isEmpty() {
		return left.size() == 0 && right.size() == 0;
	}
}

