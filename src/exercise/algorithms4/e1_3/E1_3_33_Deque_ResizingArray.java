package exercise.algorithms4.e1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 可变数组实现双向队列
 * @author lsp
 *
 */
public class E1_3_33_Deque_ResizingArray {

	public static void main(String[] args) {
		ResizingArrayDeque<String> queue = new ResizingArrayDeque<>(3);
		// zbcd acd ef ha ag
		while (!StdIn.isEmpty()) {
			queue.pushLeft(StdIn.readString());
		}
		StdOut.println("---------after pushLeft---------");
		for(String item : queue){
			StdOut.print(item + " ");
		}
		queue.pushRight("zbcd");
		queue.pushRight("acd");
		queue.pushRight("ef");
		queue.pushRight("ha");
		queue.pushRight("ag");
		StdOut.println("\n---------after pushRight---------");
		for(String item : queue){
			StdOut.print(item + " ");
		}
		StdOut.println("\n---------popLeft---------" + queue.popLeft());
		StdOut.println("\n---------popLeft---------" + queue.popLeft());
		StdOut.println("\n---------popLeft---------" + queue.popLeft());
		StdOut.println("\n---------popLeft---------" + queue.popLeft());
		StdOut.println("\n---------popLeft---------" + queue.popLeft());
		StdOut.println("\n---------after popLeft---------");
		for(String item : queue){
			StdOut.print(item + " ");
		}
		StdOut.println("\n---------popRight---------" + queue.popRight());
		StdOut.println("\n---------popRight---------" + queue.popRight());
		StdOut.println("\n---------popRight---------" + queue.popRight());
		StdOut.println("\n---------popRight---------" + queue.popRight());
		StdOut.println("\n---------popRight---------" + queue.popRight());
		StdOut.println("\n---------after popRight---------");
		for(String item : queue){
			StdOut.print(item + " ");
		}
	}
}
