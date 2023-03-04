package model;

import java.util.*;

public class MerchantRoom implements Room {

	ArrayList<Card> cards;
	private Card[] purchasableCards;

	public Card[] getPurchasableCards() {
		return this.purchasableCards;
	}

	public void setPurchasableCards(Card[] purchasableCards) {
		this.purchasableCards = purchasableCards;
	}

	public MerchantRoom() {
		// TODO - implement MerchantRoom.MerchantRoom
		throw new UnsupportedOperationException();
	}

	@Override
	public void enterRoom() {

	}

	@Override
	public int getId() {
		return 0;
	}

	@Override
	public void setId(int id) {

	}

}