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
public class E1_1_29_BinarySearch_WhiteList {

	public static void main(String[] args) {
		int[] whiteList = (new In("/abc.txt")).readAllInts();
		Arrays.sort(whiteList);
		for(int i = 0; i < whiteList.length; i++){
			StdOut.println(i + ": " + whiteList[i]);
		}
		while(!StdIn.isEmpty()){
			int key = StdIn.readInt();
			StdOut.println(key + ": " + E_Util.rankForMaxIndexLessThan(key, whiteList));
			StdOut.println(key + ": " + E_Util.rankForMinIndexGreaterThan(key, whiteList));
			StdOut.println(key + ": " + E_Util.rankForCount(key, whiteList));
			
			StdOut.println("=====================from internet===============================");
			StdOut.println("index: " + rank(key, whiteList));
			StdOut.println("count: " + count(key, whiteList));
		}
		
	}
	
	// =====================from internet===============================
	// 原方法存在bug，自己根据测试情况进行调整，以下是调整后的代码。
	// 不过，此方法的逻辑是：如果key存在数组a中，则返回key在a中的最小下标，否则返回-1。
	// 这似乎与题目中“返回数组中小于该键的元素数量”不符，以我的理解，应该是不管key是否存在数组a中，
	// 都应该返回数组a中小于key的值对应的下标。
	// 不知道是否中文版翻译过来后与原题不一致了？？ 看了英文版，翻译没啥问题
	public static int rank(int key, int[] a){
		int lo = 0;
		int hi = a.length - 1;
		while(lo <= hi){
			int mid = lo + (hi - lo) / 2;
			if(a[mid] < key){
				lo = mid + 1;
			}else if(a[mid] > key){
				hi = mid - 1;
			}else{
//				while(a[mid] == a[mid - 1] && mid >= 0){
//					mid--;
//				}
//				return mid;
				// 两个条件的顺序要交换下
				// 同时，这里调整了用key来判断，原来的方式也可以
				while(mid >= 0 && a[mid] == key ){
					mid--;
				}
				return mid + 1;
			}
		}
		return -1;
	}
	
	public static int count(int key, int[] a){
		int cnt = 0;
		int i = rank(key, a);
		// 这里存在-1的情况，就直接报错了
		// 加入对i的判断
		if(i >= 0){
//			while(a[i] == a[i + 1] && i < a.length ){
//				cnt++;
//				i++;
//			}
			// 同样，两个条件的顺序要交换下
			// 同时，这里调整了用key来判断，原来的方式有问题， 一是会数组越界，一是cnt会少一次
			while(i < a.length && a[i] == key ){
				cnt++;
				i++;
			}
		}
		return cnt;
	}
	
}
