package exercise.algorithms4.e1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class DijkstraTowStackEvaluate {

	public static void main(String[] args){
		Stack<Double> vals = new Stack<>();
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
				String op = ops.pop();
				double v = vals.pop();
				if(op.equals("+"))
					v = vals.pop() + v;
				else if(op.equals("-"))
					v = vals.pop() - v;
				else if(op.equals("*"))
					v = vals.pop() * v;
				else if(op.equals("/"))
					v = vals.pop() / v;
				vals.push(v);
			}else
				vals.push(Double.parseDouble(s));
		}
		StdOut.println(vals.pop());
	}
	
}
