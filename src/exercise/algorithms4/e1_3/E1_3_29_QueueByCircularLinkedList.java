package exercise.algorithms4.e1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class E1_3_29_QueueByCircularLinkedList {

	public static void main(String[] args){
		QueueByCircularLinkedList queue = new QueueByCircularLinkedList();
		while(!StdIn.isEmpty()){
			queue.enqueue(StdIn.readString());
		}
		while(!queue.isEmpty()){
			StdOut.print(queue.dequeue() + " ");
		}
		
		queue.enqueue("123");
		StdOut.println();
		while(!queue.isEmpty()){
			StdOut.print(queue.dequeue() + " ");
		}
	}
}
