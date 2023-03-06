package model;

import java.util.*;

public class MerchantRoom implements Room {

	protected int ID;
	private List<Card> purchasableCards;

	public List<Card> getPurchasableCards() {
		return this.purchasableCards;
	}

	public void setPurchasableCards(ArrayList<Card> purchasableCards) {
		this.purchasableCards = purchasableCards;
	}

	public MerchantRoom() {

	}

	@Override
	public void setID(int value) {

	}

	@Override
	public int getID() {
		return 0;
	}

	@Override
	public void enterRoom() {

	}

	public void addCard(Card card) {
		this.getPurchasableCards().add( card );
	}

}