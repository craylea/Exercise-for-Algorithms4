package exercise.algorithms4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 
 * @author lsp
 *
 */
public class E1_1_15 {

	public static void main(String[] args) {
		int n = 100;
		int[] a = new int[100];
		initIntArray(a, n);
		for(int i = 0; i < a.length; i++){
			StdOut.print(a[i] + " ");
			if((i + 1) % 10 == 0) 
				StdOut.println();
		}
		StdOut.println();
		int[] b = hisToGram(a, n / 2);
		int count = 0;
		for(int i = 0; i < b.length; i++){
			if(b[i] != 0){
				StdOut.println(i + ": " + b[i]);
				count += b[i];
			}
		}
		StdOut.println();
		StdOut.println(count);
	}
	
	/**
	 * 初始化
	 * @param a
	 * @param n
	 */
	public static void initIntArray(int[] a, int n){
		for(int i = 0; i < a.length; i++){
			a[i] = StdRandom.uniform(n);
		}
	}
	
	/**
	 * 计算0到M-1的整数在数组a中各出现的次数
	 * @param a
	 * @param M
	 * @return
	 */
	public static int[] hisToGram(int[] a, int M){
		int[] b = new int[M];
		
//		for(int i = 0; i < M; i++){
//			b[i] = 0;
//		}
		
		for(int i = 0; i < a.length; i++){
			if(a[i] >=0 && a[i] < M){
				b[a[i]] += 1; 
			}
		}
		
		return b;
	}

}
