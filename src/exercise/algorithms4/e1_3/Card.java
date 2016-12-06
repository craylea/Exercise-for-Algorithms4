package exercise.algorithms4.e1_3;

/**
 * 扑克牌
 * 黑桃spade,红桃heart,方片diamond,梅花club 
 * A指"至尊"(Ace),K指"国王"(king),Q指"王后"(Queen),J是宫内的仆人"杰克"(Jack),但也有人说是"太子"或"法官"(Judge).
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
