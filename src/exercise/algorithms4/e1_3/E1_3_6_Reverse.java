package exercise.algorithms4.e1_3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class E1_3_6_Reverse {

	public static void main(String[] args){
		Queue<Integer> queue = new Queue<>();
		Stack<Integer> stack = new Stack<>();
		// 1 2 3 4 5 6 
		while(!StdIn.isEmpty()){
			queue.enqueue(StdIn.readInt());
		}
		
		for(int item : queue) StdOut.print(item + " ");
		
		while(!queue.isEmpty())
			stack.push(queue.dequeue());
		
		while(!stack.isEmpty())
			queue.enqueue(stack.pop());
		
		StdOut.println();
		for(int item : queue) StdOut.print(item + " ");
	}
}
