package exercise.algorithms4;

import java.util.Arrays;

import javax.print.attribute.standard.RequestingUserName;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * ʹ�ö��ֲ��ҽ��а�����ɾ���ظ�Ԫ��
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
	// ԭ��������bug���Լ����ݲ���������е����������ǵ�����Ĵ��롣
	// �������˷������߼��ǣ����key��������a�У��򷵻�key��a�е���С�±꣬���򷵻�-1��
	// ���ƺ�����Ŀ�С�����������С�ڸü���Ԫ�����������������ҵ���⣬Ӧ���ǲ���key�Ƿ��������a�У�
	// ��Ӧ�÷�������a��С��key��ֵ��Ӧ���±ꡣ
	// ��֪���Ƿ����İ淭���������ԭ�ⲻһ���ˣ��� ����Ӣ�İ棬����ûɶ����
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
				// ����������˳��Ҫ������
				// ͬʱ�������������key���жϣ�ԭ���ķ�ʽҲ����
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
		// �������-1���������ֱ�ӱ�����
		// �����i���ж�
		if(i >= 0){
//			while(a[i] == a[i + 1] && i < a.length ){
//				cnt++;
//				i++;
//			}
			// ͬ��������������˳��Ҫ������
			// ͬʱ�������������key���жϣ�ԭ���ķ�ʽ�����⣬ һ�ǻ�����Խ�磬һ��cnt����һ��
			while(i < a.length && a[i] == key ){
				cnt++;
				i++;
			}
		}
		return cnt;
	}
	
}
