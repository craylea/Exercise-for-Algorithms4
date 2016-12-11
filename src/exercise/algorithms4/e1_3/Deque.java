package exercise.algorithms4.e1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 双向链表实现双向队列
 */
public class Deque<T> implements Iterable<T> {

	DoublyLinkedList<T> queue;
	
	public Deque() {
		queue = new DoublyLinkedList<>();
	}
	/**
	 * 判断队列是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return queue.isEmpty();
	}
	/**
	 * 队列大小
	 * @return
	 */
	public int size(){
		return queue.size();
	}
	/**
	 * 从队列头部入队
	 * @param value
	 */
	public void pushLeft(T value){
		queue.addFirst(value);
	}
	/**
	 * 从队列尾部入队
	 * @param value
	 */
	public void pushRight(T value){
		queue.add(value);
	}
	/**
	 * 从队列头部出队
	 * @return
	 */
	public T popLeft(){
		return queue.deleteFirst();
	}
	/**
	 * 从队列尾部出队
	 * @return
	 */
	public T popRight(){
		return queue.delete();
	}
	
	@Override
	public Iterator<T> iterator() {
		return new DequeIterator(queue.getFirstNode());
	}
	/**
	 * Deque的迭代器
	 * @author lsp
	 *
	 */
	private class DequeIterator implements Iterator<T>{

		private DoubleNode<T> current;
		private DoubleNode<T> first;
		private boolean isFirst;
		
		public DequeIterator(DoubleNode<T> first){
			this.first = first;
			current = first;
			isFirst = true;
		}
		
		@Override
		public boolean hasNext() {
			return current != null && (isFirst || current != first);
		}

		@Override
		public T next() {
			if (!hasNext()) throw new NoSuchElementException();
			T value = current.value;
			current = current.next;
			if(isFirst) isFirst = !isFirst;
			return value;
		}
		
	}

}

