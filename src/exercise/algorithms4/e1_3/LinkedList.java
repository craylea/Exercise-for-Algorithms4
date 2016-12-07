package exercise.algorithms4.e1_3;

/**
 * ��������
 * @author lsp
 *
 */
public class LinkedList {

	private Node<String> first;

	public LinkedList() {
		first = new Node<>();
	}

	public LinkedList(String value) {
		first = new Node<>();
		first.value = value;
	}

	/**
	 * ����������ӽڵ�
	 * 
	 * @param value
	 * @return
	 */
	public Node<String> add(String value) {
		Node<String> temp = new Node<>();
		temp.value = value;

		if (first.value == null) {
			first = temp;
		} else {
			Node<String> p = first;
			while (p.next != null) {
				p = p.next;
			}
			p.next = temp;
		}
		return temp;
	}

	public Node<String> getFirstNode() {
		return first;
	}

	/**
	 * ɾ�������е�k�ڵ�
	 * 
	 * @param k
	 * @return
	 */
	public int delete(int k) {
		if (first == null)
			return -1;
		if (k == 1) {
			first = first.next;
		} else {
			Node<String> p = first;
			Node<String> pre = first;

			int i = 0;
			// �ҵ���k-1��Ԫ��
			while (i < k - 1 && p != null) {
				pre = p;
				p = p.next;
				i++;
			}

			if (i == k - 1 && p != null) {
				// �ѵ�k-1��Ԫ�ص�nextָ���k��Ԫ�ص�next
				// ǧ����ʹ�ðѵ�k��Ԫ��=��k��Ԫ�ص�next��
				// p = p.next��������û�а�first����ĵ�k��Ԫ��ɾ���������Ǹı��˱���p��ָ��
				// Ҳ����˵�����ǲ��ܸ����ñ�������Ҫ������ָ������ݵ�ֵ��
				pre.next = p.next;
			} else {
				// ��k��Ԫ�ز�����
				return -1;
			}
		}

		return k;
	}

	/**
	 * ɾ�����һ���ڵ�
	 */
	public void deleteLastItem() {
		if (first == null)
			return;
		if (first.next == null) {
			first = null;
			return;
		}
		Node<String> pre = first;
		Node<String> p = first;
		while (p.next != null) {
			pre = p;
			p = p.next;
		}
		pre.next = null;
	}

	/**
	 * ���������Ƿ����ֵΪkey�Ľڵ�
	 * 
	 * @param key
	 * @return
	 */
	public boolean find(String key) {
		Node<String> p = first;
		boolean isFound = false;
		while (p != null) {
			if (p.value.equals(key)) {
				isFound = true;
				break;
			}
			p = p.next;
		}
		return isFound;
	}

	/**
	 * ɾ��ָ���ڵ�item֮��Ľڵ�
	 * 
	 * @param item
	 */
	public void removeAfter(Node<String> item) {
		if (item != null && item.next != null) {
			item.next = null;
		}
	}

	/**
	 * �� node1֮�����node2
	 * 
	 * @param node1
	 * @param node2
	 */
	public void insertAfter(Node<String> node1, Node<String> node2) {
		if (node1 == null)
			return;
		Node<String> temp = node1.next;
		node1.next = node2;
		if (node2 != null) {
			node2.next = temp;
		}
	}

	/**
	 * ɾ������������ֵΪkey�Ľڵ�
	 * 
	 * @param list
	 * @param key
	 * @return
	 */
	public static int remove(LinkedList list, String key) {
		int count = 0;
		if (list != null && key != null) {
			Node<String> p = list.getFirstNode();
			// �����1���ڵ�
			while (p != null && p.value.equals(key)) {
				list.delete(1);
				count++;
				p = list.getFirstNode();
			}
			Node<String> pre = null;
			while (p != null) {
				if (p.value.equals(key)) {
					pre.next = p.next;
					count++;
				} else {
					pre = p;
				}
				p = p.next;
			}
		}

		return count;
	}
	/**
	 * ��ȡ������ֵ���Ľڵ��ֵ
	 * @param list
	 * @return
	 */
	public static String max(LinkedList list){
		if(list == null){
			return null;		
		}
		String maxStr = null;
		Node<String> p = list.getFirstNode();
		maxStr = p.value;
		while(p != null){
			if(p.value.compareTo(maxStr) > 0) maxStr = p.value;
			p = p.next;
		}
		
		return maxStr;
	}
	/**
	 * �ݹ��ȡ������ֵ���Ľڵ��ֵ
	 * @param node
	 * @return
	 */
	public String maxByRecursion(Node<String> node){
		if(node == null){
			return null;		
		}
		String maxStr = null;
		Node<String> p = node;
		maxStr = p.value;
		Node<String> next = node.next;
		String temp = maxByRecursion(next);
		if(temp != null && temp.compareTo(maxStr) > 0) maxStr = temp;
		
		return maxStr;
	}
	/**
	 * ��ת����
	 * @param node
	 * @return
	 */
	public Node<String> reverse(Node<String> node){
		Node<String> pre = null;
		Node<String> p = node;
		Node<String> next = null;
		while(p != null){
			next = p.next;
			p.next = pre;
			pre = p;
			p = next;
		}
		first = pre; // ��� first = pre; ��������ԭ����ת�ˣ������ֻʣfirstһ���ڵ��ˡ�
		return pre;
	}
	/**
	 * �ݹ鷽�� ��ת����
	 * ��ֱ�ӷ�ת��Ƚϣ�ֱ�ӷ�ת�Ĺ����Ǵ�����ĵ�һ���ڵ㿪ʼ��ת��-><- -><- -><-
	 * ���ݹ鷽����ת�Ĺ�������һֱ�ݹ鵽��������һ���ڵ㣬Ȼ������һ��һ����ת�� 
	 * -> -> -> 
	 * <- <- <-
	 * @param node
	 * @return
	 */
	public Node<String> reverseByRecursion(Node<String> node){
		if(node == null) return null; // ����ĵ�һ���ڵ����null
		if(node.next == null) return node;
		
		Node<String> p = node;
		Node<String> next = p.next;
		Node<String> pre = reverseByRecursion(next);
		next.next = p;
		p.next = null; // pʵ�ʾ�����һ�ݹ��next, ����ʹ��p.next = null��֤������ĵ�һ���ڵ��ڷ�ת֮������next��ָ��null.
		
		first = pre; // ��� first = pre; ��������ԭ����ת�ˣ������ֻʣfirstһ���ڵ��ˡ�
		return pre;
	}
}
