package exercise.algorithms4;

import edu.princeton.cs.algs4.StdOut;

/**
 * 二项分布
 * @author lsp
 *
 */
public class E1_1_27_binomial {

	public static int count = 0;
	
	public static void main(String[] args) {
		
		StdOut.println(binomial(10, 5, 1));
		StdOut.println(count);
	}

	public static double binomial(int N, int k, double p){
		count++;
		if(N == 0 && k == 0) return 1.0;
		if(N < 0 || k < 0) return 0;
		return (1.0 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
	}
}
