package exercise.algorithms4;

/**
 * ����ת������
 * java�Դ��ĺ�����{@link Integer#toBinaryString(int)}
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
