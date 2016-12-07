package exercise.algorithms4.e1_3;

/**
 * ���Ͷ���(����ʵ��)
 * @author lsp
 *
 * @param <T>
 */
public class ResizingArrayGeneralizedQueue<T> {

	private T[] queue;
	private int n;
	
	public ResizingArrayGeneralizedQueue(int cap){
		queue = (T[]) new Object[cap];
		n = 0;
	}
	/**
	 * �ж϶����Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty(){
		return n == 0;
	}
	/**
	 * ���Ԫ��
	 * @param value
	 */
	public void insert(T value){
		if(n == queue.length) resize(queue.length * 2);
		queue[n++] = value;
	}
	/**
	 * ɾ����k��Ԫ��
	 * @param k
	 * @return
	 */
	public T delete(int k){
		if(k > n || k <= 0) return null;
		T temp = queue[k - 1];
		for(int i = k; i < n; i++){
			queue[i - 1] = queue[i];
		}
		queue[--n] = null;
		if(n > 0 && n == queue.length / 4) resize(queue.length / 2);
		return temp;
	}
	/**
	 * �ı���е�����
	 * @param cap
	 */
	private void resize(int cap){
		T[] newQueue = (T[]) new Object[cap];
		for(int i = 0; i < n; i++){
			newQueue[i] = queue[i];
		}
		queue = newQueue;
	}
}

