package exercise.algorithms4.e1_3;

/**
 * 栈队列
 * @author lsp
 *
 */
public interface Steque<T> {
	/**
	 * 从头部入队
	 * @param item
	 */
	public void push(T item);
	/**
	 * 从头部出队
	 * @return
	 */
	public T pop();
	/**
	 * 从尾部入队
	 * @param item
	 */
	public void enqueue(T item);
	/**
	 * 队列大小
	 * @return
	 */
	public int size();
	/**
	 * 队列是否为空
	 * @return
	 */
	public boolean isEmpty();
}
