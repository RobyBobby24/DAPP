package model;

public class AdventurerTurn implements TurnState {

	private boolean endAdventurerTurn;

	public AdventurerTurn AdventurerTurn() {
		// TODO - implement AdventurerTurn.AdventurerTurn
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param battleRoom
	 */
	public void startTurn(BattleRoom battleRoom) {
		// TODO - implement AdventurerTurn.startTurn
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param battle
	 * @param monsterID
	 */
	public void notifyDeath(BattleRoom battle, int monsterID) {
		// TODO - implement AdventurerTurn.notifyDeath
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param battleRoom
	 * @param effectId
	 */
	public void performEffect(BattleRoom battleRoom, int effectId) {
		// TODO - implement AdventurerTurn.performEffect
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param end
	 */
	public void setEndAdventurerTurn(boolean end) {
		this.endAdventurerTurn = end;
	}

	/**
	 * 
	 * @param battleRoom
	 */
	public void passTurn(BattleRoom battleRoom) {
		// TODO - implement AdventurerTurn.passTurn
		throw new UnsupportedOperationException();
	}

}