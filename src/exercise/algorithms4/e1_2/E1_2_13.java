package exercise.algorithms4.e1_2;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author lsp
 *
 */
public class E1_2_13 {

	public static void main(String[] args) {
		Transaction transaction = new Transaction("LiDingbang;11/20/2016;100");
		StdOut.println(transaction);
		StdOut.println(transaction.who() + ";" + transaction.when() + ";" + transaction.amount());
		Transaction transaction2 = new Transaction("LiDingbang;11/20/2016;1000");
		StdOut.println("transaction and transaction2 is equal? " + transaction.equals(transaction2));
		StdOut.println("transaction is greater than transaction2? " + transaction.compareTo(transaction2));
	}

}
