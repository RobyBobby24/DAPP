package model;

import view.FrontView;

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

	public void setEndBattle(boolean endBattle){
		PlayTheGame.getInstance().setEndGame(endBattle);
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

	public void showBattleResult(boolean haveYouWon , int rewardCoins){
		BattleController.getInstance().showBattleResult( haveYouWon , rewardCoins );
	}

	public void passTurn() {
		BattleRoom battleRoom = (BattleRoom) DungeonMap.getInstance().getCurrentRoom(); // cast necessario per il tipo ritornato
		battleRoom.passTurn();
	}

	public void nextBattleOp() {
		BattleController.getInstance().nextBattleOp();
	}

	public void notifyLastBattle(){
		BattleController.getInstance().notifyLastBattle();
	}

	public void setNickname() {
		PlayTheGame.getInstance().setNickname();
	}

	public void chooseOperation() {
		PlayTheGame.getInstance().chooseOperation();
	}

	public void chooseDifficulty() {
		PlayTheGame.getInstance().chooseDifficulty();
	}

	public void playGame() {
		PlayTheGame.getInstance().playGame();
	}

	public void restartGame() {
		PlayTheGame.getInstance().restartGame();
	}

	/**
	 * 
	 * @param purchasableCards
	 */
	public void chooseCardToBuy(List<Card> purchasableCards) throws Exception {
		MerchantController.getInstance().chooseCardToBuy(purchasableCards);
	}

	public void skipRest(int percentage) {
		BonfireController.getInstance().skipRest(percentage);
	}

	public void chooseTreasure(List<Treasure> treasures) {
		try {
			TreasureController.getInstance().chooseTreasure(treasures);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public int takeTarget() {
		return BattleController.getInstance().takeTarget();
	}

}