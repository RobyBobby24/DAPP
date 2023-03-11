package model;

public interface TurnState {

	/**
	 * execute all the operation that will be at the start of a turn
	 * @param battleRoom battleRoom in input
	 */
	abstract void startTurn(BattleRoom battleRoom);


	/**
	 * start all the operation of the turn
	 * @param battleRoom battleRoom in input
	 */
	abstract void playTurn(BattleRoom battleRoom);

	/**
	 * play a card or an action
	 *
	 * @param battleRoom battleRoom in input
	 * @param cardToPlay identifier of the card to play
	 */
	abstract void performEffect(BattleRoom battleRoom, Card cardToPlay);

	/**
	 * notify the death of a monster or the adventurer to the battleRoom
	 * @param battleRoom battleRoom in input
	 * @param monsterID id of monster who has died or no use
	 */
	abstract void notifyDeath(BattleRoom battleRoom, int monsterID);

	/**
	 * pass turn to the other actor of the battle
	 * @param battleRoom battleRoom in input
	 */
	abstract void passTurn(BattleRoom battleRoom);

}