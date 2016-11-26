package exercise.algorithms4.e1_3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class E1_3__15_PrintKOfQueue {

	public static void main(String[] args) {
		int k = Integer.parseInt(args[0]);
		Queue<String> queue = new Queue<>();
		while(!StdIn.isEmpty()){
			queue.enqueue(StdIn.readString());
		}
		int i = 0;
		int j = queue.size() - k + 1;
		for(String item : queue){
			i++;
			if(i == j) {
				StdOut.println(item);
				break;
			}
		}
	}

}
