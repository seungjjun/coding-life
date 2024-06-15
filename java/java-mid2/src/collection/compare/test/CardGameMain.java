package collection.compare.test;

public class CardGameMain {

	public static void main(String[] args) {
		Deck deck = new Deck();

		Player player1 = new Player("플레이어1");
		Player player2 = new Player("플레이어2");

		player1.draw(deck);
		player2.draw(deck);

		player1.showHand();
		player2.showHand();

		if (player1.result() > player2.result()) {
			System.out.println("플레이어1 승리");
		} else if (player2.result() > player1.result()) {
			System.out.println("플레이어2 승리");
		} else {
			System.out.println("무승부");
		}
	}
}
