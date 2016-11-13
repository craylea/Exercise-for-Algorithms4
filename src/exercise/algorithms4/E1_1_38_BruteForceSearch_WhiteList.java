package exercise.algorithms4;

import java.util.Arrays;

import javax.print.attribute.standard.RequestingUserName;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 使用二分查找进行白名单删除重复元素
 * @author lsp
 *
 */
public class E1_1_38_BruteForceSearch_WhiteList {

	public static void main(String[] args) {
		int[] whiteList = (new In(args[0])).readAllInts();
		Arrays.sort(whiteList);
//		for(int i = 0; i < whiteList.length; i++){
//			StdOut.println(i + ": " + whiteList[i]);
//		}
		long timeRank = 0;
		long timeForce = 0;
		while(!StdIn.isEmpty()){
			int key = StdIn.readInt();
			long start = System.currentTimeMillis();
			E_Util.rank(key, whiteList);
			timeRank += System.currentTimeMillis() - start;
			start = System.currentTimeMillis();
			bruteForceSearch(key, whiteList);
			timeForce += System.currentTimeMillis() - start;
		}
		StdOut.print("timeRank: " + timeRank + "; timeForce: " + timeForce);
	}
	
	public static int bruteForceSearch(int key, int[] a){
		for(int i = 0; i < a.length; i++){
			if(key == a[i]) return i;
		}
		return -1;
	}
	
}
