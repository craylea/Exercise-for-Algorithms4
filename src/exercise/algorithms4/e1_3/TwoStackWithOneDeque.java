package exercise.algorithms4.e1_3;

import java.util.Iterator;

/**
 * 一个双向队列实现两个栈
 * @author lsp
 *
 * @param <T>
 */
public class TwoStackWithOneDeque<T> implements Iterable<T>{

	private Deque<T> stack;
	private int sizeLeft;
	private int sizeRight;
	
	public TwoStackWithOneDeque(){
		stack = new Deque<>();
		sizeLeft = 0;
		sizeRight = 0;
	}
	/**
	 * 左边栈入栈
	 * @param value
	 */
	public void pushLeft(T value){
		stack.pushLeft(value);
		sizeLeft++;
	}
	/**
	 * 左边栈出栈
	 * @return
	 */
	public T popLeft(){
		T value = stack.popLeft();
		sizeLeft--;
		return value;
	}
	/**
	 * 左边栈大小
	 * @return
	 */
	public int sizeLeft(){
		return sizeLeft;
	}
	/**
	 * 左边栈是否为空
	 * @return
	 */
	public boolean isEmptyLeft(){
		return sizeLeft == 0;
	}
	/**
	 * 左边栈迭代
	 * @return
	 */
	public Iterator<T> iteratorLeft(){
		LinkedListGeneralizedQueue<T> tempStack = new LinkedListGeneralizedQueue<>();
		int i = 0;
		for(T item : stack){
			if(i >= sizeLeft) break;
			tempStack.insert(item);
			i++;
		}
		return tempStack.iterator();
	}
	
	
	/**
	 * 右边栈入栈
	 * @param value
	 */
	public void pushRight(T value){
		stack.pushRight(value);
		sizeRight++;
	}
	/**
	 * 右边栈出栈
	 * @return
	 */
	public T popRight(){
		T value = stack.popRight();
		sizeRight--;
		return value;
	}
	/**
	 * 右边栈大小
	 * @return
	 */
	public int sizeRight(){
		return sizeRight;
	}
	/**
	 * 右边栈是否为空
	 * @return
	 */
	public boolean isEmptyRight(){
		return sizeRight == 0;
	}
	/**
	 * 右边栈迭代
	 * @return
	 */
	public Iterator<T> iteratorRight(){
		StequeByLinkedList<T> tempStack = new StequeByLinkedList<>();
		int i = 0;
		for(T item : stack){
			i++;
			if(i > sizeLeft){
				tempStack.push(item);
			}
		}
		return tempStack.iterator();
	}
	
	/**
	 * 迭代所有元素
	 */
	@Override
	public Iterator<T> iterator() {
		return stack.iterator();
	}
	
	
}
