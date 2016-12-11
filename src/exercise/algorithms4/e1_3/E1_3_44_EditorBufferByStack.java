package exercise.algorithms4.e1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 
 * @author lsp
 *
 */
public class E1_3_44_EditorBufferByStack {

	public static void main(String[] args) {
		EditorBufferByStack buffer = new EditorBufferByStack();
		// a a b c
		while (!StdIn.isEmpty()) {
			char value = StdIn.readChar();
			buffer.insert(value);
		}
		StdOut.println("move left " + buffer.left(4));
		StdOut.println("delete " + buffer.delete());
		for(char c : buffer){
			StdOut.print(c);
		}
		StdOut.println();
		buffer.end();
		buffer.insert('e');
		buffer.insert('f');
		buffer.insert('g');
		// 迭代输出光标之后的字符
//		buffer.home();
		for(char c : buffer){
			StdOut.print(c);
		}
		
	}
}
