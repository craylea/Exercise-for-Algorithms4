package exercise.algorithms4.e1_3;

import java.util.Iterator;

/**
 * ����ջʵ��һ������
 * @author lsp
 *
 * @param <T>
 */
public class QueueWith3Stack<T> implements Iterable<T>{

	private StequeByLinkedList<T> first;
	private StequeByLinkedList<T> second;
	private StequeByLinkedList<T> third;
	private int size;
	
	public QueueWith3Stack(){
		first = new StequeByLinkedList<>();
		second = new StequeByLinkedList<>();
		third = new StequeByLinkedList<>();
		size = 0;
	}
	/**
	 * ���
	 * @param value
	 */
	public void enqueue(T value){
		while(!third.isEmpty()){
			second.push(third.pop());
		}
		first.push(value);
		third.push(first.pop());
		while(!second.isEmpty()){
			third.push(second.pop());
		}
		size++;
	}
	/**
	 * ����
	 * @return
	 */
	public T dequeue(){
		if(third.isEmpty()) return null;
		T value = third.pop();
		size--;
		return value;
	}
	/**
	 * �����Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty(){
		return size == 0;
	}
	/**
	 * ���д�С
	 * @return
	 */
	public int size(){
		return size;
	}
	@Override
	public Iterator<T> iterator() {
		return third.iterator();
	}
	
	
}
