package model;

public interface TurnState {

	/**
	 * 
	 * @param battleRoom
	 */
	abstract void startTurn(BattleRoom battleRoom);

	/**
	 * 
	 * @param battleRoom
	 * @param effectId
	 */
	abstract void performEffect(BattleRoom battleRoom, int effectId);

	/**
	 * 
	 * @param battle
	 * @param monsterID
	 */
	abstract void notifyDeath(BattleRoom battle, int monsterID);

	/**
	 * 
	 * @param battleRoom
	 */
	abstract void passTurn(BattleRoom battleRoom);

}