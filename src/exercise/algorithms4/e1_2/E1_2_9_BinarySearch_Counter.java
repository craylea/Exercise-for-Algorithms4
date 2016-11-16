package exercise.algorithms4.e1_2;

import java.util.Arrays;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdOut;
import exercise.algorithms4.E_Util;

/**
 * ¶þ·Ö²éÕÒ
 * @author lsp
 *
 */
public class E1_2_9_BinarySearch_Counter {

	public static void main(String[] args) {
		int[] a = new int[10];
		E_Util.initIntArray(a, 10);
		Arrays.sort(a);
		for(int i = 0; i < a.length; i++){
			StdOut.println(i + ": " + a[i]);
		}
		int key = 5;
		Counter counter = new Counter("BS");
		if(rankWithPrint(key, a, counter) > 0 ){
			StdOut.println(key + " through " + counter.toString() + " times check.");
		}else{
			StdOut.println(key + " through " + counter.toString() + " times check" + ", but can't be found.");
		}
	}
	
	public static int rankWithPrint(int key, int[] a, int lo, int hi, int height, Counter counter){
		for(int i = 0; i < height; i++)
			StdOut.print(" ");
		StdOut.println(lo + " " + hi);
		if(lo > hi) return -1;
		counter.increment();
		int mid = lo + (hi - lo) / 2 ;
		if( key < a[mid]) 
			return rankWithPrint(key, a, lo, mid - 1, height + 1, counter);
		else if(key > a[mid]) 
			return rankWithPrint(key, a, mid + 1, hi, height + 1, counter);
		else 
			return mid;
	}
	
	public static int rankWithPrint(int key, int[] a, Counter counter) {
		return rankWithPrint(key, a, 0, a.length - 1, 0, counter);
	}
}
