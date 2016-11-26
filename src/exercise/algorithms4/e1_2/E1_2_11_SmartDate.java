package exercise.algorithms4.e1_2;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author lsp
 *
 */
public class E1_2_11_SmartDate {

	public static void main(String[] args) throws Exception {
		
		SmartDate smartDate = new SmartDate(2016, 11, 13);
		StdOut.println(smartDate + " is the " + smartDate.dayOfTeWeek() + " day of the week.");
	}

	

}
