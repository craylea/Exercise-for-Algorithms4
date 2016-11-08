package exercise.algorithms4;

/**
 * 쳲�����
 * @author lsp
 *
 */
public class E1_1_19_Fibonacci {
	
	public static void main(String[] args) {
		System.out.println(FibonacciFast(50));
	}

	/**
	 * �ݹ����쳲�����
	 * @param N
	 * @return
	 */
	public static long Fibonacci(int N){
		if( N == 0) return 0;
		if( N == 1) return 1;
		return Fibonacci(N - 1) + Fibonacci(N - 2);
	}
	/**
	 * ��쳲��������иĽ�
	 * �����鱣���Ѿ��������ֵ
	 * @param N
	 * @return
	 */
	public static long FibonacciFast(int N){
		long[] a = new long[N + 1];
		a[0] = 0;
		a[1] = 1;
		for(int i = 2; i <= N; i++){
			a[i] = a[i - 1] + a[i - 2];
		}
		return a[N];
	}
}
