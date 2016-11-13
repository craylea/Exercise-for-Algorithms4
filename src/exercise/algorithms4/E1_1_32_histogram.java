package exercise.algorithms4;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author lsp
 *
 */
public class E1_1_32_histogram {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		double l = Double.parseDouble(args[1]);
		double r = Double.parseDouble(args[2]);
		double dx = (r - l) / (n - 1);
		
		if(dx != 0.0){
			int[] counts = new int[n];
			
			int count = 0;
			StdOut.println("ÇëÊäÈë:");
			do{
				double v = StdIn.readDouble();
				if(v >= l && v <= r){
					count++;
					int position = (int)Math.round((v - l) / dx);
					counts[position] += 1;
				}
			}while(!StdIn.isEmpty());
			
			StdDraw.setXscale(- l * 2, r * 2);
			StdDraw.setYscale(- count , count);
			StdDraw.setPenColor(StdDraw.YELLOW);
			StdDraw.line(0, 0, l, 0);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.line(l, 0, r * 1.5, 0);
			drawPoint(l, r, dx, counts);
		}
		
	}
	
	public static void drawPoint(double l, double r, double dx, int[] counts ){
		for(int i = 0; i < counts.length; i++){
			if(counts[i] != 0){
				if(i % 2 == 0){
					StdDraw.setPenColor(StdDraw.BLUE);
				}else{
					StdDraw.setPenColor(StdDraw.BOOK_RED);
				}
				StdDraw.filledRectangle(l + dx / 2 + dx * i, counts[i] * 1.0 / 2, dx / 2, counts[i] * 1.0 / 2);
				StdDraw.text(l + dx / 2 + dx * i, counts[i] + 0.5, counts[i] + "");
			}
		}
	}


}
