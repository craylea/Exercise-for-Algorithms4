package exercise.algorithms4;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author lsp
 *
 */
public class E1_1_31 {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		double p = Double.parseDouble(args[1]);
		
		int x = 50;
		int y = 50;
		int r = 50;
		StdDraw.setXscale(x - r * 2, x + r * 2);
		StdDraw.setYscale(y - r * 2, y + r * 2);
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.circle(x, y, r);
		double oldPenRadius = StdDraw.getPenRadius();
//		StdOut.print(oldPenRadius);
		StdDraw.setPenRadius(0.05);
		StdDraw.point(0, 0);
		Point[] points = drawPoint(x, y, r, n);
		StdDraw.setPenRadius(oldPenRadius);
		StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
		drawLine(points, p);
		
	}
	
	public static Point[] drawPoint(int x, int y, int r, int n){
		Point[] points = new Point[n];
		for(int i = 0; i < n; i++){
			points[i] = new Point();
			points[i].x = x + r * Math.cos(2 * Math.PI * i / n);
			points[i].y = y + r * Math.sin(2 * Math.PI * i / n);
			StdDraw.point(points[i].x, points[i].y);
		}
		return points;
	}
	
	public static void drawLine(Point[] points, double p){
		for(int i = 0; i < points.length; i++){
			for(int j = 0; j < points.length; j++){
				if(i != j && !StdRandom.bernoulli(p)){
					StdDraw.line(points[i].x, points[i].y, points[j].x, points[j].y);
				}
			}
		}
	}
	
	static class Point{
		double x;
		double y;
	}

}
