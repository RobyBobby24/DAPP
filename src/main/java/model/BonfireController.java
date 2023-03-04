package model;

public class BonfireController {

	private static BonfireController instance;
	private boolean endGame;

	public boolean isEndGame() {
		return this.endGame;
	}

	public void setEndGame(boolean endGame) {
		this.endGame = endGame;
	}

	private BonfireController() {
		// TODO - implement BonfireController.BonfireController
		throw new UnsupportedOperationException();
	}

	public static BonfireController getInstance() {
		return BonfireController.instance;
	}

	public void skipRest() {
		// TODO - implement BonfireController.skipRest
		throw new UnsupportedOperationException();
	}

}