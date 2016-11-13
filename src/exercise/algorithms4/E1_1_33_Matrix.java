package exercise.algorithms4;

import edu.princeton.cs.algs4.StdOut;

/**
 * ¾ØÕó²Ù×÷
 * @author lsp
 *
 */
public class E1_1_33_Matrix {

	public static void main(String[] args) {
		double[] x = {1.0, 2.0, 3.0};
		double[] y = {
				1.0,
				2.0,
				3.0 };
		double[][] a = {{1.0, 2.0, 3.0}, {1.0, 2.0, 3.0}, {1.0, 2.0, 3.0} };
		double[][] b = {{1.0, 2.0, 3.0}, {1.0, 2.0, 3.0}, {1.0, 2.0, 3.0} };
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < a[0].length; j++){
				StdOut.print(a[i][j] + "  ");
			}
			StdOut.println();
		}
		StdOut.println("-------------------------");
		double dot = E_Util.dot(x, y);
		StdOut.println(dot);
		StdOut.println("-------------------------");
		double[][] transpose = E_Util.transpose(a);
		for(int i = 0; i < transpose.length; i++){
			for(int j = 0; j < transpose[0].length; j++){
				StdOut.print(transpose[i][j] + "  ");
			}
			StdOut.println();
		}
		StdOut.println("-------------------------");
		double[][] matrixMult = E_Util.mult(a, b);
		for(int i = 0; i < matrixMult.length; i++){
			for(int j = 0; j < matrixMult[0].length; j++){
				StdOut.print(matrixMult[i][j] + "  ");
			}
			StdOut.println();
		}
		StdOut.println("-------------------------");
		double[] mult = E_Util.mult(a, x);
		for(int j = 0; j < mult.length; j++){
			StdOut.print(mult[j] + "  ");
		}
		StdOut.println();
		StdOut.println("-------------------------");
		mult = E_Util.mult(y, b);
		for(int j = 0; j < mult.length; j++){
			StdOut.print(mult[j] + "  ");
		}
	}
	
	

}
