package exercise.algorithms4.e1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class E1_3_12 {

	public static void main(String[] args) {
		Stack<String> org = new Stack<>();
		while(!StdIn.isEmpty()){
			org.push(StdIn.readString());
		}
		String s = "";
		for(String item : org) s = item + " " + s;
		Stack<String> copy = copy(org);
		StdOut.println(s);
		s = "";
		for(String item : copy) s = item + " " + s;
		StdOut.println(s);
	}
	
	public static Stack<String> copy(Stack<String> org){
		Stack<String> copy = new Stack<>();
		Stack<String> temp = new Stack<>();
		
		for(String item : org) temp.push(item);
		for(String item : temp) copy.push(item);
		
		return copy;
	}

}
