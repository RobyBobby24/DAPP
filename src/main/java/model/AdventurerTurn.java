package model;

import java.util.ArrayList;

public class AdventurerTurn implements TurnState {

	private boolean endAdventurerTurn=false;

	public  AdventurerTurn() {

	}

	/**
	 * execute all the operation that will be at the start of an Adventurer turn
	 * @param battleRoom
	 */
	public void startTurn(BattleRoom battleRoom) {
		this.endAdventurerTurn = false;
		Adventurer.getInstance().startTurn();
		battleRoom.setNextMonstersAction();
	}

	/**
	 * notify the death of a monster to the battleRoom
	 * @param battle
	 * @param monsterID id of monster who has died
	 */
	public void notifyDeath(BattleRoom battle, int monsterID) {
		battle.removeMonster(monsterID);
		if(battle.getEnded() == 0)
			this.setEndAdventurerTurn(true);
	}

	/**
	 * play a card of the adventurer
	 * @param battleRoom
	 * @param effectId identifier of the card to play
	 */
	public void performEffect(BattleRoom battleRoom, int effectId) {
		Card cardToPlay = Adventurer.getInstance().getCardFromHand(effectId);
		if(cardToPlay.canBePlayed())
		{
			int numberOfTarget = cardToPlay.getNumberOfTarget();
			ArrayList<Integer> target = new ArrayList<Integer>();
			for (int i = 0; i < numberOfTarget; i++) {
				FrontController.getInstance().chooseTarget();
				target.add(FrontController.getInstance().takeTarget());
			}
			cardToPlay.activeEffect(battleRoom,target);
			Adventurer.getInstance().removeCardFromHand(cardToPlay);
		}
	}

	/**
	 * set new endAdventurerTurn (if true the turn is end)
	 * @param end new endAdventurerTurn
	 */
	public void setEndAdventurerTurn(boolean end) {
		this.endAdventurerTurn = end;
	}

	/**
	 * start all the operation of an Adventurer turn
	 * @param battleRoom
	 */
	public void playTurn(BattleRoom battleRoom){
		while (!this.endAdventurerTurn){
			FrontController.getInstance().nextBattleOp();
		}
	}

	/**
	 * pass turn to the monsters
	 * @param battleRoom
	 */
	public void passTurn(BattleRoom battleRoom) {
		Adventurer.getInstance().passTurn();
		this.setEndAdventurerTurn(true);
		battleRoom.setCurrentTurn(new MonsterTurn());
	}

}