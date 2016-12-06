package exercise.algorithms4.e1_3;

public class DoublyLinkedList<T> {

	private DoubleNode<T> first;
	private int size = 0;
	
	/**
	 * ������β���ӽڵ�
	 * @param value
	 */
	public void add(T value){
		if(isEmpty()){
			first = new DoubleNode<>();
			first.value = value;
			first.pre = first;
			first.next = first;
		}else{
			DoubleNode<T> p = first.pre;
//			while(p.next != first){
//				p = p.next;
//			}
			DoubleNode<T> temp = new DoubleNode<>();
			temp.value = value;
			temp.pre = p;
			temp.next = p.next;
			p.next = temp;
			first.pre = temp;
		}
		size++;
	}
	/**
	 * ������ͷ���ӽڵ�
	 * @param value
	 */
	public void addFirst(T value){
		if(isEmpty()){
			first = new DoubleNode<>();
			first.value = value;
			first.pre = first;
			first.next = first;
		}else{
			DoubleNode<T> p = first.pre;
//			while(p.next != first){
//				p = p.next;
//			}
			DoubleNode<T> temp = new DoubleNode<>();
			temp.value = value;
			temp.pre = p;
			temp.next = p.next;
			p.next = temp;
			first.pre = temp;
			first = temp; // �������׽ڵ�ָ�������Ľڵ�
		}
		size++; 
	}
	/**
	 * ������βɾ���ڵ�
	 * @return
	 */
	public T delete(){
		if(isEmpty()) return null;
		T item = null;
		if(size == 1){
			item = first.value;
			first = null;
		}else{
			DoubleNode<T> p = first.pre;
			DoubleNode<T> temp = p.pre;
			temp.next = first;
			first.pre = temp;
			item = p.value;
		}
		size--;
		return item;
	}
	/**
	 * ������ͷɾ���ڵ�
	 * @return
	 */
	public T deleteFirst(){
		if(isEmpty()) return null;
		T item = null;
		if(size == 1){
			item = first.value;
			first = null;
		}else{
			DoubleNode<T> p = first.pre;
			DoubleNode<T> temp = first.next;
			temp.pre = p;
			p.next = temp;
			item = first.value;
			first = temp;
		}
		size--;
		return item;
	}
	/**
	 * ָ���ڵ�ǰ����ڵ�
	 * @param index
	 * @param value
	 * @return ʵ��λ��
	 */
	public int insertBefore(int index, T value){
		if(isEmpty()) {
			add(value);
			return 1;
		}
		if(index == 1){
			addFirst(value);
			return 1;
		}
		int i = 1;
		DoubleNode<T> p = first;
		// ����index�ڵ�
		while(i < index && p.next != first){
			p = p.next;
			i++;
		}
		DoubleNode<T> temp = new DoubleNode<>();
		temp.value = value;
		if(i != index){ // û���ҵ�index�ڵ㣬��ô�����ӵĽڵ���Ϊ���һ���ڵ�
			add(value);
			return i + 1;
//			temp.pre = p;
//			temp.next = first;
//			p.next = temp;
//			first.pre = temp;
		}else{
			temp.pre = p.pre;
			temp.next = p;
			p.pre.next = temp;
			p.pre = temp;
		}
		size++;
		return index;
	}
	/**
	 * ָ���ڵ�����ڵ�
	 * @param index
	 * @param value
	 * @return ʵ��λ��
	 */
	public int insertAfter(int index, T value){
		return insertBefore(index + 1, value);
	}
	public T delete(int index){
		T item = null;
		if(index == 1) {
			item = deleteFirst();
		}else{
			DoubleNode<T> p = first;
			int i = 1;
			// ����index�ڵ�
			while(i < index && p.next != first){
				p = p.next;
				i++;
			}
			// �ҵ�index�ڵ�
			if(i == index){
				item = p.value;
				p.pre.next = p.next;
				p.next.pre = p.pre;
			}
		}
		return item;
	}
	/**
	 * ��ȡ������׽ڵ�
	 * @return
	 */
	public DoubleNode<T> getFirstNode(){
		return first;
	}
	/**
	 * �ж������Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty(){
		return size == 0;
	}
	/**
	 * �����С
	 * @return
	 */
	public int size(){
		return size;
	}
}
