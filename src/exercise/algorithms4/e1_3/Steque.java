package exercise.algorithms4.e1_3;

/**
 * ջ����
 * @author lsp
 *
 */
public interface Steque<T> {
	/**
	 * ��ͷ�����
	 * @param item
	 */
	public void push(T item);
	/**
	 * ��ͷ������
	 * @return
	 */
	public T pop();
	/**
	 * ��β�����
	 * @param item
	 */
	public void enqueue(T item);
	/**
	 * ���д�С
	 * @return
	 */
	public int size();
	/**
	 * �����Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty();
}
