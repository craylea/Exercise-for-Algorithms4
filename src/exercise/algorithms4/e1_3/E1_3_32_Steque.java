package exercise.algorithms4.e1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 删除链表指定节点之后的节点.
 * @author lsp
 *
 */
public class E1_3_32_Steque {

	public static void main(String[] args) {
		StequeByLinkedList<String> list = new StequeByLinkedList<>();
		// zbcd acd ef ha ag
		while (!StdIn.isEmpty()) {
			String value = StdIn.readString();
			list.push(value);
		}
		StdOut.println("\nsize: " + list.size());
		while (!list.isEmpty()) {
			StdOut.print(list.pop() + " ");
		}
		StdOut.println("\nsize: " + list.size());
		list.enqueue("a");
		list.enqueue("b");
		list.enqueue("c");
		StdOut.println("\nsize: " + list.size());
//		while (!list.isEmpty()) {
//			StdOut.print(list.pop() + " ");
//		}
		// E1_3_50
		for(String item : list){
			StdOut.print(item + " ");
			list.enqueue("d");
		}
		StdOut.println("\nsize: " + list.size());
	}
}
