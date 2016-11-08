package exercise.algorithms4;

/**
 * 求阶乘的对数�?
 * @author lsp
 *
 */
public class E1_1_20_factorialln {

	public static void main(String[] args) {
		System.out.println(Math.log(factorial(100)));
		System.out.println(factorialln(100));
	}

	/**
	 * 直接计算阶层
	 * @param N
	 * @return
	 */
	public static double factorial(int N){
		double f = 1;
		for(int i = 1; i <= N; i++){
			f *= i;
		}
		return f;
	}
	/**
	 * 运用对数公式，作加法，�?�归计算阶层的�??
	 * @param N
	 * @return
	 */
	public static double factorialln(long N){
		if(N > 1)
			return Math.log(N) + factorialln(N - 1);
		else
			return 0;
	}
	
}
