package exercise.algorithms4.e1_2;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author lsp
 *
 */
public class E1_2_16 {

	public static void main(String[] args) {
		Rational rational = new Rational(Integer.MAX_VALUE, 5);
		StdOut.println(rational);
		Rational rational2 = new Rational(6, 10);
		StdOut.println(rational + " is equal to " + rational2 + "? " + rational.equals(rational2));
		Rational rational3 = rational.plus(rational2);
		StdOut.println(rational3);
//		rational3 = rational.minus(rational2);
//		StdOut.println(rational3);
		rational3 = rational.times(rational2);
		StdOut.println(rational3);
		rational3 = rational.devides(rational2);
		StdOut.println(rational3);
	}


}
