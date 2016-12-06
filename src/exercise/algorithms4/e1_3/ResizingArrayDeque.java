package exercise.algorithms4.e1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 可变数组实现双向队列
 * @author lsp
 *
 * @param <T>
 */
public class ResizingArrayDeque<T> implements Iterable<T>{

	private T[] queue;
	private int n;
	
	public ResizingArrayDeque(int cap) {
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
	 * 从队列头部入队
	 * @param value
	 */
	public void pushLeft(T value){
		if(isFull()) resize(queue.length * 2); // TODO resize
		for(int i = n; i > 0; i--){
			queue[i] = queue[i - 1];
		}
		queue[0] = value;
		n++;
	}
	/**
	 * 从队列尾部入队
	 * @param value
	 */
	public void pushRight(T value){
		if(isFull()) resize(queue.length * 2); // TODO resize
		queue[n++] = value;
	}
	/**
	 * 从队列头部出队
	 * @return
	 */
	public T popLeft(){
		if(isEmpty()) return null;
		T item = queue[0];
		for(int i = 0; i < n - 1; i++){
			queue[i] = queue[i + 1];
		}
		queue[--n] = null;
		if (n > 0 && n == queue.length/4) resize(queue.length / 2);
		return item;
	}
	/**
	 * 从队列尾部出队
	 * @return
	 */
	public T popRight(){
		if(isEmpty()) return null;
		T item = queue[n - 1];
		queue[--n] = null;
		if (n > 0 && n == queue.length/4) resize(queue.length / 2);
		return item;
	}
	/**
	 * 调整队列容量
	 * @param cap
	 * @return
	 */
	private void resize(int cap){
		T[] newQueue = (T[]) new Object[cap];
		for(int i = 0; i < n; i++){
			newQueue[i] = queue[i];
		}
		queue = newQueue;
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
