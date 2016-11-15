package exercise.algorithms4.e1_2;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author lsp
 *
 */
public class E1_2_6 {

	public static void main(String[] args) {
		
		String str1 = args[0];
		String str2 = args[1];
		StdOut.println(str1 + " and " + str2 + " is " + 
						(isCircularRotation(str1, str2) ? "" : "not ") + "circular rotation.");
		
	}
	/**
	 * �ж������ַ����Ƿ��ǻػ���λ(circular rotation) ���磺ACTGACG TGACGAC ���ǻػ���λ
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean isCircularRotation(String str1, String str2){
		boolean isCR = false;
		
		if(str1.length() == str1.length()){
			/**
			 * ����ǻػ���λ����������ַ���1ƴ��������һ���������ַ���2��
			 * ��ƴ�Ӻ���ַ����е��ַ���2������ַ���ǰ����ַ�����ƴ��һ�����ַ�������ͬ
			 * ACTGACGACTGACG(AC)
			 *   TGACGAC
			 */
			String temp = str1 + str1;
			int index = temp.indexOf(str2);
			if(index >= 0){
				temp = temp.substring(index + str2.length()) + temp.substring(0, index);
				if(temp.equals(str2)) isCR = true;
			}
		}
		
		return isCR;
	}

}
