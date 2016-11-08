package exercise.algorithms4;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 
 * @author lsp
 *
 */
public class E1_1_30_gcd_array {

	public static void main(String[] args) {
		StdOut.print("请输入数组长度: ");
		int len = StdIn.readInt();
		boolean[][] gcdArray = new boolean[len][len];
		for(int i = 0; i < len; i++){
			for(int j = 0; j < len; j++){
				if(i == 0 || j == 0) {
					gcdArray[i][j] = true;
					continue;
				}
				if(E_Util.gcd(i, j) == 1){
					gcdArray[i][j] = false; 
				}else{
					gcdArray[i][j] = true;
				}
			}
		}
		StdOut.printf("%3s", " ");
		for(int i = 0; i < len; i++){
			StdOut.printf("% 5d", i);
		}
		StdOut.println();
		for(int i = 0; i < len; i++){
			StdOut.printf("% 3d", i);
			for(int j = 0; j < len; j++){
				StdOut.printf(" %b", gcdArray[i][j]);
			}
			StdOut.println();
		}
	}
}
