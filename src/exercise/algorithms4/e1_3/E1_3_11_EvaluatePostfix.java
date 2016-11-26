package exercise.algorithms4.e1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class E1_3_11_EvaluatePostfix {

	public static void main(String[] args) {
		Stack<Double> vals = new Stack<>();
		
		// 1 2 3 + 4 * + 5 -
		// 1 2 3 3 * + 4 * + 5 -
		StdOut.println("start");
		if(args.length > 0)
			StdOut.println(args[0]);
		while(!StdIn.isEmpty()){
			String s = StdIn.readString();
			if(s.equals("+")){
				double v = vals.pop();
				v = vals.pop() + v;
				vals.push(v);
			}else if(s.equals("-")){
				double v = vals.pop();
				v = vals.pop() - v;
				vals.push(v);
			}
			else if(s.equals("*")){
				double v = vals.pop();
				v = vals.pop() * v;
				vals.push(v);
			}
			else if(s.equals("/")){
				double v = vals.pop();
				v = vals.pop() / v;
				vals.push(v);
			}else
				vals.push(Double.parseDouble(s));
		}
		for(double v : vals) StdOut.println(v);
	}

}
