package exercise.algorithms4;

/**
 * 最大公约数（greatest common divisor）缩写为gcd
 * @author lsp
 *
 */
public class E1_1_24_gcd {

	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		System.out.println(E_Util.gcd(a, b));
	}
}
