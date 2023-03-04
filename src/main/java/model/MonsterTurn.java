package model;

public class MonsterTurn implements TurnState {

	private Monster currentMonster;


	public  MonsterTurn() {

	}

	/**
	 * no op
	 * @param battleRoom
	 * @param effectId
	 */
	public void performEffect(BattleRoom battleRoom, int effectId) {

	}

	/**
	 * notify the death of the adventurer to the battleRoom
	 * @param battle
	 * @param monsterID no use
	 */
	public void notifyDeath(BattleRoom battle, int monsterID) {
		battle.setEnded(-1);
	}

	/**
	 * set the current monster to the first or to the next
	 * @param battleRoom
	 */
	public void startTurn(BattleRoom battleRoom) {
		if(this.currentMonster == null){
			this.setCurrentMonster(battleRoom.getFirstMonster());
		}
		else{
			this.setCurrentMonster(battleRoom.getNextMonster(this.currentMonster.getID()));
		}
	}


	/**
	 * start all the operation of an Adventurer turn
	 * @param battleRoom
	 */
	@Override
	public void playTurn(BattleRoom battleRoom) {
		if(this.currentMonster != null){
			this.currentMonster.getNextAction().activateAction(this.currentMonster);
		}
		else
			battleRoom.passTurn();
	}

	/**
	 * set battleRoom turn to adventurerTurn
	 * @param battleRoom
	 */
	public void passTurn(BattleRoom battleRoom) {
		battleRoom.setCurrentTurn(new AdventurerTurn());
	}

	/**
	 * set new actualMonster (the monster who are playing the turn)
	 * @param monster
	 */
	public void setCurrentMonster(Monster monster) {
		this.currentMonster =monster;
	}

}