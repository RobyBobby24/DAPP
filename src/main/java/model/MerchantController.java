package model;

public class MerchantController {

	private static MerchantController instance;
	private boolean endGame;

	public boolean isEndGame() {
		return this.endGame;
	}

	public void setEndGame(boolean endGame) {
		this.endGame = endGame;
	}

	private MerchantController() {
		// TODO - implement MerchantController.MerchantController
		throw new UnsupportedOperationException();
	}

	public static MerchantController getInstance() {
		return this.instance;
	}

	/**
	 * 
	 * @param purchasableCards
	 */
	public void chooseCardToBuy(Card[] purchasableCards) {
		// TODO - implement MerchantController.chooseCardToBuy
		throw new UnsupportedOperationException();
	}

}