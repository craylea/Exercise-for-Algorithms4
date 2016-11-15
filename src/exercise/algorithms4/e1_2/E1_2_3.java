package exercise.algorithms4.e1_2;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author lsp
 *
 */
public class E1_2_3 {

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		double min = Double.parseDouble(args[1]);
		double max = Double.parseDouble(args[2]);
		if(min > max) {
			double temp = min;
			min = max;
			max = temp;
		}
		Interval2D[] interval2ds = new Interval2D[N];
		initInterval2D(interval2ds, min, max);
		boolean[][] intervals = new boolean[N][N];
		for(int i = 0; i < N; i++){
			for(int j = i + 1; j < N; j++){
				if(!intervals[i][j] && !intervals[j][i] && interval2ds[i].intersects(interval2ds[j])){
					intervals[i][j] = true;
				}
			}
		}
		StdOut.println();
		for(int i = 0; i < N; i++){
			for(int j = i + 1; j < N; j++){
				if(intervals[i][j]){
					StdOut.println(i + interval2ds[i].toString() +" and " + j + interval2ds[j].toString());
				}
			}
		}
		String str1 = "hello";
		String str2 = str1;
		str1 = "world";
		StdOut.println(str1);
		StdOut.println(str2);
	}
	/**
	 * 初始化Interval2D数组
	 * @param interval2ds
	 */
	public static void initInterval2D(Interval2D[] interval2ds, double mi, double ma){
		for(int i = 0; i < interval2ds.length; i++){
			double min = StdRandom.uniform(mi, ma);
			double max = StdRandom.uniform(mi, ma);
			if(min > max) {
				double temp = min;
				min = max;
				max = temp;
			}
			Interval1D x = new Interval1D(min, max);
			min = StdRandom.uniform(mi, ma);
			max = StdRandom.uniform(mi, ma);
			if(min > max) {
				double temp = min;
				min = max;
				max = temp;
			}
			Interval1D y = new Interval1D(min, max);
			interval2ds[i] = new Interval2D(x, y);
			StdOut.println(i + interval2ds[i].toString());
			interval2ds[i].draw();
			double xc = (x.min() + x.max()) / 2.0;
	        double yc = (y.min() + y.max()) / 2.0;
			StdDraw.text(xc + x.length() / 2.0 - 0.0001, yc + y.length() / 2.0 - 0.0001, i + "");
		}
	}

}
