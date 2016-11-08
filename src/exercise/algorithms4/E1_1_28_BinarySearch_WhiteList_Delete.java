package exercise.algorithms4;

import java.lang.reflect.Array;
import java.util.Arrays;

import edu.princeton.cs.algs4.In;import edu.princeton.cs.algs4.RabinKarp;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 使用二分查找进行白名单删除重复元素
 * @author lsp
 *
 */
public class E1_1_28_BinarySearch_WhiteList_Delete {

	public static void main(String[] args) {
		int[] whiteList = (new In("/abc.txt")).readAllInts();
		Arrays.sort(whiteList);
//		myMethod(whiteList);
		methodFromInternet(whiteList);
	}
	
	public static void myMethod(int[] whiteList){
		for(int i = 0; i < whiteList.length; i++){
			StdOut.println(i + ": " + whiteList[i]);
		}
		while(!StdIn.isEmpty()){
			int key = StdIn.readInt();
			int index = -1;
			boolean isDelete = false;
			// 删除所有找到的key
			while((index = E_Util.rank(key, whiteList)) > 0){
				whiteList = E_Util.deleteFromArray(whiteList, index);
				isDelete = true;
			}
			// 把key加回whiteList
			if(isDelete){
				whiteList = E_Util.addToArray(whiteList, key);
				Arrays.sort(whiteList);
			}

//			StringBuilder sb = new StringBuilder();
			// 这里本来打算通过index + 1，来查找所有的key，但是这样是会失败的，因为BinarySearch不是顺序查找的
//			while((index = E1_1_22_BinarySearch.rank(key, whiteList, index + 1, whiteList.length - 1)) > 0){
//				sb.append(index).append(",");
////				StdOut.println(index);
//			}
//			if(sb.length() > 0){
//				String[] delete = sb.toString().split(",");
//				for(int i = 1; i < delete.length; i++){
////					StdOut.println(i + ": " + delete[i]);
//					whiteList = E_Util.deleteFromArray(whiteList, Integer.parseInt(delete[i]));
//				}
//			}
			for(int i = 0; i < whiteList.length; i++){
				StdOut.println(i + ": " + whiteList[i]);
			}
		}
	}
	
	/**
	 * 网上找到的方法,直接删除重复数据
	 * @param a
	 */
	public static void methodFromInternet(int[] a){
		int cnt = countC(a);
		int[] b = remove(a, cnt);
		for(int i = 0; i < b.length; i++){
			StdOut.println(i + ": " + b[i]);
		}
	}
	/**
	 * 计算数组中重复的次数
	 * @param a
	 * @return
	 */
	public static int countC(int[] a){
		int cnt = 0;
		for(int i = 0; i < a.length - 1; i++){
			if(a[i] == a[i + 1]){
				cnt++;
			}
		}
		return cnt;
	}
	/**
	 * 删除重复的数
	 * @param a
	 * @param cnt
	 * @return
	 */
	public static int[] remove(int[] a, int cnt){
		int s = 0;
		int[] b = new int[a.length - cnt];
		b[0] = a[0];
		for(int i = 0; i < a.length - 1; i++){
			if(a[i] == a[i + 1]){
				s++;
			}else{
				b[i - s + 1] = a[i + 1];
			}
		}
		
		return b;
	}
	
}
