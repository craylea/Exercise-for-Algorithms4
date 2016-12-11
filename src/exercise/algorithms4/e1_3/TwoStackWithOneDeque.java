package exercise.algorithms4.e1_3;

import java.util.Iterator;

/**
 * һ��˫�����ʵ������ջ
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
	 * ���ջ��ջ
	 * @param value
	 */
	public void pushLeft(T value){
		stack.pushLeft(value);
		sizeLeft++;
	}
	/**
	 * ���ջ��ջ
	 * @return
	 */
	public T popLeft(){
		T value = stack.popLeft();
		sizeLeft--;
		return value;
	}
	/**
	 * ���ջ��С
	 * @return
	 */
	public int sizeLeft(){
		return sizeLeft;
	}
	/**
	 * ���ջ�Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmptyLeft(){
		return sizeLeft == 0;
	}
	/**
	 * ���ջ����
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
	 * �ұ�ջ��ջ
	 * @param value
	 */
	public void pushRight(T value){
		stack.pushRight(value);
		sizeRight++;
	}
	/**
	 * �ұ�ջ��ջ
	 * @return
	 */
	public T popRight(){
		T value = stack.popRight();
		sizeRight--;
		return value;
	}
	/**
	 * �ұ�ջ��С
	 * @return
	 */
	public int sizeRight(){
		return sizeRight;
	}
	/**
	 * �ұ�ջ�Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmptyRight(){
		return sizeRight == 0;
	}
	/**
	 * �ұ�ջ����
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
	 * ��������Ԫ��
	 */
	@Override
	public Iterator<T> iterator() {
		return stack.iterator();
	}
	
	
}
