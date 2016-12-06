package exercise.algorithms4.e1_3;

/**
 * 链表实现栈队列
 * @author lsp
 *
 * @param <T>
 */
public class StequeByLinkedList<T> implements Steque<T> {

	private Node<T> first;
	private Node<T> last;
	private int n;
	
	public StequeByLinkedList() {
		first = null;
		last = null;
		n = 0;
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

}
