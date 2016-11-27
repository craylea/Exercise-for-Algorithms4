package exercise.algorithms4.e1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * ɾ���������һ��Ԫ��
 * @author lsp
 *
 */
public class E1_3_19_DeleteLast {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		Node<String> p = null;
		while(!StdIn.isEmpty()){
			String value = StdIn.readString();
			list.add(value);
		}
		p = list.getFirstNode();
		while(p != null){
			StdOut.print(p.value + " ");
			p = p.next;
		}
		StdOut.println();
		list.deleteLastItem();
		p = list.getFirstNode();
		while(p != null){
			StdOut.print(p.value + " ");
			p = p.next;
		}
	}

	
}
