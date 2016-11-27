package exercise.algorithms4.e1_3;

public class LinkedList {

	private Node<String> first;
	
	public LinkedList(){
		first = new Node<>();
	}
	public LinkedList(String value){
		first = new Node<>();
		first.value = value;
	}
	
	public Node<String> add(String value){
		Node<String> temp = new Node<>();
		temp.value = value;
		
		if(first.value == null){
			first = temp;
		}else{
			Node<String> p = first;
			while(p.next != null){
				p = p.next;
			}
			p.next = temp;
		}
		return temp;
	}
	
	public Node<String> getFirstNode(){
		return first;
	}
	
	public int delete(int k){
		if(first == null)
			return -1;
		if(k == 1){
			first = first.next;
		}else{
			Node<String> p = first;
			Node<String> pre = first;
			
			int i = 0;
			// �ҵ���k-1��Ԫ��
			while(i < k - 1 && p != null){
				pre = p;
				p = p.next;
				i++;
			}
			
			if(i == k - 1 && p != null){
				// �ѵ�k-1��Ԫ�ص�nextָ���k��Ԫ�ص�next
				// ǧ����ʹ�ðѵ�k��Ԫ��=��k��Ԫ�ص�next��
				// p = p.next��������û�а�first����ĵ�k��Ԫ��ɾ���������Ǹı��˱���p��ָ��
				// Ҳ����˵�����ǲ��ܸ����ñ�������Ҫ������ָ������ݵ�ֵ��
				pre.next = p.next;
			}else{
				// ��k��Ԫ�ز�����
				return -1;
			}
		}
		
		return k;
	}
	
	// 1.3.19
	public void deleteLastItem(){
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
	
	public boolean find(String key){
		Node<String> p = first;
		boolean isFound = false;
		while(p != null){
			if(p.value.equals(key)){
				isFound = true;
				break;
			}
			p = p.next;
		}
		return isFound;
	}
	
	public void removeAfter(Node<String> item){
		if(item != null && item.next != null){
			item.next = null;
		}
	}
}
