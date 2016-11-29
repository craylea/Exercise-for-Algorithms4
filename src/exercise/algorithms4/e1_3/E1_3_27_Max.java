package exercise.algorithms4.e1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 删除链表指定节点之后的节点.
 * @author lsp
 *
 */
public class E1_3_27_Max {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		Node<String> p = null;
		// a a b c e d a e f g a
		// zbcd acd ef ha ag
		while (!StdIn.isEmpty()) {
			String value = StdIn.readString();
			list.add(value);
		}
		p = list.getFirstNode();
		while (p != null) {
			StdOut.print(p.value + " ");
			p = p.next;
		}
		StdOut.println();
		// 1.3.27
		StdOut.println(LinkedList.max(list));
		// 1.3.28
		StdOut.println(list.maxByRecursion(list.getFirstNode()));
		p = list.getFirstNode();
		while (p != null) {
			StdOut.print(p.value + " ");
			p = p.next;
		}
	}
}
