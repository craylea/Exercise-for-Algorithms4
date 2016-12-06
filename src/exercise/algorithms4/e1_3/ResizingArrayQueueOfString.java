package exercise.algorithms4.e1_3;

/**
 * 可变数组实现字符串队列
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
	 * 入队
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
	 * 出队
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
	 * 调整队列大小
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
