package exercise.algorithms4.e1_3;

import java.util.Iterator;

/**
 * �ַ�������(ջʵ��)
 * @author lsp
 *
 */
public class EditorBufferByStack implements Iterable<Character>{

	private StequeByLinkedList<Character> first;
	private StequeByLinkedList<Character> last;
	private int size;
	
	public EditorBufferByStack(){
		first = new StequeByLinkedList();
		last = new StequeByLinkedList();
		size = 0;
	}
	/**
	 * �ڹ�괦�����ַ�
	 * @param c
	 */
	public void insert(char c){
		first.push(c);
		size++;
	}
	/**
	 * ɾ���������λ�õ��ַ�
	 * @return
	 */
	public char delete(){
		char c = first.pop();
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
		while(i < k && !first.isEmpty()){
			last.push(first.pop());
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
		while(i < k && !last.isEmpty()){
			first.push(last.pop());
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
	 * �ƶ���굽��ǰ
	 */
	public void home(){
		left(size);
	}
	/**
	 * �ƶ���굽���
	 */
	public void end(){
		right(size);
	}
	/**
	 * ����������֮����ַ�
	 */
	@Override
	public Iterator<Character> iterator() {
		// ����������֮����ַ�
//		return last.iterator();
		// �������ȫ�����ַ�
		StequeByLinkedList<Character> temp = new StequeByLinkedList<>(last);
		StequeByLinkedList<Character> temp2 = new StequeByLinkedList<>(first);
		
		while(!temp2.isEmpty()){
			temp.push(temp2.pop());
		}
		return temp.iterator();
	}
	
}
