package exercise.algorithms4.e1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ���Ͷ���(����ʵ��)
 * @author lsp
 *
 * @param <T>
 */
public class LinkedListGeneralizedQueue<T> implements Iterable<T>{

	private Node<T> first;
	private Node<T> last;
	private int n;
	
	public LinkedListGeneralizedQueue(){
		first = null;
		last = null;
		n = 0;
	}
	/**
	 * �ж϶����Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty(){
		return n == 0;
	}
	/**
	 * ���Ԫ��
	 * @param value
	 */
	public void insert(T value){
		if(first == null){
			first = new Node<>();
			first.value = value;
			first.next = null;
			last = first;
		}else{
			Node<T> temp = new Node<>();
			temp.value =value;
			temp.next = null;
			last.next = temp;
			last = temp;
		}
		n++;
	}
	/**
	 * ɾ����k��Ԫ��
	 * @param k
	 * @return
	 */
	public T delete(int k){
		if(k > n || k <= 0) return null;
		Node<T> p = first;
		Node<T> pre = null;
		while(k > 1){
			pre = p;
			p = p.next;
			k--;
		}
		T temp = p.value;
		if(p == first){
			first = first.next;
		}else{
			pre.next = p.next;
			p = null;
		}
		n--;
		return temp;
	}
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new LinkedListGeneralizedQueueIterator();
	}
	
	private class LinkedListGeneralizedQueueIterator implements Iterator<T>{

		private int i;
		private Node<T> p;
		
		public LinkedListGeneralizedQueueIterator(){
			p = first;
			i = 0;
		}
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i < n;
		}

		@Override
		public T next() {
			if(!hasNext()) throw new NoSuchElementException();
			T item = p.value;
			p = p.next;
			i++;
			return item;
		}
		
	}
}

