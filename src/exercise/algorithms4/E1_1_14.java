package exercise.algorithms4;

/**
 * 不大于logMN的最大整数
 * @author lsp
 *
 */
public class E1_1_14 {

	public static void main(String[] args) {
		System.out.println(maxIntToLog(2, 10));
		System.out.println(log(2, 10));
		System.out.println(Math.log(Math.E));
		System.out.println(Math.log10(10));
		System.out.println(Math.log1p(2));
	}

	public static int maxIntToLog(int M, int N){
		int a = 0;
		while(N >= M){
			N = N / M;
			a++;
		}
		return a;
	}
	
	/**
	 * 以M为底，N的对数
	 * @param M
	 * @param N
	 * @return
	 */
	public static double log(int M, int N){
		return Math.log(N) / Math.log(M);
	}
}
