package model;

public class TreasureController {

	private static TreasureController instance;
	private boolean endGame;

	public boolean isEndGame() {
		return this.endGame;
	}

	public void setEndGame(boolean endGame) {
		this.endGame = endGame;
	}

	private TreasureController() {
		// TODO - implement TreasureController.TreasureController
		throw new UnsupportedOperationException();
	}

	public static TreasureController getInstance() {
		return this.instance;
	}

	public void chooseTreasure() {
		// TODO - implement TreasureController.chooseTreasure
		throw new UnsupportedOperationException();
	}

}