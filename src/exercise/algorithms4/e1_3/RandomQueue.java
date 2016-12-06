package exercise.algorithms4.e1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

/**
 * �������
 * @author lsp
 *
 * @param <T>
 */
public class RandomQueue<T> implements Iterable<T>{
	private T[] queue;
	private int n;
	
	public RandomQueue(int cap){
		queue = (T[]) new Object[cap];
		n = 0;
	}
	/**
	 * �ж��Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty(){
		return n == 0;
	}
	/**
	 * ���
	 * @param value
	 */
	public void enqueue(T value){
		if(n == queue.length) resize(queue.length * 2);
		queue[n++] = value;
	}
	/**
	 * ����,�������һ��Ԫ�ص�ֵ,���Ұ����Ӷ�����ɾ��
	 * @return
	 */
	public T dequeue(){
		if(isEmpty()) return null;
		int i = StdRandom.uniform(n);
		T temp = queue[i];
		queue[i] = queue[n - 1];
		queue[--n] = null;
		if(n > 0 && n == queue.length / 4) resize(queue.length / 2);
		return temp;
	}
	/**
	 * �������һ��Ԫ�ص�ֵ,����ɾ��
	 * @return
	 */
	public T sample(){
		if(isEmpty()) return null;
		int i = StdRandom.uniform(n);
		T temp = queue[i];
		return temp;
	}
	/**
	 * �ı��������
	 * @param cap
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
		return new RandomQueueIterator();
	}
	
	private class RandomQueueIterator implements Iterator<T>{

		int i = 0;
		T[] iteratorQueue;
		public RandomQueueIterator() {
			iteratorQueue = (T[]) new Object[n];
			for(int i = 0; i < n; i++){
				iteratorQueue[i] = queue[i];
			}
			for(int i = 0; i < n; i++){
				int j = StdRandom.uniform(i, n);
				T temp = iteratorQueue[i];
				iteratorQueue[i] = iteratorQueue[j];
				iteratorQueue[j] = temp;
			}
		}
		
		@Override
		public boolean hasNext() {
			return i < n;
		}

		@Override
		public T next() {
			if(!hasNext()) throw new NoSuchElementException();
			return iteratorQueue[i++];
		}
		
	}
	
}
