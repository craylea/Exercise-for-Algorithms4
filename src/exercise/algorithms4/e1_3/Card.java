package exercise.algorithms4.e1_3;

/**
 * �˿���
 * ����spade,����heart,��Ƭdiamond,÷��club 
 * Aָ"����"(Ace),Kָ"����"(king),Qָ"����"(Queen),J�ǹ��ڵ�����"�ܿ�"(Jack),��Ҳ����˵��"̫��"��"����"(Judge).
 * @author lsp
 *
 */
public class Card {

	private String suit;
	private String name;
	
	public Card(String suit, String name){
		this.suit = suit;
		this.name = name;
	}

	public String getSuit() {
		return suit;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return suit + "-" + name;
	}
	
	
}
