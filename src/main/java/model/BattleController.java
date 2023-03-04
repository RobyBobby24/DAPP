package model;

import view.FrontView;

import java.util.List;

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

	public static BattleController getInstance() {
		return BattleController.instance;
	}

	/**
	 * play the card chosen
	 */
	public void playCard() {
		try{
			List<Card> cards = Adventurer.getInstance().getCardsFromHand();
			BattleRoom battleRoom = (BattleRoom) DungeonMap.getInstance().getCurrentRoom();
			FrontView.getInstance().outputPlayCard(cards,Adventurer.getInstance(),battleRoom);
			battleRoom.performEffect(FrontView.getInstance().inputPlayCard());
		}
		catch (Exception e){
			FrontView.getInstance().outputError("la carta selezionata non è disponibile!!!");
			this.playCard();
		}
	}

	public void passTurn() {
		// TODO - implement BattleController.passTurn
		throw new UnsupportedOperationException();
	}

	/**
	 * choose next battle operation
	 */
	public void nextBattleOp() {
		try{
			BattleRoom battleRoom = (BattleRoom) DungeonMap.getInstance().getCurrentRoom();
			FrontView.getInstance().outputChooseBattleOp(Adventurer.getInstance(),battleRoom);
			String operation=FrontView.getInstance().inputChooseBattleOp();//input
			if(operation.equals("pass-turn"))
				this.passTurn();
			else if (operation.equals("play-card"))
				this.playCard();
			else
				throw new Exception("operation selected do not exist");
		}
		catch (Exception e){
			FrontView.getInstance().outputError("l'operazione selezionata non è supportata!!!");
			this.nextBattleOp();
		}

	}

	public void chooseTarget() {
		try{
			BattleRoom room = (BattleRoom) DungeonMap.getInstance().getCurrentRoom();
			List<Monster> monsters = room.getMonsters();
			FrontView.getInstance().outputChooseTarget(monsters);
		}
		catch (Exception e){
			FrontView.getInstance().outputError("il target selezionato non è valido!!!");
		}
	}

	public int takeTarget() {
		return FrontView.getInstance().inputChooseTarget();
	}



}