package exercise.algorithms4.e1_3;

import edu.princeton.cs.algs4.StdOut;

public class RingBuffer<T> {

	private FixedCapacityQueue<T> queue;
	
	public RingBuffer(int cap){
		queue = new FixedCapacityQueue<>(cap);
	}
	/**
	 * �����������Ԫ��
	 * @param item
	 * @throws Exception 
	 */
	public void add(T item) throws Exception{
		while(queue.isFull())
			StdOut.println("��������������ȴ�������");
		StdOut.println("���Ԫ�أ�" + item);
		queue.enqueue(item);
	}
	/**
	 * �ӻ������Ƴ�Ԫ��
	 * @return
	 */
	public T remove(){
		while(queue.isEmpty())
			StdOut.println("�������գ���ȴ�������");
		T item = queue.dequeue();
		StdOut.println("ɾ��Ԫ�أ�" + item);
		return item;
	}
}
