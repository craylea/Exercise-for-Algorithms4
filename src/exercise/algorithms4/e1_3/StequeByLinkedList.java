package exercise.algorithms4.e1_3;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 链表实现栈队列
 * @author lsp
 *
 * @param <T>
 */
public class StequeByLinkedList<T> implements Steque<T>, Iterable<T> {

	private Node<T> first;
	private Node<T> last;
	private int n;
	private int pushTimes;
	private int popTimes;
	
	public StequeByLinkedList() {
		first = null;
		last = null;
		n = 0;
		pushTimes = 0;
		popTimes = 0;
	}
	/**
	 * 构造函数实现栈的拷贝
	 * @param org
	 */
	public StequeByLinkedList(StequeByLinkedList<T> org) {
		this();
		if(org != null){
			for(T item : org){
				// 本来是用push方法，测试发现拷贝后的栈与源栈反了。
				// 而正好有一个栈尾入栈的方法enqueue，这难道是作者老早就设下的铺垫。
				enqueue(item); 
			}
		}
	}
	
	@Override
	public void push(T item) {
		if(isEmpty()){
			first = new Node<>();
			first.value = item;
			first.next = null;
			last = first;
		}else{
			Node<T> temp = new Node<>();
			temp.value = item;
			temp.next = first;
			first = temp;
		}
		pushTimes++;
		n++;
	}

	@Override
	public T pop() {
		T item = null;
		if(!isEmpty()){
			item = first.value;
			first = first.next;
			if(first == null) last = null;
			n--;
		}
		popTimes++;
		return item;
	}

	@Override
	public void enqueue(T item) {
		if(isEmpty()){
			first = new Node<>();
			first.value = item;
			first.next = null;
			last = first;
		}else{
			Node<T> temp = new Node<>();
			temp.value = item;
			temp.next = null;
			last.next = temp;
			last = temp;
		}
		pushTimes++;
		n++;
	}

	@Override
	public int size() {
		return n;
	}

	@Override
	public boolean isEmpty() {
		return n == 0;
	}
	@Override
	public Iterator<T> iterator() {
		return new StequeByLinkedListIterator(first);
	}

	
	private class StequeByLinkedListIterator implements Iterator<T>{

		private Node<T> first;
		private int orgPushTimes;
		private int orgPopTimes;
		
		public StequeByLinkedListIterator(Node<T> first){
			this.first = first;
			orgPushTimes = pushTimes;
			orgPopTimes = popTimes;
		}
		
		@Override
		public boolean hasNext() {
			if(orgPushTimes != pushTimes){
				throw new ConcurrentModificationException("迭代期间进行了非法入栈操作！");
			}
			if(orgPopTimes != popTimes){
				throw new ConcurrentModificationException("迭代期间进行了非法出栈操作！");
			}
			return this.first != null;
		}

		@Override
		public T next() {
			if(orgPushTimes != pushTimes){
				throw new ConcurrentModificationException("迭代期间进行了非法入栈操作！");
			}
			if(orgPopTimes != popTimes){
				throw new ConcurrentModificationException("迭代期间进行了非法出栈操作！");
			}
			if(!hasNext()) throw new NoSuchElementException();
			T item = this.first.value;
			this.first = this.first.next;
			return item;
		}
		
	}
	
}
