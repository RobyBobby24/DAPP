package model;

import java.util.*;

public class MerchantRoom extends Room {

	protected int ID;
	private List<Card> purchasableCards = new ArrayList<>();

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
	public void enterRoom() { FrontController.getInstance().chooseCardToBuy(purchasableCards);

	}

	public void addCard(Card card) {
		this.getPurchasableCards().add( card );
	}

}