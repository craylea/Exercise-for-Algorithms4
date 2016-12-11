package exercise.algorithms4.e1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 三个栈实现一个队列
 * 实在不知道如何实现常数次栈操作。。。
 * @author lsp
 *
 */
public class E1_3_49_QueueWith3Stack {

	public static void main(String[] args) {
		QueueWith3Stack<String> queue = new QueueWith3Stack();
		// zbcd acd ef ha ag
		while (!StdIn.isEmpty()) {
			String value = StdIn.readString();
			queue.enqueue(value);
		}
		StdOut.println();
		for(String item : queue){
			StdOut.print(item + " ");
		}
	}
}
