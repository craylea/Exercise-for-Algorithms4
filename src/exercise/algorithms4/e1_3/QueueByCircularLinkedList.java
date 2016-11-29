package exercise.algorithms4.e1_3;

/**
 * 环形队列
 * @author lsp
 *
 */
public class QueueByCircularLinkedList {

	// 指向最后一个节点
	private Node<String> last;
	
	public QueueByCircularLinkedList(){
		last = new Node<>();
	}
	public QueueByCircularLinkedList(String value){
		last = new Node<>();
		last.value = value;
	}
	
	/**
	 * 判断队列是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return last.value == null;
	}
	/**
	 * 入列
	 * @param value
	 */
	public void enqueue(String value){
		if(isEmpty()){
			last.value = value;
			last.next = last;
		}else{
			Node<String> temp = new Node<>();
			temp.value = value;
			temp.next = last.next;
			last.next = temp;
			last = temp;
		}
	}
	/**
	 * 出列
	 * @return
	 */
	public String dequeue(){
		if(isEmpty()) return null;
		Node<String> temp = last.next;
		String item = temp.value;
		if(temp == last){
			last.value = null;
			last.next = null;
		}else{
			last.next = temp.next;
		}
		return item;
	}
	
}
