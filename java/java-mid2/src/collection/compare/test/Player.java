package collection.compare.test;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private final String name;
	private final List<Card> myDeck;

	public Player(String name) {
		this.name = name;
		this.myDeck = new ArrayList<>();
	}

	public void draw(Deck deck) {
		for (int i = 0; i < 5; i++) {
			myDeck.add(deck.drawCard());
		}
	}

	public int result() {
		int sum = 0;
		for (Card card : myDeck) {
			sum += card.getRank();
		}
		return sum;
	}

	public void showHand() {
		myDeck.sort(null);
		System.out.println(name + "의 카드: " + myDeck + ", 합계: " + result());
	}

	@Override
	public String toString() {
		return myDeck.toString();
	}
}
