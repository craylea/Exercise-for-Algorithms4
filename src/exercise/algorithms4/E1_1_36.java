package exercise.algorithms4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * ������
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
			// ����һ
			init(a);
			shuffle(a);
			count(a, b);
			// ������
//			initDouble(d);
//			shuffle(d, b);
			// ������
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

	// ����һ
	public static void shuffle(int[] a){
		int N = a.length;
		for(int i = 0; i < N; i++){
			// ��a[i]��a[i..N-1]������һ������
			int r = StdRandom.uniform(N); //i + StdRandom.uniform(N - i);
			int temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}
	/**
	 * ����i�䵽j�Ĵ��������ַ�ʽֻ�ܼ�������a[i] = i��ģʽ
	 * @param a
	 * @param b
	 */
	public static void count(int[] a, int[][] b){
		for(int i = 0; i < a.length; i++){
			b[i][a[i]] += 1;
		}
	}
	
	// ������
	public static void shuffle(double[] a, int[][] b){
		int len = a.length;
		double[] c = new double[len];
		for(int i = 0; i < len; i++){
			c[i] = a[i];
		}
		for(int i = 0; i < len; i++){
			// ��a[i]��a[i..len-1]������һ������
			int r = i + StdRandom.uniform(len - i);
			double temp = c[i];
			c[i] = c[r];
			c[r] = temp;
			// �������У���Ϊi����j��������ѭ�������ְ�j����i�ˣ�����ʵ����û�н�����
			// ���ֱ���ڴ�ѭ���ڶ�b��������ô���û�н�����Ҳ���м����ˣ���[i][j]��[j][i]�ֱ𶼼���1��
			// b[i][j] += 1; 
		}
		// ����ֻ������������ѭ�������ʼ����Ƚ����õ�i���ƶ�����j��
		for(int i = 0; i < len; i++){
			for(int j = 0; j < len; j++){
				if(a[i] == c[j]) b[i][j] += 1;
			}
		}
		
	}
	
	// ������ �ѷ��������
	public static void shuffle(double[] a){
		int N = a.length;
		for(int i = 0; i < N; i++){
			// ��a[i]��a[i..N-1]������һ������
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
