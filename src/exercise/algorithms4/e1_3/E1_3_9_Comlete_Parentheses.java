package exercise.algorithms4.e1_3;

import java.util.HashMap;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 自创的,不尽如人意,请看{@link E1_3_9_Comlete_Parentheses2}
 * @author lsp
 *
 */
public class E1_3_9_Comlete_Parentheses {
	
	public static void main(String[] args){
		Queue<String> queue = new Queue<>();
		Stack<String> stackIn = new Stack<>();
		Stack<String> stackOut = new Stack<>();
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("+", 1);
		map.put("-", 1);
		map.put("*", 2);
		map.put("/", 2);
		
		// 1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
		while(!StdIn.isEmpty()){
			String item = StdIn.readString();
			if(item.equals(")")){
				stackOut.push(")");
				int oldPriority = 0;
				while(!stackIn.isEmpty()){
					String key = stackIn.pop();
					int priority = 0;
					switch(key){
					case "+":
					case "-":
					case "*":
					case "/":
						priority = map.get(key);
						break;
					case "(":
						oldPriority = 0;
						break;
					}
					if((oldPriority != 0 && oldPriority < priority) || stackIn.isEmpty()){
						if(stackIn.isEmpty()){
							stackIn.push("(");
							stackIn.push(key);
						}else{
							stackIn.push(key);
							stackIn.push("(");
						}
						while(!stackOut.isEmpty()){
							stackIn.push(stackOut.pop());
						}
						for(String item2 : stackIn) stackOut.push(item2); //StdOut.print(item2 + " "); //queue.enqueue(item2);
						StdOut.println();
						while(!stackOut.isEmpty()){
							StdOut.print(stackOut.pop() + " ");
						}
//						for(String item3 : queue) StdOut.print(item3 + " ");
						break;
					}
					if(oldPriority == 0){
						oldPriority = priority;
					}else{
//						if(oldPriority < priority || stackIn.isEmpty()){
//							if(stackIn.isEmpty()){
//								stackIn.push("(");
//								stackIn.push(key);
//							}else{
//								stackIn.push(key);
//								stackIn.push("(");
//							}
//							while(!stackOut.isEmpty()){
//								stackIn.push(stackOut.pop());
//							}
//							for(String item2 : stackIn) stackOut.push(item2); //StdOut.print(item2 + " "); //queue.enqueue(item2);
//							StdOut.println();
//							while(!stackOut.isEmpty()){
//								StdOut.print(stackOut.pop() + " ");
//							}
////							for(String item3 : queue) StdOut.print(item3 + " ");
//							break;
//						}
					}
					stackOut.push(key);
				}
			}else{
				stackIn.push(item);
			}
		}
		
		for(String item2 : stackIn) stackOut.push(item2); 
		StdOut.println();
		for(String item3 : stackOut) StdOut.print(item3 + " ");
		
//		StdOut.println();
//		for(String item : queue) StdOut.print(item + " ");
	}
	
	
	
	
}
