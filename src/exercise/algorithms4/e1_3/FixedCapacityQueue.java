package exercise.algorithms4.e1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * �̶���������
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
	 * ���캯��ʵ�ֶ��еĿ���
	 * @param org
	 */
	public FixedCapacityQueue(FixedCapacityQueue<T> org) {
		queue = (T[]) new Object[org.capcity()];
		n = 0;
		for(T item : org){
			queue[n++] = item;
		}
	}
	/**
	 * �ж϶����Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty(){
		return n == 0;
	}
	/**
	 * �ж϶����Ƿ�����
	 * @return
	 */
	public boolean isFull(){
		return n == queue.length;
	}
	/**
	 * ���д�С
	 * @return
	 */
	public int size(){
		return n;
	}
	/**
	 * ��ȡ���е�����
	 * @return
	 */
	public int capcity(){
		return queue.length;
	}
	/**
	 * �Ӷ���β�����
	 * @param value
	 * @throws Exception 
	 */
	public void enqueue(T value) throws Exception{
		if(isFull()) throw new Exception("Overflow");
		queue[n++] = value;
	}
	/**
	 * �Ӷ���ͷ������
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
