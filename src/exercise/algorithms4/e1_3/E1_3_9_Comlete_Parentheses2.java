package exercise.algorithms4.e1_3;

import java.util.HashMap;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 参考: http://blog.csdn.net/wzy_1988/article/details/50532364
 * 自己改造了下这样对于1 + 2 + 3 )这样的情况也是能够处理的
 * @author lsp
 *
 */
public class E1_3_9_Comlete_Parentheses2 {
	
	public static void main(String[] args){
		Stack<String> optStack = new Stack<>();
		Stack<String> dataStack = new Stack<>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("+", 1);
		map.put("-", 1);
		map.put("*", 2);
		map.put("/", 2);
		
		// 1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
		// 1 + 2 + 3 ) * 5
		// 1 + 2 + 3 ) * 5 * 4 + 9 )
		while(!StdIn.isEmpty()){
			String item = StdIn.readString();
			switch(item){
			case "+":
			case "-":
			case "*":
			case "/":
				optStack.push(item);;
				break;
			case ")":
				String opt = optStack.pop();
				int priority = map.get(opt);
				String data2 = dataStack.pop();
				while(priority == map.get("+") && !optStack.isEmpty() && priority == map.get(optStack.peek())){
					data2 = dataStack.pop() + " " + opt + " " + data2;
					opt = optStack.pop();
					priority = map.get(opt);
				}
				String data1 = dataStack.pop();
				dataStack.push("( " + data1 + " " + opt + " " + data2 + " )");
				break;
			default:
				dataStack.push(item);
				break;
			}
		}
		while(!optStack.isEmpty()){
			String opt = optStack.pop();
			String data2 = dataStack.pop();
			String data1 = dataStack.pop();
			dataStack.push(data1 + " " + opt + " " + data2 );
		}
		Stack<String> outStack = new Stack<>();
		for(String item : dataStack) outStack.push(item);
		for(String item : outStack) StdOut.print(item);
	}
	
	
	
	
}
