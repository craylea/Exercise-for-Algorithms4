package exercise.algorithms4.e1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * �ַ�������(˫������)
 * @author lsp
 *
 */
public class EditorBuffer implements Iterable<Character>{

	private DoubleNode<Character> first;
	private DoubleNode<Character> last;
	private DoubleNode<Character> p;
	private int size;
	
	public EditorBuffer(){
		first = null;
		last = null;
		p = null;
		size = 0;
	}
	/**
	 * �ڹ�괦�����ַ�
	 * @param c
	 */
	public void insert(char c){
		if(first == null){
			first = new DoubleNode<>();
			first.pre = first;
			first.value = c;
			first.next = first;
			last = first;
			p = first;
		}else{
			if(p == null){
				// ����Ѿ�����ǰ��
				p = new DoubleNode<>();
				p.value = c;
				p.next = first;
				first = p;
				p.pre = first;
				last.next = first;
			}else{
				DoubleNode<Character> temp = new DoubleNode<>();
				temp.pre = p;
				temp.value = c;
				temp.next = p.next;
				p.next = temp;
				if(p == last){
					last = temp;
					first.pre = last;
				}
				p = temp;
			}
			
		}
		size++;
	}
	/**
	 * ɾ���������λ�õ��ַ�
	 * @return
	 */
	public char delete(){
		if(p == null) throw new NoSuchElementException();
		char c = p.value;
		if(p == first){
			if(size == 1){
				first = null;
				last = null;
			}else{
				first = first.next;
				last.pre = first;
			}
			p = null; // ����ƶ�����ǰ��
		}else{
			DoubleNode<Character> pre = p.pre;
			pre.next = p.next;
			p = pre;
		}
		size--;
		return c;
	}
	/**
	 * ��������ƶ�k���ַ�
	 * @param k
	 * @return ���ʵ���ƶ����ַ���
	 */
	public int left(int k){
		int i = 0;
		while(i < k && p != null){
			if(p == first){
				p = null; // ����ƶ�����ǰ��
			}else{
				p = p.pre;
			}
			i++;
		}
		return i;
	}
	/**
	 * ��������ƶ�k���ַ�
	 * @param k
	 * @return ���ʵ���ƶ����ַ���
	 */
	public int right(int k){
		int i = 0;
		while(i < k){
			if(p == null){
				p = first;
			}else if(p == last){
				break;
			}else{
				p = p.next;
			}
			i++;
		}
		return i;
	}
	/**
	 * �������ַ���
	 * @return
	 */
	public int size(){
		return size;
	}
	/**
	 * ��굱ǰ���ڵ��ַ�
	 * @return
	 */
	public char get(){
		if(p == null) throw new NoSuchElementException();
		char c = p.value;
		return c;
	}
	/**
	 * �ƶ���굽��ǰ
	 */
	public void home(){
		p = null;
	}
	/**
	 * �ƶ���굽���
	 */
	public void end(){
		p = last;
	}
	/**
	 * 
	 */
	@Override
	public Iterator<Character> iterator() {
		
		DoubleNode<Character> temp;
		// ����������֮����ַ�
//		if(p == null){
//			temp = first;
//		}else if(p == last){
//			temp = null;
//		}else{
//			temp = p.next;
//		}
		// �������ȫ�����ַ�
		temp = first;
		return new EditorBufferIterator(temp, last);
	}
	
	private class EditorBufferIterator implements Iterator<Character>{

		DoubleNode<Character> first;
		DoubleNode<Character> last;
		boolean isFirst;
		
		public EditorBufferIterator(DoubleNode<Character> first, DoubleNode<Character> last){
			this.first = first;
			this.last = last;
			isFirst = true; // �״ε������������first == last.next�������
		}
		@Override
		public boolean hasNext() {
			return (first != null && (isFirst || first != last.next));
		}

		@Override
		public Character next() {
			if(!hasNext()) throw new NoSuchElementException();
			Character c = first.value;
			first = first.next;
			if(isFirst) isFirst = !isFirst;
			return c;
		}
		
	}
}
