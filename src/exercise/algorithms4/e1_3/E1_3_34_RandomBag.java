package exercise.algorithms4.e1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Ëæ»ú±³°ü
 * @author lsp
 *
 */
public class E1_3_34_RandomBag {

	public static void main(String[] args) {
		RandomBag<String> bag = new RandomBag(3);
		// zbcd acd ef ha ag
		while (!StdIn.isEmpty()) {
			String value = StdIn.readString();
			bag.add(value);
		}
		for(int i = 0; i < 5; i++){
			for(String item : bag){
				StdOut.print(item + " ");
			}
			StdOut.println();
		}
	}
}
