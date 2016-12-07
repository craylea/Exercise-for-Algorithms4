package exercise.algorithms4.e1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 
 * @author lsp
 *
 */
public class E1_3_38_ResizingArrayGeneralizedQueue {

	public static void main(String[] args) {
		ResizingArrayGeneralizedQueue<String> queue = new ResizingArrayGeneralizedQueue(3);
		// zbcd acd ef ha ag
		while (!StdIn.isEmpty()) {
			String value = StdIn.readString();
			queue.insert(value);
		}
		StdOut.print(queue.delete(3) + " ");
		while(!queue.isEmpty()){
			StdOut.print(queue.delete(1) + " ");
		}
	}
}
