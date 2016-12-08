package exercise.algorithms4.e1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 最近访问过的元素保持在最前
 * @author lsp
 *
 */
public class E1_3_40_MoveToFront {

	public static void main(String[] args) {
//		MoveToFront<String> mtf = new MoveToFront();
//		// zbcd acd ef ha ag acd ha cc
//		while (!StdIn.isEmpty()) {
//			String value = StdIn.readString();
//			mtf.add(value);
//		}
//		StdOut.println("End input.");
//		for(String key : mtf){
//			StdOut.print(key + " ");
//		}
		
		MoveToFront<Double> mtf = new MoveToFront();
		// 1 2 3 4 5 3 6 4 2 9 6 1
		while (!StdIn.isEmpty()) {
			Double value = StdIn.readDouble();
			mtf.add(value);
		}
		StdOut.println("End input.");
		for(Double key : mtf){
			StdOut.print(key + " ");
		}
	}
}
