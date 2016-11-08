package exercise.algorithms4;

/**
 * 整数转二进制
 * java自带的函数：{@link Integer#toBinaryString(int)}
 * @author lsp
 *
 */
public class E1_1_9 {

	public static void main(String[] args) {
		int number = 5;
		
		System.out.println(Integer.toBinaryString(number));
		
		String s = "";
		for(int n = number; n > 0; n /= 2)
			s = n % 2 + s;
		System.out.println(s);
	}

}
