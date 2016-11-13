package exercise.algorithms4;

import edu.princeton.cs.algs4.StdOut;

/**
 * 整数转二进制
 * java自带的函数：{@link Integer#toBinaryString(int)}
 * @author lsp
 *
 */
public class E1_1_39 {

	public static void main(String[] args) {
		int n3 = 1000, n4 = 10000, n5 = 100000, n6 = 1000000;
		int T = Integer.parseInt(args[0]);
		int[] count3 = new int[T];
		int[] count4 = new int[T]; 
		int[] count5 = new int[T]; 
		int[] count6 = new int[T]; 
		int i = 0;
		while(T > i){
			int[] a = new int[n3];
			int[] b = new int[n3];
			E_Util.initIntArrayFixedLen(a, 6);
			E_Util.initIntArrayFixedLen(b, 6);
			count3[i] += rankForEqualNumber(a, b);
			a = new int[n4];
			b = new int[n4];
			E_Util.initIntArrayFixedLen(a, 6);
			E_Util.initIntArrayFixedLen(b, 6);
			count4[i] += rankForEqualNumber(a, b);
			a = new int[n5];
			b = new int[n5];
			E_Util.initIntArrayFixedLen(a, 6);
			E_Util.initIntArrayFixedLen(b, 6);
			count5[i] += rankForEqualNumber(a, b);
			a = new int[n6];
			b = new int[n6];
			E_Util.initIntArrayFixedLen(a, 6);
			E_Util.initIntArrayFixedLen(b, 6);
			count6[i] += rankForEqualNumber(a, b);
			i++;
		}
		StdOut.printf("%7s%7s%7s%7s\n", "n3", "n4", "n5", "n6");
		for(int j = 1; j < T; j++){
			count3[0] += count3[j];
			count4[0] += count4[j];
			count5[0] += count5[j];
			count6[0] += count6[j];
		}
		StdOut.printf("% 7d% 7d% 7d% 7d\n", count3[0], count4[0], count5[0], count6[0]);
		StdOut.printf("% 7.2f% 7.2f% 7.2f% 7.2f\n", count3[0] * 1.0 / 7, count4[0] * 1.0 / 7,
				count5[0] * 1.0 / 7, count6[0] * 1.0 / 7);
	}
	
	public static int rankForEqualNumber(int[] a, int[] b){
		int count = 0;
		for(int i = 0; i < a.length; i++){
			if(E_Util.rank(a[i], b) > 0) count++;
		}
		return count;
	}

}
