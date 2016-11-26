package exercise.algorithms4.e1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixedCapacityStack<Item> {

	private Item[] items;
	private int n;
	
	public FixedCapacityStack(int cap){
		items = (Item[]) new Object[cap];
	}
	
	public boolean isEmpty(){
		return n == 0;
	}
	public boolean isFull(){
		return n == items.length;
	}
	public int size(){
		return n;
	}
	public void push(Item item) throws Exception{
		if(isFull()) throw new Exception("Stack overflow");
		items[n++] = item;
	}
	public Item pop() throws Exception{
		if(isEmpty()) throw new Exception("Stack underflow");
		return items[--n];
	}
	public static void main(String[] args) throws Exception{
		// to be or not to - be - - that - - - is
		// it was - the best - of times - - - it was - the - -
		// was best times of the was the it
		FixedCapacityStack<String> stack = new FixedCapacityStack<>(100);
		while(!StdIn.isEmpty()){
			String item = StdIn.readString();
			if(!item.equals("-")){
				stack.push(item);
			}else{
				StdOut.println(stack.pop());
			}
		}
		StdOut.println(stack.size() + " left on stack.");
	}
}
