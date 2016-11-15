package exercise.algorithms4.e1_2;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author lsp
 *
 */
public class E1_2_2 {

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		Interval1D[] interval1ds = new Interval1D[N];
		initInterval1D(interval1ds);
		boolean[][] intervals = new boolean[N][N];
		for(int i = 0; i < N; i++){
			for(int j = i + 1; j < N; j++){
				if(!intervals[i][j] && !intervals[j][i] && interval1ds[i].intersects(interval1ds[j])){
					intervals[i][j] = true;
				}
			}
		}
		StdOut.println();
		for(int i = 0; i < N; i++){
			for(int j = i + 1; j < N; j++){
				if(intervals[i][j]){
//					StdOut.println(i + "(" + interval1ds[i].min() + ", " + interval1ds[i].max() + ") and " + 
//				                   j + "(" + interval1ds[j].min() + ", " + interval1ds[j].max() + ")");
					StdOut.println(i + interval1ds[i].toString() +" and " + j + interval1ds[j].toString());
				}
			}
		}
	}
	/**
	 * 初始化Interval1D数组
	 * @param interval1ds
	 */
	public static void initInterval1D(Interval1D[] interval1ds){
		for(int i = 0; i < interval1ds.length; i++){
			double min = StdRandom.uniform();
			double max = StdRandom.uniform();
			if(min > max) {
				double temp = min;
				min = max;
				max = temp;
			}
			interval1ds[i] = new Interval1D(min, max);
//			StdOut.println(i + "(" + interval1ds[i].min() + ", " + interval1ds[i].max() + ")");
			StdOut.println(i + interval1ds[i].toString());
		}
	}

}
