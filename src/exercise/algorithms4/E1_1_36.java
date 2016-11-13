package exercise.algorithms4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 乱序检查
 * @author lsp
 *
 */
public class E1_1_36 {

	private static final String FORMAT = "%5s";
	
	public static void main(String[] args) {
		int M = Integer.parseInt(args[0]);
		int N = Integer.parseInt(args[1]);
		
		int[][] b = new int[M][M];
		int[] a = new int[M];
		double[] d = new double[M]; 
		for(int i = 1; i <= N; i++){
			// 方法一
			init(a);
			shuffle(a);
			count(a, b);
			// 方法二
//			initDouble(d);
//			shuffle(d, b);
			// 方法三
//			initDouble(d);
//			double[] c = new double[d.length];
//			for(int j = 0; j < d.length; j++){
//				c[j] = d[j];
//			}
//			shuffle(c);
//			count(d, c, b);
		}
		StdOut.printf(FORMAT, " ");
		for(int i = 0; i < b.length; i++){
			StdOut.printf(FORMAT, i);
		}
		StdOut.println();
		for(int i = 0; i < b.length; i++){
			StdOut.printf(FORMAT, i);
			for(int j = 0; j < b[i].length; j++){
				StdOut.printf(FORMAT, b[i][j]);
			}
			StdOut.println();
		}
		
	}
	
	public static void init(int[] a){
		for(int i = 0; i < a.length; i++){
			a[i] = i;
		}
	}
	public static void initDouble(double[] a){
		for(int i = 0; i < a.length; i++){
			a[i] = i;
		}
	}

	// 方法一
	public static void shuffle(int[] a){
		int N = a.length;
		for(int i = 0; i < N; i++){
			// 将a[i]和a[i..N-1]中任意一个交换
			int r = StdRandom.uniform(N); //i + StdRandom.uniform(N - i);
			int temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}
	/**
	 * 计算i落到j的次数，这种方式只能计算整型a[i] = i的模式
	 * @param a
	 * @param b
	 */
	public static void count(int[] a, int[][] b){
		for(int i = 0; i < a.length; i++){
			b[i][a[i]] += 1;
		}
	}
	
	// 方法二
	public static void shuffle(double[] a, int[][] b){
		int len = a.length;
		double[] c = new double[len];
		for(int i = 0; i < len; i++){
			c[i] = a[i];
		}
		for(int i = 0; i < len; i++){
			// 将a[i]和a[i..len-1]中任意一个交换
			int r = i + StdRandom.uniform(len - i);
			double temp = c[i];
			c[i] = c[r];
			c[r] = temp;
			// 这样不行，因为i换到j，后续的循环可能又把j换到i了，这样实际是没有交换。
			// 如果直接在此循环内对b操作，那么则把没有交换的也进行计数了，即[i][j]和[j][i]分别都加了1。
			// b[i][j] += 1; 
		}
		// 所以只能在完成上面的循环后，与初始数组比较来得到i被移动到的j。
		for(int i = 0; i < len; i++){
			for(int j = 0; j < len; j++){
				if(a[i] == c[j]) b[i][j] += 1;
			}
		}
		
	}
	
	// 方法三 把方法二拆分
	public static void shuffle(double[] a){
		int N = a.length;
		for(int i = 0; i < N; i++){
			// 将a[i]和a[i..N-1]中任意一个交换
			int r = StdRandom.uniform(N); //i + StdRandom.uniform(N - i);
			double temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}
	public static void count(double[] a, double[] c, int[][] b){
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < c.length; j++){
				if(a[i] == c[j]) b[i][j] += 1;
			}
		}
	}
	
}
