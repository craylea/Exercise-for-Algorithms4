package exercise.algorithms4.e1_3;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class E1_3_16_ReadDates {

	// /dateStr.txt
	public static void main(String[] args) {
		String dateStr = args[0];
		Date[] dates = readDates(dateStr);
		for (int i = 0; i < dates.length; i++) {
			StdOut.print(dates[i] + " ");
		}
	}

	public static Date[] readDates(String dateStr) {
		In in = new In(dateStr);
		Queue<String> queue = new Queue<>();
		while (!in.isEmpty()) {
			queue.enqueue(in.readString());
		}
		Date[] dates = new Date[queue.size()];
		int i = 0;
		for (String item : queue) {
			dates[i++] = new Date(item);
		}
		return dates;
	}
}
