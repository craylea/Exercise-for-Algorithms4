package exercise.algorithms4.e1_3;

import java.util.HashMap;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class E1_3_10_InfixToPostfix {

	public static void main(String[] args){
		Stack<String> vals = new Stack<>();
		Stack<String> ops = new Stack<>();
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("+", 1);
		map.put("-", 1);
		map.put("*", 2);
		map.put("/", 2);
		map.put("(", 0);
		//map.put(")", 3);
		
		// ( 1 + ( 2 + 3 ) * 4 - 5 )
		// ( 1 + ( ( 2 + 3 ) * 4 ) - 5 )
		// ( 1 + ( ( ( 2 + 3 ) * 4 ) - 5 ) )
		// 1 + ( 2 + 3 * 3 ) * 4 - 5 
		int oldPriority = -1;
		int priority  = -1;
		StdOut.println("start");
		while(!StdIn.isEmpty()){
			String s = StdIn.readString();
			
			if(s.equals("(")) 
				ops.push(s);
			else if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
				priority = map.get(s);
				if(!ops.isEmpty()){
					oldPriority = map.get(ops.peek());
				}
				while(!ops.isEmpty() && oldPriority >= priority){
					vals.push(ops.pop());
					if(!ops.isEmpty()){
						oldPriority = map.get(ops.peek());
					} 
				}
				ops.push(s);
			}
			else if(s.equals(")")){
				while(!ops.peek().equals("("))
					vals.push(ops.pop());
				ops.pop();
			}else
				vals.push(s);
		}
		for(String item : vals) ops.push(item);
		String result = "";
		for(String item : ops) result = result + " " + item;
			
		StdOut.print(result.trim());
	}
	
}
