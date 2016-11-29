package exercise.algorithms4.e1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 在链表指定节点之后插入节点.
 * @author lsp
 *
 */
public class E1_3_25_InsertAfter {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		Node<String> p = null;
		Node<String> after = null;
		int i = 0;
		// hello 你好 嘿嘿 byebye
		while (!StdIn.isEmpty()) {
			String value = StdIn.readString();
			// 删除第4个之后的节点
			if(i == 3) after = list.add(value);
			else list.add(value);
			i++;
		}
		Node<String> temp = new Node<>();
		temp.value = "insertAfter";
		list.insertAfter(after, temp);
		p = list.getFirstNode();
		while (p != null) {
			StdOut.print(p.value + " ");
			p = p.next;
		}
		StdOut.println();
	}
}
