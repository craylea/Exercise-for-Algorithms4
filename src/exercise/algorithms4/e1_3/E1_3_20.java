package exercise.algorithms4.e1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class E1_3_20 {

	private static Node<String> first = new Node<>();
	
	public static void main(String[] args) {
		int k = Integer.parseInt(args[0]);
		
		
		Node<String> p = null;
		while(!StdIn.isEmpty()){
			String value = StdIn.readString();
			if(first.value == null){
				first.value = value;
				p = first;
			}else{
				Node<String> temp = new Node<>();
				temp.value = value;
				p.next = temp;
				p = temp;
			}
		}
		StdOut.println(delete(k));
//		deleteLastItem();
		p = first;
		while(p != null){
			StdOut.print(p.value + " ");
			p = p.next;
		}
	}

	public static int delete( int k){
		if(first == null)
			return -1;
		if(k == 1){
			first = first.next;
		}else{
			Node<String> p = first;
			Node<String> pre = first;
			
			int i = 0;
			// 找到第k-1个元素
			while(i < k - 1 && p != null){
				pre = p;
				p = p.next;
				i++;
			}
			
			if(i == k - 1 && p != null){
				// 把第k-1个元素的next指向第k个元素的next
				// 千万不能使用把第k个元素=第k个元素的next：
				// p = p.next，这样并没有把first链表的第k个元素删掉，仅仅是改变了变量p的指向。
				// 也就是说，我们不能改引用本身，而是要改引用指向的内容的值。
				pre.next = p.next;
			}else{
				// 第k个元素不存在
				return -1;
			}
		}
		
		return k;
	}
	
	// 1.3.19
	public static void deleteLastItem(){
		if(first == null)
			return;
		if(first.next == null){
			first = null;
			return;
		}
		Node<String> pre = first;
		Node<String> p = first;
		while(p.next != null){
			pre = p;
			p = p.next;
		}
		pre.next = null;
	}
}
