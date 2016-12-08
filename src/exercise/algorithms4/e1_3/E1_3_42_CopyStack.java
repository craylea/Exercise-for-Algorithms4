package exercise.algorithms4.e1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * øΩ±¥∂”¡–.
 * @author lsp
 *
 */
public class E1_3_42_CopyStack {

	public static void main(String[] args) throws Exception {
		StequeByLinkedList<String> stack = new StequeByLinkedList<>();
		// zbcd acd ef ha ag
		while (!StdIn.isEmpty()) {
			String value = StdIn.readString();
			stack.push(value);
		}
		
		StequeByLinkedList<String> stack2 = new StequeByLinkedList<>(stack);
		StdOut.println("stack2 pop: " + stack2.pop());
		StdOut.println("stack2 push: ha");
		stack2.push("ha");
		StdOut.println("stack pop: " + stack.pop());
		StdOut.println("stack pop: " + stack.pop());
		StdOut.println("stack push: ag");
		stack.push("ag");
		StdOut.print("stack: ");
		for(String item : stack){
			StdOut.print(item + " ");
		}
		StdOut.println();
		StdOut.print("stack2: ");
		for(String item : stack2){
			StdOut.print(item + " ");
		}
	}
}
