package exercise.algorithms4.e1_3;

/**
 * ���ζ���
 * @author lsp
 *
 */
public class QueueByCircularLinkedList {

	// ָ�����һ���ڵ�
	private Node<String> last;
	
	public QueueByCircularLinkedList(){
		last = new Node<>();
	}
	public QueueByCircularLinkedList(String value){
		last = new Node<>();
		last.value = value;
	}
	
	/**
	 * �ж϶����Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty(){
		return last.value == null;
	}
	/**
	 * ����
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
	 * ����
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
