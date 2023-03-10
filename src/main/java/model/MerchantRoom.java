package model;

import java.util.*;

public class MerchantRoom extends Room {
	private List<Card> purchasableCards = new ArrayList<>();

	public List<Card> getPurchasableCards() {
		return this.purchasableCards;
	}

	public void setPurchasableCards(ArrayList<Card> purchasableCards) {
		this.purchasableCards = purchasableCards;
	}

	public MerchantRoom() {
		super();
	}

	@Override
	public void enterRoom() { FrontController.getInstance().chooseCardToBuy(purchasableCards);

	}

	public void addCard(Card card) {
		this.getPurchasableCards().add( card );
	}

}