package exercise.algorithms4.e1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * ≤È’“¡¥±Ì
 * @author lsp
 *
 */
public class E1_3_21_Find {

	public static void main(String[] args) {
		String key = args[0];

		LinkedList list = new LinkedList();

		Node<String> p = null;
		// hello ƒ„∫√ ∫Ÿ∫Ÿ byebye
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
		StdOut.println(list.find(key));
	}
}
