package model;

import java.util.ArrayList;
import java.util.List;

public class Hand {

	private ArrayList<Card> cards=new ArrayList<Card>();

	public Hand() {
	}

	/**
	 * set new cards (ArrayList of the card contained by the hand)
	 * @param cards new cards
	 */
	public void setCards(ArrayList<Card> cards) {
		this.cards=cards;
	}

	/**
	 * add a new card to the hand
	 * @param card card to add
	 */
	public void addCard(Card card) {
		this.cards.add(card);
	}

	/**
	 * add new cards to the hand
	 * @param cards cards to add
	 */
	public void addCard(List<Card> cards) {
		this.cards.addAll(cards);
	}

	/**
	 * @param cardIndex index of card to get from the hand
	 * @return the card allocated in the "cardIndex" position of Hand's attribute cards
	 */
	public Card getCard(int cardIndex) {
		return this.cards.get(cardIndex);
	}

	/**
	 * get and remove "numberOfCards" cards from the hand
	 * @param numberOfCards number of cards to get and remove
	 */
	public ArrayList<Card> getAndRemoveCards(int numberOfCards) {
		ArrayList<Card> result= new ArrayList<Card>();
		for (int i = 0; i < numberOfCards; i++) {
			result.add(this.cards.remove(0));
		}
		return result;
	}

	/**
	 * get and remove all the cards from the hand
	 */
	public ArrayList<Card> getAndRemoveCards() {
		ArrayList<Card> result= (ArrayList<Card>)this.cards.clone();
		this.cards=new ArrayList<Card>();
		return result;
	}

}