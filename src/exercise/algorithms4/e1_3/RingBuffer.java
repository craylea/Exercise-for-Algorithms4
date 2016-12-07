package exercise.algorithms4.e1_3;

import edu.princeton.cs.algs4.StdOut;

public class RingBuffer<T> {

	private FixedCapacityQueue<T> queue;
	
	public RingBuffer(int cap){
		queue = new FixedCapacityQueue<>(cap);
	}
	/**
	 * 往缓冲区添加元素
	 * @param item
	 * @throws Exception 
	 */
	public void add(T item) throws Exception{
		while(queue.isFull())
			StdOut.println("缓冲区已满，请等待。。。");
		StdOut.println("添加元素：" + item);
		queue.enqueue(item);
	}
	/**
	 * 从缓冲区移除元素
	 * @return
	 */
	public T remove(){
		while(queue.isEmpty())
			StdOut.println("缓冲区空，请等待。。。");
		T item = queue.dequeue();
		StdOut.println("删除元素：" + item);
		return item;
	}
}
