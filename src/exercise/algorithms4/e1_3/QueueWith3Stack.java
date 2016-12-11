package exercise.algorithms4.e1_3;

import java.util.Iterator;

/**
 * 三个栈实现一个队列
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
	 * 入队
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
	 * 出队
	 * @return
	 */
	public T dequeue(){
		if(third.isEmpty()) return null;
		T value = third.pop();
		size--;
		return value;
	}
	/**
	 * 队列是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return size == 0;
	}
	/**
	 * 队列大小
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
