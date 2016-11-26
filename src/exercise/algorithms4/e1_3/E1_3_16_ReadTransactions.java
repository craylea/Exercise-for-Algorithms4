package exercise.algorithms4.e1_3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import exercise.algorithms4.e1_2.Transaction;

public class E1_3_16_ReadTransactions {

	// /transactionStr.txt
	public static void main(String[] args) {
		String dateStr = args[0];
		Transaction[] dates = readTransactions(dateStr);
		for (int i = 0; i < dates.length; i++) {
			StdOut.println(dates[i]);
		}
	}

	public static Transaction[] readTransactions(String transactionStr) {
		In in = new In(transactionStr);
		Queue<String> queue = new Queue<>();
		while (!in.isEmpty()) {
			queue.enqueue(in.readString());
		}
		Transaction[] transactionss = new Transaction[queue.size()];
		int i = 0;
		for (String item : queue) {
			transactionss[i++] = new Transaction(item);
		}
		return transactionss;
	}
}
