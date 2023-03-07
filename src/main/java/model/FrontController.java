package model;

import java.util.ArrayList;
import java.util.List;

public class FrontController {

	private static FrontController instance;


	private FrontController() {
	}

	public static FrontController getInstance() {

		if (FrontController.instance == null)
			FrontController.instance = new FrontController();

		return FrontController.instance;
	}

	public void makeNewGame() {
		// TODO - implement FrontController.makeNewGame
		throw new UnsupportedOperationException();
	}

	public void chooseAdventurer() {
		// TODO - implement FrontController.chooseAdventurer
		throw new UnsupportedOperationException();
	}

	public void chooseRoom() {
		// TODO - implement FrontController.chooseRoom
		throw new UnsupportedOperationException();
	}

	public void playCard() {
		// TODO - implement FrontController.playCard
		throw new UnsupportedOperationException();
	}

	public void chooseTarget() {
		// TODO - implement FrontController.chooseTarget
		throw new UnsupportedOperationException();
	}

	public void passTurn() {
		// TODO - implement FrontController.passTurn
		throw new UnsupportedOperationException();
	}

	public void nextBattleOp() {
		// TODO - implement FrontController.nextBattleOp
		throw new UnsupportedOperationException();
	}

	public void setNickname() {
		// TODO - implement FrontController.setNickname
		throw new UnsupportedOperationException();
	}

	public void chooseOperation() {
		// TODO - implement FrontController.chooseOperation
		throw new UnsupportedOperationException();
	}

	public void chooseDifficulty() {
		// TODO - implement FrontController.chooseDifficulty
		throw new UnsupportedOperationException();
	}

	public void playGame() {
		// TODO - implement FrontController.playGame
		throw new UnsupportedOperationException();
	}

	public void restartGame() {
		// TODO - implement FrontController.restartGame
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param purchasableCards
	 */
	public void chooseCardToBuy(List<Card> purchasableCards) {
		// TODO - implement FrontController.chooseCardToBuy
		throw new UnsupportedOperationException();
	}

	public void skipRest() {
		// TODO - implement FrontController.skipRest
		throw new UnsupportedOperationException();
	}

	public void chooseTreasure() {
		// TODO - implement FrontController.chooseTreasure
		throw new UnsupportedOperationException();
	}

	public int takeTarget() {
		// TODO - implement FrontController.takeTarget
		throw new UnsupportedOperationException();
	}

}