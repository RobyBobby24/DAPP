package model;

public interface TurnState {

	/**
	 * execute all the operation that will be at the start of a turn
	 * @param battleRoom
	 */
	abstract void startTurn(BattleRoom battleRoom);


	/**
	 * start all the operation of the turn
	 * @param battleRoom
	 */
	abstract void playTurn(BattleRoom battleRoom);

	/**
	 * play a card or an action
	 * @param battleRoom
	 * @param effectId identifier of the card to play
	 */
	abstract void performEffect(BattleRoom battleRoom, int effectId);

	/**
	 * notify the death of a monster or the adventurer to the battleRoom
	 * @param battle
	 * @param monsterID id of monster who has died or no use
	 */
	abstract void notifyDeath(BattleRoom battle, int monsterID);

	/**
	 * pass turn to the other actor of the battle
	 * @param battleRoom
	 */
	abstract void passTurn(BattleRoom battleRoom);

}