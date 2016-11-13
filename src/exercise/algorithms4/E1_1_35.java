package exercise.algorithms4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Ä£ÄâÖÀ÷»×Ó
 * @author lsp
 *
 */
public class E1_1_35 {

	public static void main(String[] args) {
		int SIDES = 6;
		double[] dist = new double[2 * SIDES + 1];
		
		for(int i = 1; i <= SIDES; i++){
			for(int j = 1; j <= SIDES; j++){
				dist[i + j] += 1;
			}
		}
		for(int i = 2; i <= 2 * SIDES; i++){
			dist[i] /= 36;
			StdOut.println(i + ": " + dist[i]);
		}
		StdOut.println("----------------------------------------");
		StdOut.print(random6(dist, SIDES));
	}
	
	public static int random6(double[] dist, int SIDES){
		int n = 0;
		boolean isOver = false;
		while(!isOver){
			n++;
			int count = 0;
			int first = 0;
			int second = 0;
			double[] test = new double[dist.length];
			while(count < n){
				first = StdRandom.uniform(1, SIDES + 1);
				second = StdRandom.uniform(1, SIDES + 1);
				test[first + second] += 1;
				count++;
			}
			int i = 0;
			for(i = 2; i <= test.length - 1; i++){
				test[i] /= count;
				if(test[i] - dist[i] > 0.0001){
					break;
				}
			}
			
			if(i == test.length){
				isOver = true;
				for(i = 2; i <= test.length - 1; i++){
					StdOut.println(i + ": " + test[i]);
				}
			}
			
			
		}
		
		return n;
	}

}
