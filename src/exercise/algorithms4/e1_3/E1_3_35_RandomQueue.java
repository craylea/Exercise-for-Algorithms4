package exercise.algorithms4.e1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 随机队列.
 * @author lsp
 *
 */
public class E1_3_35_RandomQueue {
	public static final String[] SUITS = {"spade", "heart", "diamond", "club"};
	public static final String[] NAMES = {"A", "1", "2", "3", "4", "5", "6", "7", "8", "9", "J", "Q", "K"};
	
	public static void main(String[] args) {
		RandomQueue<String> queue = new RandomQueue(3);
		// zbcd acd ef ha ag
		while (!StdIn.isEmpty()) {
			String value = StdIn.readString();
			queue.enqueue(value);
		}

		for(int i = 0; i < 3; i++){
			StdOut.print(queue.sample() + " ");
		}
		StdOut.println();
		for(int i = 0; i < 3; i++){
			StdOut.print(queue.dequeue() + " ");
		}
		StdOut.println();
		for(int i = 0; i < 3; i++){
			StdOut.print(queue.sample() + " ");
		}
		StdOut.println("\n--------模拟扑克牌发牌----------");
		RandomQueue<Card> pokers = new RandomQueue(52);
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 13; j++){
				pokers.enqueue(new Card(SUITS[i], NAMES[j]));
			}
		}
		StringBuilder player1 = new StringBuilder();
		StringBuilder player2 = new StringBuilder();
		StringBuilder player3 = new StringBuilder();
		StringBuilder player4 = new StringBuilder();
		for(int i = 0; i < 13; i++){
			player1.append(pokers.dequeue() + " ");
			player2.append(pokers.dequeue() + " ");
			player3.append(pokers.dequeue() + " ");
			player4.append(pokers.dequeue() + " ");
		}
		StdOut.println("player1: " + player1);
		StdOut.println("player2: " + player2);
		StdOut.println("player3: " + player3);
		StdOut.println("player4: " + player4);
	}
}
