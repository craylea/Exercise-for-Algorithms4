package exercise.algorithms4.e1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class E1_3_10_InfixToPostfix2 {

	public static void main(String[] args){
		Stack<String> vals = new Stack<>();
		Stack<String> ops = new Stack<>();
		// ( 1 + ( 2 + 3 ) * 4 - 5 )
		// ( 1 + ( ( 2 + 3 ) * 4 ) - 5 )
		// ( 1 + ( ( ( 2 + 3 ) * 4 ) - 5 ) )
		while(!StdIn.isEmpty()){
			String s = StdIn.readString();
			
			if(s.equals("(")) 
				;
			else if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) 
				ops.push(s);
			else if(s.equals(")")){
				vals.push(ops.pop());
			}else
				vals.push(s);
		}
		for(String item : vals) ops.push(item);
		for(String item : ops) StdOut.print(item);
	}
	
}
