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
		PlayTheGame.getInstance().makeNewGame();
	}

	public void chooseAdventurer() {
		PlayTheGame.getInstance().chooseAdventurer();
	}

	public void chooseRoom() {
		PlayTheGame.getInstance().chooseRoom();
	}

	public void playCard() {
		BattleController.getInstance().playCard();
	}

	public void chooseTarget() {
		BattleController.getInstance().chooseTarget();
	}

	public void passTurn() {
		BattleRoom battleRoom = (BattleRoom) DungeonMap.getInstance().getCurrentRoom(); // cast necessario per il tipo ritornato
		battleRoom.passTurn();
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
		return BattleController.getInstance().takeTarget();
	}

}