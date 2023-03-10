package model;

import controller.FrontController;

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
	public void enterRoom() throws Exception {
		FrontController.getInstance().chooseCardToBuy( this.purchasableCards );
	}

	public void addCard(Card card) {
		this.getPurchasableCards().add( card );
	}

}