package exercise.algorithms4.e1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

/**
 * 前移编码
 * @author lsp
 * @param <T>
 *
 */
public class MoveToFront<T> implements Iterable<T>{

	private Node<T> head;
	
	public MoveToFront(){
		head = null;
	}
	/**
	 * 从链表头添加节点
	 * @param key
	 */
	public void add(T key){
		remove(key);
		if(head == null){
			head = new Node<>();
			head.value = key;
			head.next = null;
		}else{
			Node<T> temp = new Node<>();
			temp.value = key;
			temp.next = head;
			head = temp;
		}
	}
	/**
	 * 删除链表中所有元素为key的节点
	 * @param key
	 */
	private void remove(T key){
		if(head == null) return;
		while(head != null && head.value.equals(key)){
			head = head.next;
		}
		Node<T> p = head;
		Node<T> pre = null;
		while(p != null){
			if(p.value.equals(key)){
				pre.next = p.next;
			}else{
				pre = p;
			}
			p = p.next;
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new MoveToFrontIterator(head);
	}
	
	private class MoveToFrontIterator implements Iterator<T>{

		Node<T> first;
		
		public MoveToFrontIterator(Node<T> first){
			this.first = first;
		}
		
		@Override
		public boolean hasNext() {
			return first != null;
		}

		@Override
		public T next() {
			if(!hasNext()) throw new NoSuchElementException();
			T item = first.value;
			first = first.next;
			return item;
		}
		
	}
}
