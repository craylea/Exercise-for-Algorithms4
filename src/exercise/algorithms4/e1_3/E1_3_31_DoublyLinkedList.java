package exercise.algorithms4.e1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 双向链表操作.
 * @author lsp
 *
 */
public class E1_3_31_DoublyLinkedList {

	public static void main(String[] args) {
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		DoublyLinkedList<String> list2 = new DoublyLinkedList<String>();
		DoubleNode<String> p = null;
		// a a b c e d a e f g a
		// zbcd acd ef ha ag
		while (!StdIn.isEmpty()) {
			String value = StdIn.readString();
			list.add(value);
			list2.addFirst(value);
		}
		
		StdOut.println("\n---------链表尾增加---------");
		DoubleNode<String> first = list.getFirstNode();
		p = first;
		if(p != null){
			do {
				StdOut.print(p.value + " ");
				p = p.next;
			}while (p != first);
		}
		StdOut.println("\n---------链表头增加---------");
		first = list2.getFirstNode();
		p = first;
		if(p != null){
			do {
				StdOut.print(p.value + " ");
				p = p.next;
			}while (p != first);
		}
//		StdOut.println("\n---------链表尾删除: " + list.delete() + "---------");
//		first = list.getFirstNode();
//		p = first;
//		if(p != null){
//			do {
//				StdOut.print(p.value + " ");
//				p = p.next;
//			}while (p != first);
//		}
		while(!list.isEmpty()){
			StdOut.println("\n---------链表尾删除: " + list.delete() + "---------");
		}
//		StdOut.println("\n---------链表头删除: " + list2.deleteFirst() + "---------");
//		first = list2.getFirstNode();
//		p = first;
//		if(p != null){
//			do {
//				StdOut.print(p.value + " ");
//				p = p.next;
//			}while (p != first);
//		}
		while(!list2.isEmpty()){
			StdOut.println("\n---------链表头删除: " + list2.deleteFirst() + "---------");
		}
		
		StdOut.println("\n---------插入指定节点前---------");
		StdOut.println("---------插入指定节点3前" + list.insertBefore(3, "before1") + "---------");
		StdOut.println("---------插入指定节点3前" + list.insertBefore(3, "before2") + "---------");
		StdOut.println("---------插入指定节点3前" + list.insertBefore(3, "before3") + "---------");
		StdOut.println("---------插入指定节点3前" + list.insertBefore(3, "before4") + "---------");
		first = list.getFirstNode();
		p = first;
		if(p != null){
			do {
				StdOut.print(p.value + " ");
				p = p.next;
			}while (p != first);
		}
		// zbcd acd ef ha ag
		StdOut.println("\n---------插入指定节点后---------");
		StdOut.println("---------插入指定节点3后" + list2.insertAfter(3, "after31") + "---------");
		StdOut.println("---------插入指定节点3后" + list2.insertAfter(3, "after32") + "---------");
		StdOut.println("---------插入指定节点3后" + list2.insertAfter(3, "after33") + "---------");
		StdOut.println("---------插入指定节点3后" + list2.insertAfter(3, "after34") + "---------");
		StdOut.println("---------插入指定节点3后" + list2.insertAfter(3, "after35") + "---------");
		first = list2.getFirstNode();
		p = first;
		if(p != null){
			do {
				StdOut.print(p.value + " ");
				p = p.next;
			}while (p != first);
		}
		StdOut.println("\n---------删除指定节点" + list2.delete(4) + "---------");
		first = list2.getFirstNode();
		p = first;
		if(p != null){
			do {
				StdOut.print(p.value + " ");
				p = p.next;
			}while (p != first);
		}
		
		
	}
}
