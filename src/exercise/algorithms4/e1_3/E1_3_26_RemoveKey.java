package exercise.algorithms4.e1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 删除链表指定节点之后的节点.
 * @author lsp
 *
 */
public class E1_3_26_RemoveKey {

	public static void main(String[] args) {
		String key = args[0];
		
		LinkedList list = new LinkedList();
		Node<String> p = null;
		// a a b c e d a e f g a
		// a a a a a
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
		StdOut.println(LinkedList.remove(list, key));
		p = list.getFirstNode();
		while (p != null) {
			StdOut.print(p.value + " ");
			p = p.next;
		}
	}
}
