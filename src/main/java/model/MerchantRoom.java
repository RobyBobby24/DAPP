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
		// TODO - implement MerchantRoom.MerchantRoom
		throw new UnsupportedOperationException();
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

}