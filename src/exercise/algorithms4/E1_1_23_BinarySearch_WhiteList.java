package exercise.algorithms4;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;import edu.princeton.cs.algs4.RabinKarp;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 使用二分查找进行白名单过滤
 * @author lsp
 *
 */
public class E1_1_23_BinarySearch_WhiteList {

	public static void main(String[] args) {
		int[] whiteList = (new In("/algs4-data/" + args[0])).readAllInts();
		Arrays.sort(whiteList);
		String opt = args[1];
		while(!StdIn.isEmpty()){
			int key = StdIn.readInt();
			if(opt.equals("+") && E_Util.rank(key, whiteList) < 0)
				StdOut.println(key);
			else if(opt.equals("-") && E_Util.rank(key, whiteList) > 0)
				StdOut.println(key);
		}
		
	}
	
}
