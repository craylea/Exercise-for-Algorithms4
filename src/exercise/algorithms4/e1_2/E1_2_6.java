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
	 * 判断两个字符串是否是回环变位(circular rotation) 比如：ACTGACG TGACGAC 就是回环变位
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean isCircularRotation(String str1, String str2){
		boolean isCR = false;
		
		if(str1.length() == str1.length()){
			/**
			 * 如果是回环变位，则把两个字符串1拼接起来，一定包含了字符串2，
			 * 且拼接后的字符串中的字符串2后面的字符与前面的字符的再拼到一起与字符串二相同
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
