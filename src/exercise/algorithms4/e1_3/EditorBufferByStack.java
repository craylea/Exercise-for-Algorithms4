package exercise.algorithms4.e1_3;

import java.util.Iterator;

/**
 * 字符缓冲区(栈实现)
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
	 * 在光标处插入字符
	 * @param c
	 */
	public void insert(char c){
		first.push(c);
		size++;
	}
	/**
	 * 删除光标所在位置的字符
	 * @return
	 */
	public char delete(){
		char c = first.pop();
		size--;
		return c;
	}
	/**
	 * 光标向左移动k个字符
	 * @param k
	 * @return 光标实际移动的字符数
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
	 * 光标向右移动k个字符
	 * @param k
	 * @return 光标实际移动的字符数
	 */
	public int right(int k){
		int i = 0;
		while(i < k && !last.isEmpty()){
			first.push(last.pop());
		}
		return i;
	}
	/**
	 * 缓冲区字符数
	 * @return
	 */
	public int size(){
		return size;
	}
	/**
	 * 移动光标到最前
	 */
	public void home(){
		left(size);
	}
	/**
	 * 移动光标到最后
	 */
	public void end(){
		right(size);
	}
	/**
	 * 迭代输出光标之后的字符
	 */
	@Override
	public Iterator<Character> iterator() {
		// 迭代输出光标之后的字符
//		return last.iterator();
		// 迭代输出全部的字符
		StequeByLinkedList<Character> temp = new StequeByLinkedList<>(last);
		StequeByLinkedList<Character> temp2 = new StequeByLinkedList<>(first);
		
		while(!temp2.isEmpty()){
			temp.push(temp2.pop());
		}
		return temp.iterator();
	}
	
}
