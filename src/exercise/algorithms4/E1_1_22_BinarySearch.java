package exercise.algorithms4;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;

/**
 * ¶þ·Ö²éÕÒ
 * @author lsp
 *
 */
public class E1_1_22_BinarySearch {

	public static void main(String[] args) {
		int[] a = new int[10];
		E_Util.initIntArray(a, 10);
		Arrays.sort(a);
		for(int i = 0; i < a.length; i++){
			StdOut.println(i + ": " + a[i]);
		}
		int key = 5;
		StdOut.println(E_Util.rank(key, a));
		StdOut.println(rankWithPrint(key, a));
	}
	
	public static int rankWithPrint(int key, int[] a, int lo, int hi, int height){
		for(int i = 0; i < height; i++)
			StdOut.print(" ");
		StdOut.println(lo + " " + hi);
		if(lo > hi) return -1;
		int mid = lo + (hi - lo) / 2 ;
		if( key < a[mid]) 
			return rankWithPrint(key, a, lo, mid - 1, height + 1);
		else if(key > a[mid]) 
			return rankWithPrint(key, a, mid + 1, hi, height + 1);
		else 
			return mid;
	}
	
	public static int rankWithPrint(int key, int[] a) {
		return rankWithPrint(key, a, 0, a.length - 1, 0);
	}
}
