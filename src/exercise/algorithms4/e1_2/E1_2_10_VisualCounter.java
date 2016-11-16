package exercise.algorithms4.e1_2;

import edu.princeton.cs.algs4.StdRandom;

/**
 * 
 * @author lsp
 *
 */
public class E1_2_10_VisualCounter {

	public static void main(String[] args) {
		int N = 100;
		int max = 200;
		
		VisualCounter counter = new VisualCounter("VC", N, max);
		for(int i = 0; i < N; i++){
			if(StdRandom.bernoulli(0.3)){
				counter.increment();
			}else {
				counter.decrement();
			}
		}
		
	}

	
	

}
