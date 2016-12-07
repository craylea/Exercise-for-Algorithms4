package exercise.algorithms4.e1_3;

/**
 * 单向链表
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
	 * 往链表中添加节点
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
	 * 删除链表中第k节点
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
			// 找到第k-1个元素
			while (i < k - 1 && p != null) {
				pre = p;
				p = p.next;
				i++;
			}

			if (i == k - 1 && p != null) {
				// 把第k-1个元素的next指向第k个元素的next
				// 千万不能使用把第k个元素=第k个元素的next：
				// p = p.next，这样并没有把first链表的第k个元素删掉，仅仅是改变了变量p的指向。
				// 也就是说，我们不能改引用本身，而是要改引用指向的内容的值。
				pre.next = p.next;
			} else {
				// 第k个元素不存在
				return -1;
			}
		}

		return k;
	}

	/**
	 * 删除最后一个节点
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
	 * 查找链表是否存在值为key的节点
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
	 * 删除指定节点item之后的节点
	 * 
	 * @param item
	 */
	public void removeAfter(Node<String> item) {
		if (item != null && item.next != null) {
			item.next = null;
		}
	}

	/**
	 * 在 node1之后插入node2
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
	 * 删除链表中所有值为key的节点
	 * 
	 * @param list
	 * @param key
	 * @return
	 */
	public static int remove(LinkedList list, String key) {
		int count = 0;
		if (list != null && key != null) {
			Node<String> p = list.getFirstNode();
			// 处理第1个节点
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
	 * 获取链表中值最大的节点的值
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
	 * 递归获取链表中值最大的节点的值
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
	 * 反转链表
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
		first = pre; // 添加 first = pre; 这样就是原链表反转了，否则就只剩first一个节点了。
		return pre;
	}
	/**
	 * 递归方法 反转链表
	 * 与直接反转相比较，直接反转的过程是从链表的第一个节点开始反转，-><- -><- -><-
	 * 而递归方法反转的过程则是一直递归到链表的最后一个节点，然后往回一步一步反转。 
	 * -> -> -> 
	 * <- <- <-
	 * @param node
	 * @return
	 */
	public Node<String> reverseByRecursion(Node<String> node){
		if(node == null) return null; // 链表的第一个节点就是null
		if(node.next == null) return node;
		
		Node<String> p = node;
		Node<String> next = p.next;
		Node<String> pre = reverseByRecursion(next);
		next.next = p;
		p.next = null; // p实际就是上一递归的next, 这里使用p.next = null保证了链表的第一个节点在反转之后，它的next将指向null.
		
		first = pre; // 添加 first = pre; 这样就是原链表反转了，否则就只剩first一个节点了。
		return pre;
	}
}
