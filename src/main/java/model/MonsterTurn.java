package model;

public class MonsterTurn implements TurnState {

	private Monster actualMonster;


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
		if(this.actualMonster == null){
			this.setActualMonster(battleRoom.getFirstMonster());
		}
		else{
			this.setActualMonster(battleRoom.getNextMonster(this.actualMonster.getID()));
		}
	}


	/**
	 * start all the operation of an Adventurer turn
	 * @param battleRoom
	 */
	@Override
	public void playTurn(BattleRoom battleRoom) {
		if(this.actualMonster != null){
			this.actualMonster.getNextAction().activeAction(this.actualMonster);
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
	public void setActualMonster(Monster monster) {
		this.actualMonster=monster;
	}

}