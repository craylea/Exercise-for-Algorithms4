package exercise.algorithms4.e1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author lsp
 *
 */
public class E1_3_4_Parentheses {

	public static void main(String[] args) {
		Stack<Character> stack = new Stack<>();
		boolean isMatch = true;
		// [()]{}{[()()]()}
		// [()]{}{[()()]()
		// [()]{}{
		// [()]{}{[())()
		while (!StdIn.isEmpty()) {
			char c = StdIn.readChar();
			StdOut.print(c);
			char newC;
			switch (c) {
			case '{':
				stack.push(c);
				break;
			case '}':
				newC = stack.pop();
				if(newC != '{') isMatch = false;
				break;
			case '[':
				stack.push(c);
				break;
			case ']':
				newC = stack.pop();
				if(newC != '[') isMatch = false;
				break;
			case '(':
				stack.push(c);
				break;
			case ')':
				newC = stack.pop();
				if(newC != '(') isMatch = false;
				break;

			}
			if(!isMatch) break;
		}
		StdOut.println();
		if(isMatch && stack.isEmpty()) StdOut.println("The input parentheses are matched!");
		else StdOut.println("The input parentheses are not matched!");
	}
}
