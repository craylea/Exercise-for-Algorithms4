package exercise.algorithms4.e1_3;

import edu.princeton.cs.algs4.StdOut;

/**
 * Josephus
 * @author lsp
 *
 */
public class E1_3_37_Josephus {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int m = Integer.parseInt(args[1]);
		
		ResizingArrayDeque<Integer> numbers = new ResizingArrayDeque<>(n);
		for(int i = 0; i < n; i++){
			numbers.pushRight(i);
		}

		int i = 1;
		while(!numbers.isEmpty()){
			if( i < m){
				numbers.pushRight(numbers.popLeft());
			}else{
				StdOut.print(numbers.popLeft() + " ");
				i = 0;
			}
			i++;
		}
	}
}
