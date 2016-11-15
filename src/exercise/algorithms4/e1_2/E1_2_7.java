package exercise.algorithms4.e1_2;

import edu.princeton.cs.algs4.StdOut;

/**
 * ·´×ª
 * @author lsp
 *
 */
public class E1_2_7 {

	public static void main(String[] args) {
		
		String str = args[0];
		StdOut.println(str + " -- " + mystery(str));
		
	}

	public static String mystery(String str){
		int N = str.length();
		if(N <= 1) return str;
		String a = str.substring(0, N / 2);
		String b = str.substring(N / 2);
		return mystery(b) + mystery(a);
	}

}
