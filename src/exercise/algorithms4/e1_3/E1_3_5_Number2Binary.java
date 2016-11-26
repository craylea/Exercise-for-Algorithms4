package exercise.algorithms4.e1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class E1_3_5_Number2Binary {

	public static void main(String[] args){
		int number = 52;
		StdOut.println(getBinaryFor(number));
	}
	
	private static String getBinaryFor(int number){
		String binary = "";
		
		Stack<Integer> stack = new Stack<>();
		while(number > 0){
			stack.push(number % 2);
			number = number / 2;
		}
		for(int item : stack) binary = binary + item;
		
		return binary;
	}
	
}
