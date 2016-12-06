package exercise.algorithms4.e1_3;

/**
 * �ɱ�����ʵ���ַ�������
 * @author lsp
 *
 */
public class ResizingArrayQueueOfString {

	private String[] queue;
	private int n;
	
	public ResizingArrayQueueOfString(int cap){
		queue = new String[cap];
		n = 0;
	}
	/**
	 * ���
	 * @param item
	 * @throws Exception
	 */
	public void enqueue(String item) throws Exception{
		if(n == queue.length){
			resize(2 * queue.length);
		}
		queue[n++] = item;
	}
	/**
	 * ����
	 * @return
	 * @throws Exception
	 */
	public String dequeue() throws Exception{
		if(isEmpty()){
			throw new Exception("Underflow");
		}else if(n < queue.length / 2){
			resize(queue.length / 2);
		}
		String item = queue[0];
		for(int i = 0; i < n - 1; i++){
			queue[i] = queue[i + 1];
		}
		queue[--n] = null;
		return item;
	}
	
	public boolean isEmpty(){
		return n == 0;
	}
	
	public int size(){
		return n;
	}
	/**
	 * �������д�С
	 * @param newCap
	 * @return
	 */
	private void resize(int newCap){
		String[] newQueue = new String[newCap];
		for(int i = 0; i < n; i++){
			newQueue[i] = queue[i];
		}
		queue = newQueue;
	}
	
}
