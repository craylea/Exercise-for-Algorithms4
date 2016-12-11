package exercise.algorithms4.e1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ˫������ʵ��˫�����
 */
public class Deque<T> implements Iterable<T> {

	DoublyLinkedList<T> queue;
	
	public Deque() {
		queue = new DoublyLinkedList<>();
	}
	/**
	 * �ж϶����Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty(){
		return queue.isEmpty();
	}
	/**
	 * ���д�С
	 * @return
	 */
	public int size(){
		return queue.size();
	}
	/**
	 * �Ӷ���ͷ�����
	 * @param value
	 */
	public void pushLeft(T value){
		queue.addFirst(value);
	}
	/**
	 * �Ӷ���β�����
	 * @param value
	 */
	public void pushRight(T value){
		queue.add(value);
	}
	/**
	 * �Ӷ���ͷ������
	 * @return
	 */
	public T popLeft(){
		return queue.deleteFirst();
	}
	/**
	 * �Ӷ���β������
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
	 * Deque�ĵ�����
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

