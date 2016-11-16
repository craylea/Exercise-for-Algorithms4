package exercise.algorithms4.e1_2;

import edu.princeton.cs.algs4.StdDraw;

public class VisualCounter implements Comparable<VisualCounter> {

    private final String name;     // counter name
    private int count = 0;         // current value
    private int N;

    /**
     * Initializes a new counter starting at 0, with the given id.
     *
     * @param id the name of the counter
     */
    public VisualCounter(String id, int N, int max) {
        name = id;
        this.N = N;
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(-max, max);
//        StdDraw.setPenRadius(0.03);
    } 

    /**
     * Increments the counter by 1.
     */
    public void increment() {
    	if(N > 0){
    		count++;
    		StdDraw.point(N, count);
    		N--;
    	}
    } 
    
    public void decrement(){
    	if(N > 0){
    		count--;
    		StdDraw.point(N, count);
    		N--;
    	}
    }

    /**
     * Returns the current value of this counter.
     *
     * @return the current value of this counter
     */
    public int tally() {
        return count;
    } 

    /**
     * Returns a string representation of this counter.
     *
     * @return a string representation of this counter
     */
    public String toString() {
        return count + " " + name;
    } 

    /**
     * Compares this counter to the specified counter.
     *
     * @param  that the other counter
     * @return {@code 0} if the value of this counter equals
     *         the value of that counter; a negative integer if
     *         the value of this counter is less than the value of
     *         that counter; and a positive integer if the value
     *         of this counter is greater than the value of that
     *         counter
     */
    @Override
    public int compareTo(VisualCounter that) {
        if      (this.count < that.count) return -1;
        else if (this.count > that.count) return +1;
        else                              return  0;
    }
}
