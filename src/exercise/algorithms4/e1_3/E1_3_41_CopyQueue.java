package exercise.algorithms4.e1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * øΩ±¥∂”¡–.
 * @author lsp
 *
 */
public class E1_3_41_CopyQueue {

	public static void main(String[] args) throws Exception {
		FixedCapacityQueue<String> queue = new FixedCapacityQueue<>(5);
		// zbcd acd ef ha ag
		while (!StdIn.isEmpty()) {
			String value = StdIn.readString();
			queue.enqueue(value);
		}
		
		FixedCapacityQueue<String> queue2 = new FixedCapacityQueue<>(queue);
		StdOut.println("queue2 dequeue: " + queue2.dequeue());
		queue2.enqueue("ha");
		StdOut.println("queue dequeue: " + queue.dequeue());
		StdOut.println("queue dequeue: " + queue.dequeue());
		queue.enqueue("ag");
		StdOut.print("queue: ");
		for(String item : queue){
			StdOut.print(item + " ");
		}
		StdOut.println();
		StdOut.print("queue2: ");
		for(String item : queue2){
			StdOut.print(item + " ");
		}
	}
}
