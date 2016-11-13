package exercise.algorithms4.e1_2;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author lsp
 *
 */
public class E1_2_1 {

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		
//		Interval1D x = new Interval1D(.2, .5);
//		Interval1D y = new Interval1D(.5, .6);
//		Interval2D box = new Interval2D(x, y);
//		box.draw();
		
		StdDraw.setPenRadius(0.02);
		Point2D[] point2ds = new Point2D[N];
		initPoint2D(point2ds);
		StdDraw.setPenRadius();
		// 计算距离
		double[][] distance = new double[N][N];
		for(int i = 0; i < N; i++){
			for(int j = i + 1; j < N; j++){
				distance[i][j] = point2ds[i].distanceTo(point2ds[j]);
				distance[j][i] = distance[i][j];
			}
		}
		// 查找最小值
		double min = Double.MAX_VALUE;
		int minI = 0;
		int minJ = 0;
		for(int i = 0; i < N; i++){
			for(int j = i + 1; j < N; j++){
				if(min > distance[i][j]){
					min = distance[i][j];
					minI = i;
					minJ = j;
				}
			}
		}
		StdOut.printf("point%d(%f, %f) distance to point%d(%f, %f) is %f",
				minI, point2ds[minI].x(), point2ds[minI].y(), 
				minJ, point2ds[minJ].x(), point2ds[minJ].y(), min);
//		StdDraw.line(point2ds[minI].x(), point2ds[minI].y(), point2ds[minJ].x(), point2ds[minJ].y());
		point2ds[minI].drawTo(point2ds[minJ]);
	}
	/**
	 * 初始化Point2D数组
	 * @param point2ds
	 */
	public static void initPoint2D(Point2D[] point2ds){
		for(int i = 0; i < point2ds.length; i++){
			point2ds[i] = new Point2D(StdRandom.uniform(), StdRandom.uniform());
			point2ds[i].draw();
		}
	}

}
