package exercise.algorithms4.e1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 可变数组实现双向队列
 * @author lsp
 *
 * @param <T>
 */
public class FixedCapacityQueue<T> implements Iterable<T>{

	private T[] queue;
	private int n;
	
	public FixedCapacityQueue(int cap) {
		queue = (T[]) new Object[cap];
		n = 0;
	}
	/**
	 * 判断队列是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return n == 0;
	}
	/**
	 * 判断队列是否已满
	 * @return
	 */
	public boolean isFull(){
		return n == queue.length;
	}
	/**
	 * 队列大小
	 * @return
	 */
	public int size(){
		return n;
	}
	/**
	 * 从队列尾部入队
	 * @param value
	 * @throws Exception 
	 */
	public void enqueue(T value) throws Exception{
		if(isFull()) throw new Exception("Overflow");
		queue[n++] = value;
	}
	/**
	 * 从队列头部出队
	 * @return
	 */
	public T dequeue(){
		if(isEmpty()) return null;
		T item = queue[0];
		for(int i = 0; i < n - 1; i++){
			queue[i] = queue[i + 1];
		}
		queue[--n] = null;
		return item;
	}
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new ResizingDequeIterator();
	}
	
	private class ResizingDequeIterator implements Iterator<T>{

		private int i = 0;
		@Override
		public boolean hasNext() {
			return i < n;
		}

		@Override
		public T next() {
			if(!hasNext()) throw new NoSuchElementException();;
			return queue[i++];
		}
		
	}
	
	
}
