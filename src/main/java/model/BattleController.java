package model;

public class BattleController {

	private static BattleController instance;
	private boolean endGame;

	public boolean isEndGame() {
		return this.endGame;
	}

	public void setEndGame(boolean endGame) {
		this.endGame = endGame;
	}

	private BattleController() {
		// TODO - implement BattleController.BattleController
		throw new UnsupportedOperationException();
	}

	public void playCard() {
		// TODO - implement BattleController.playCard
		throw new UnsupportedOperationException();
	}

	public void passTurn() {
		// TODO - implement BattleController.passTurn
		throw new UnsupportedOperationException();
	}

	public void nextBattleOp() {
		// TODO - implement BattleController.nextBattleOp
		throw new UnsupportedOperationException();
	}

	public void chooseTarget() {
		// TODO - implement BattleController.chooseTarget
		throw new UnsupportedOperationException();
	}

	public int takeTarget() {
		// TODO - implement BattleController.takeTarget
		throw new UnsupportedOperationException();
	}

	public static BattleController getInstance() {
		return BattleController.instance;
	}

}