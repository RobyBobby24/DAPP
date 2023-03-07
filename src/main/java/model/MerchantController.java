package model;

import java.util.List;

public class MerchantController {

	private static MerchantController instance;


	private MerchantController() {
		// TODO - implement MerchantController.MerchantController
		throw new UnsupportedOperationException();
	}

	public static MerchantController getInstance() {
		return MerchantController.instance;
	}

	/**
	 * 
	 * @param purchasableCards
	 */
	public void chooseCardToBuy(List<Card> purchasableCards) {
		// TODO - implement MerchantController.chooseCardToBuy
		throw new UnsupportedOperationException();
	}

}