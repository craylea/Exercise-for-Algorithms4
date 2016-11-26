package exercise.algorithms4;

import java.util.Random;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class E_Util {

	/**
	 * 初始化一维整型数组，取值范围是[0, n)
	 * @param a
	 * @param n
	 */
	public static void initIntArray(int[] a, int n){
		for(int i = 0; i < a.length; i++){
			a[i] = StdRandom.uniform(n);
		}
	}
	public static void initIntArrayFixedLen(int[] a, int len){
		for(int i = 0; i < a.length; i++){
			a[i] = random(len);
		}
	}
	/**
	 * 产生长度为len的随机数
	 * @param len
	 * @return
	 */
	public static int random(int len){
		int r = StdRandom.uniform(1, 10);;
		for(int i = 1; i <= len - 1; i++){
			r = r * 10 + StdRandom.uniform(10);
		}
		return r;
	}
	/**
	 * 产生长度为len的随机数，这种方法可能产生首位为0的数据
	 * @param len
	 * @return
	 */
	public static String makeNumber(int len) {
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < len; i++) {
			sb.append(random.nextInt(10));
		}
		return sb.toString();
	}
	/**
	 * 初始化二维布尔数组
	 * @param a
	 * @return
	 */
	public static void initBooleanArray(boolean[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (StdRandom.bernoulli(0.1))
					a[i][j] = true;
				else
					a[i][j] = false;
			}
		}
	}
	/**
	 * 从数组a中删除指定的下标index
	 * 新增数组保存删除指定下标后的数组，数组a及其数据不会被改变
	 * @param a
	 * @param index
	 * @return 返回删除指定下标后的数组
	 */
	public static int[] deleteFromArray(int[] a, int index){
		if(index < 0 || index >= a.length) return a;
		
		int[] afterDelete = new int[a.length - 1];
		for(int i = 0; i < afterDelete.length; i++){
			if(i < index)
				afterDelete[i] = a[i];
			else
				afterDelete[i] = a[i + 1];
		}
		return afterDelete;
	}
	/**
	 * 把value添加到数组a中
	 * 新增数组保存增加数据之后的数组，数组a及其数据不会被改变
	 * @param a
	 * @param value
	 * @return 返回增加数据之后的数组
	 */
	public static int[] addToArray(int[] a, int value) {
		int[] afterAdd = new int[a.length + 1];
		for(int i = 0; i < a.length; i++){
			afterAdd[i] = a[i];
		}
		afterAdd[afterAdd.length - 1] = value;
		return afterAdd;
	}
	/**
	 * 在lo到hi的范围内，使用 二分查找方法查找数组中key的下表
	 * @param key 需要查找的值
	 * @param a 被查找的数据集合
	 * @param lo 开始下标
	 * @param hi 结束下标
	 * @return 如果找到则返回下标值，否则返回-1
	 */
	public static int rank(int key, int[] a, int lo, int hi){
		if(lo > hi) return -1;
		int mid = lo + (hi - lo) / 2 ;
		if( key < a[mid]) 
			return rank(key, a, lo, mid - 1);
		else if(key > a[mid]) 
			return rank(key, a, mid + 1, hi);
		else 
			return mid;
	}
	/**
	 * 二分查找 
	 * 查找整个数组
	 * @param key 需要查找的值
	 * @param a 被查找的数据集合
	 * @return
	 */
	public static int rank(int key, int[] a) {
		return rank(key, a, 0, a.length - 1);
	}
	/**
	 * 在范围lo到hi内，使用二分查找方法查找数组a中比key小的值的最大下标
	 * @param key 需要查找的值
	 * @param a 被查找的数据集合
	 * @param lo 开始下标
	 * @param hi 结束下标
	 * @return
	 */
	public static int rankForMaxIndexLessThan(int key, int[] a, int lo, int hi){
		StdOut.println(lo + " -- " + hi);
		if(lo > hi) return lo;
		
		int mid = lo + (hi - lo) / 2 ;
		
		if(a[mid] < key){ 
			if(mid + 1 < a.length && a[mid + 1] < key){ // 保证a[lo] < key
				return rankForMaxIndexLessThan(key, a, mid + 1, hi);
			}
			return mid;
		}else{
			if(mid - 1 >= 0 && a[mid - 1] >= key){ // 保证a[hi] >= key
				return rankForMaxIndexLessThan(key, a, lo, mid - 1);
			}
			return mid - 1;
		}
	}
	/**
	 * 使用二分查找方法查找数组a中比key小的值的最大下标
	 * @param key 需要查找的值
	 * @param a 被查找的数据集合
	 * @return
	 */
	public static int rankForMaxIndexLessThan(int key, int[] a) {
		return rankForMaxIndexLessThan(key, a, 0, a.length - 1);
	}
	/**
	 * 在范围lo到hi内，使用二分查找方法查找数组a中比key大的值的最小下标
	 * @param key 需要查找的值
	 * @param a 被查找的数据集合
	 * @param lo 开始下标
	 * @param hi 结束下标
	 * @return
	 */
	public static int rankForMinIndexGreaterThan(int key, int[] a, int lo, int hi){
		StdOut.println(lo + " -- " + hi);
		if(lo > hi) {
			if(hi < 0){ // key小于第一个数  0 -- -1
				return 0;
			}else{ // key大于或等于最后一个数  a.length -- a.length - 1
				return -1;
			}
		}
		
		int mid = lo + (hi - lo) / 2 ;
		
		if(a[mid] <= key){ 
			if(mid + 1 < a.length && a[mid + 1] > key){ // 保证a[lo] <= key
				return mid + 1;
			}
			return rankForMinIndexGreaterThan(key, a, mid + 1, hi);
			
		}else{
			if(mid - 1 >= 0 && a[mid - 1] <= key){ // 保证a[hi] > key
				return mid;
			}
			return rankForMinIndexGreaterThan(key, a, lo, mid - 1);
			
		}
	}
	/**
	 * 使用二分查找方法查找数组a中比key大的值的最小下标
	 * @param key 
	 * @param a
	 * @return
	 */
	public static int rankForMinIndexGreaterThan(int key, int[] a) {
		return rankForMinIndexGreaterThan(key, a, 0, a.length - 1);
	}
	/**
	 * 使用二分查找方法查找数组a中key出现的次数
	 * @param key
	 * @param a
	 * @return
	 */
	public static int rankForCount(int key, int[] a){
		int count = 0;
		
		// key存在a中的可能最小下标
		int minIndex = rankForMaxIndexLessThan(key, a) + 1;
		// key存在a中的可能最大下标
		int maxIndex = rankForMinIndexGreaterThan(key, a) - 1;
		if(maxIndex < -1 ){ // 大于或等于a中的最大值
			maxIndex = a.length - 1; 
		}
		if(maxIndex >= minIndex){
			count = maxIndex - minIndex + 1;
		}
		
		return count;
	}
	/**
	 * 求a与b的最大公约数（greatest common divisor）
	 * @param a
	 * @param b
	 * @return
	 */
	public static int gcd(int a, int b){
		if(a < b){
			int temp = a;
			a = b;
			b = temp;
		}
		StdOut.println(a + " -- " + b);
		if(b == 0) return 0;
		if(a % b == 0) return b;
		return gcd(a, a % b);
	}
	public static long gcd(long a, long b){
		if(a < b){
			long temp = a;
			a = b;
			b = temp;
		}
		StdOut.println(a + " -- " + b);
		if(b == 0) return 0;
		if(a % b == 0) return b;
		return gcd(a, a % b);
	}
	
	/**
	 * 向量点乘
	 * @param x
	 * @param y
	 * @return
	 */
	public static double dot(double[] x, double[] y){
		if(x.length != y.length) return 0.0;
		double result = 0.0;
		for(int i = 0; i < x.length; i++){
			result += x[i] * y[i];
		}
		return result;
	}
	/**
	 * 矩阵和矩阵之积
	 * @param a
	 * @param b
	 * @return
	 */
	public static double[][] mult(double[][] a, double[][] b){
		if(a[0].length != b.length) return null;
		double[][] c = new double[a.length][b[0].length];
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < b[0].length; j++){
				for(int k = 0; k < a[0].length; k++){
					c[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		return c;
	}
	/**
	 * 矩阵转置
	 * @param a
	 * @return
	 */
	public static double[][] transpose(double[][] a){
		double[][] b = new double[a[0].length][a.length];
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < a[0].length; j++){
				b[j][i] = a[i][j];
			}
		}
		return b;
	}
	/**
	 * 矩阵和向量之积
	 * @param a
	 * @param x
	 * @return
	 */
	public static double[] mult(double[][] a, double[] x){
		if(a[0].length != x.length) return null;
		double b[] = new double[a.length];
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < a[0].length; j++){
				b[i] += a[i][j] * x[j];
			}
		}
		return b;
	}
	/**
	 * 向量和矩阵之积
	 * @param y
	 * @param a
	 * @return
	 */
	public static double[] mult(double[] y, double[][] a){
		if(y.length != a.length) return null;
		double b[] = new double[a[0].length];
		for(int i = 0; i < a[0].length; i++){
			for(int j = 0; j < a.length; j++){
				b[i] += y[j] * a[j][i];
			}
		}
		return b;
	}
}
