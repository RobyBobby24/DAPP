package model;

import view.FrontView;

import java.util.List;

public class MerchantController {

	private static MerchantController instance;


	private MerchantController() {

	}

	public static MerchantController getInstance() {
		if(MerchantController.instance == null){
			MerchantController.instance = new MerchantController();
		}
		return MerchantController.instance;
	}

	/**
	 *
	 * @param purchasableCards
	 */
	public void chooseCardToBuy(List<Card> purchasableCards) {
		FrontView.getInstance().outputChooseCardToBuy(purchasableCards);
		Card choosencard = null;
		do {
			Card choosenCard = FrontView.getInstance().inputChooseCardToBuy();
			int availableCoins = Adventurer.getInstance().getCoins();
			if (availableCoins > choosencard.getCoinCost() && !(choosencard==null))
				Adventurer.getInstance().buyACard(choosenCard);
		} while (!(choosencard == null));
	}
}