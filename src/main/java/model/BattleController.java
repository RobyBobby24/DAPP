package model;

import view.FrontView;

import java.util.List;

public class BattleController {

	private static BattleController instance;


	private BattleController() {

	}

	public static BattleController getInstance() {
		if(BattleController.instance == null){
			BattleController.instance = new BattleController();
		}
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
			e.printStackTrace();
			System.out.println(e.getMessage()+" "+e.getStackTrace()[0]+" ");
			FrontView.getInstance().outputError("la carta selezionata non è disponibile!!!");
			if(FrontView.getInstance().inputError())this.playCard();
		}
	}

	public void passTurn() {
		try{
			BattleRoom battleRoom = (BattleRoom) DungeonMap.getInstance().getCurrentRoom();
			battleRoom.passTurn();
		}
		catch(Exception e){
			FrontView.getInstance().outputError("non siamo riusciti a passare il turno!!!");
			if(FrontView.getInstance().inputError())this.passTurn();
		}
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
			if(FrontView.getInstance().inputError())this.nextBattleOp();
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
			if(FrontView.getInstance().inputError()) this.chooseTarget();
		}
	}

	public Monster takeTarget() {
		return FrontView.getInstance().inputChooseTarget();
	}

	public void showBattleResult(boolean haveYouWon , int rewardCoins){
		try {
			if (haveYouWon) FrontView.getInstance().outputYouWon(rewardCoins);
			else FrontView.getInstance().outputYouLost();
		}
		catch( Exception e){
			FrontView.getInstance().outputError("l'operazione non è andata a buon fine");
			if(FrontView.getInstance().inputError()) this.showBattleResult(haveYouWon, rewardCoins);
		}
	}

	public void notifyLastBattle(){
		try{
			FrontView.getInstance().outputLastBattle();
		}
		catch (Exception e){
			FrontView.getInstance().outputError("l'operazione non è andata a buon fine");
			if(FrontView.getInstance().inputError()) this.notifyLastBattle();
		}
	}



}