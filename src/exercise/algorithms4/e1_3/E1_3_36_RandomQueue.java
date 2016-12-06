package exercise.algorithms4.e1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Ëæ»ú¶ÓÁÐ.
 * @author lsp
 *
 */
public class E1_3_36_RandomQueue {
	public static void main(String[] args) {
		RandomQueue<String> queue = new RandomQueue(3);
		// zbcd acd ef ha ag
		while (!StdIn.isEmpty()) {
			String value = StdIn.readString();
			queue.enqueue(value);
		}

		for(int i = 0; i < 3; i++){
			StdOut.print(queue.sample() + " ");
		}
		StdOut.println();
		for(int i = 0; i < 5; i++){
			StdOut.print(queue.dequeue() + " ");
		}
		StdOut.println();
		for(int i = 0; i < 3; i++){
			StdOut.print(queue.sample() + " ");
		}
		StdOut.println();
		for(String item : queue){
			StdOut.print(item + " ");
		}
	}
}
