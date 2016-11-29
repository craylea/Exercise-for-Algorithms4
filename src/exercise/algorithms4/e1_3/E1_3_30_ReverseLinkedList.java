package exercise.algorithms4.e1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 
 * @author lsp
 *
 */
public class E1_3_30_ReverseLinkedList {

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
		StdOut.println("\n----------Return by reverse------------");
		p = list.reverse(list.getFirstNode());
		while (p != null) {
			StdOut.print(p.value + " ");
			p = p.next;
		}
		StdOut.println("\n----------The linkedlist after reverse------------");
		p = list.getFirstNode();
		while (p != null) {
			StdOut.print(p.value + " ");
			p = p.next;
		}
		StdOut.println("\n----------Return by recursion reverse------------");
		p = list.reverseByRecursion(list.getFirstNode());
		while (p != null) {
			StdOut.print(p.value + " ");
			p = p.next;
		}
		StdOut.println("\n----------The linkedlist after recursion reverse------------");
		p = list.getFirstNode();
		while (p != null) {
			StdOut.print(p.value + " ");
			p = p.next;
		}
	}
}
