package exercise.algorithms4.e1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class E1_3_14_ResizingArrayQueueString {

	public static void main(String[] args) throws Exception {
		ResizingArrayQueueOfString queue = new ResizingArrayQueueOfString(10);
		// 1 2 3 4 5 6
		while(!StdIn.isEmpty()){
			queue.enqueue(StdIn.readString());
		}
		while(!queue.isEmpty())
			StdOut.print(queue.dequeue() + " ");
	}

}
