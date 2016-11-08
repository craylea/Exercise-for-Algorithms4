package exercise.algorithms4;

import java.text.Format;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author lsp
 *
 */
public class E1_1_11 {

	public static final String FORMAT = "%3s";

	public static void main(String[] args) {
		boolean[][] bs = new boolean[100][100];
//		for (int i = 0; i < 2; i++)
//			for (int j = 0; j < 2; j++)
//				if (i == j)
//					bs[i][j] = true;
//				else
//					bs[i][j] = false;
		RandomInitial(bs);
		
		System.out.printf(FORMAT, " ");
		for (int i = 0; i < bs.length; i++)
			System.out.printf(FORMAT, i);
		System.out.println();
		for (int i = 0; i < bs.length; i++) {
			System.out.printf(FORMAT, i);
			for (int j = 0; j < bs.length; j++)
				if (bs[i][j])
					System.out.printf(FORMAT, "*");
				else
					System.out.printf(FORMAT, " ");
			System.out.println();
		}
		
		System.out.println();
		
		boolean[][] a = new boolean[100][100];
		a = RandomInitial(a);// 随机初始化  �?
		TestPrint(a);// 打印数组

	}

	public static void TestPrint(boolean[][] a) {
		StdOut.printf(FORMAT, " ");
		for (int i = 0; i < a.length; i++)
			StdOut.printf(FORMAT, i);
		
		StdOut.println();
		for (int i = 0; i < a.length; i++) {
			StdOut.printf(FORMAT, i);
			for (int j = 0; j < a.length; j++) {
				if (a[i][j])
					StdOut.printf(FORMAT, "*");
				else
					StdOut.printf(FORMAT, " ");
			}
			StdOut.println();
		}
	}

	public static boolean[][] RandomInitial(boolean[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (StdRandom.bernoulli(0.1))
					a[i][j] = true;
				else
					a[i][j] = false;
			}
		}
		return a;
	}
}
