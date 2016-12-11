package exercise.algorithms4.e1_3;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 一个双向队列实现两个栈
 * @author lsp
 *
 */
public class E1_3_48_TwoStackWithOneDeque {

	public static void main(String[] args) {
		TwoStackWithOneDeque<String> stack = new TwoStackWithOneDeque();
		// zbcd acd ef ha ag
		while (!StdIn.isEmpty()) {
			String value = StdIn.readString();
			stack.pushLeft(value);
		}
		String[] strings = "a b c d".split(" ");
		for(String item : strings){
			stack.pushRight(item);
		}
		Iterator<String> iteratorLeft = stack.iteratorLeft();
		while(iteratorLeft.hasNext()){
			StdOut.print(iteratorLeft.next() + " ");
		}
		StdOut.println();
		Iterator<String> iteratorRight = stack.iteratorRight();
		while(iteratorRight.hasNext()){
			StdOut.print(iteratorRight.next() + " ");
		}
		StdOut.println();
		for(String item : stack){
			StdOut.print(item + " ");
		}
	}
}
