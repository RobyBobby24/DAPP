package model;

import java.util.ArrayList;
import java.util.List;

public class DiscardPile {

	private ArrayList<Card> cards;

	public DiscardPile() {
		this.cards=new ArrayList<Card>();
	}

	/**
	 * set new cards (ArrayList of the card contained by the discardPile)
	 * @param cards new cards
	 */
	public void setCards(ArrayList<Card> cards) {
		this.cards=cards;
	}

	/**
	 * add a new card to the discardPile
	 * @param card card to add
	 */
	public void addCard(Card card) {
		this.cards.add(card);
	}

	/**
	 *  add new cards to the discardPile
	 * @param cards cards to add
	 */
	public void addCard(List<Card> cards) {
		this.cards.addAll(cards);
	}

	/**
	 * @param number number of cards to get
	 * @return  "number" cards from the discardPile
	 */
	public ArrayList<Card> getCards(int number) {
		ArrayList<Card> result= new ArrayList<Card>();
		for (int i = 0; i < number; i++) {
			result.add(this.cards.get(0));
		}
		return result;
	}

	/**
	 * @return all the cards of the discardPile
	 */
	public ArrayList<Card> getCards(){
		return this.cards;
	}

	public String var_dump(){
		return "cards:"+this.getCards();
	}

}