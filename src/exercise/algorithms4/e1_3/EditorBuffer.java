package exercise.algorithms4.e1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 字符缓冲区(双向链表)
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
	 * 在光标处插入字符
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
				// 光标已经在最前端
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
	 * 删除光标所在位置的字符
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
			p = null; // 光标移动到最前端
		}else{
			DoubleNode<Character> pre = p.pre;
			pre.next = p.next;
			p = pre;
		}
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
		while(i < k && p != null){
			if(p == first){
				p = null; // 光标移动到最前端
			}else{
				p = p.pre;
			}
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
	 * 缓冲区字符数
	 * @return
	 */
	public int size(){
		return size;
	}
	/**
	 * 光标当前所在的字符
	 * @return
	 */
	public char get(){
		if(p == null) throw new NoSuchElementException();
		char c = p.value;
		return c;
	}
	/**
	 * 移动光标到最前
	 */
	public void home(){
		p = null;
	}
	/**
	 * 移动光标到最后
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
		// 迭代输出光标之后的字符
//		if(p == null){
//			temp = first;
//		}else if(p == last){
//			temp = null;
//		}else{
//			temp = p.next;
//		}
		// 迭代输出全部的字符
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
			isFirst = true; // 首次迭代，处理参数first == last.next的情况。
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
