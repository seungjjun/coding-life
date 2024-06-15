package collection.compare.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private final List<Card> deck = new ArrayList<>();

	public Deck() {
		initCard();
		shuffle();
	}

	private void initCard() {
		for (int i = 1; i < 14; i++) {
			for (Suit suit : Suit.values()) {
				deck.add(new Card(suit, i));
			}
		}
	}

	public void shuffle() {
		Collections.shuffle(deck);
	}

	public Card drawCard() {
		return deck.removeFirst();
	}

	public List<Card> getDeck() {
		return deck;
	}

	@Override
	public String toString() {
		return "Deck{" +
			"deck=" + deck +
			'}';
	}
}
