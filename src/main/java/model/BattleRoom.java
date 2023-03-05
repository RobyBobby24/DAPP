/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: rober(Universita degli Studi dell'Aquila)
 * License Type: Academic
 */
package model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BattleRoom implements Serializable,Room {

	//	Attribute!!!
	private List<Monster> monsters = new ArrayList<Monster>();

	public int getBattleReward() {
		return battleReward;
	}

	public void setBattleReward(int battleReward) {
		this.battleReward = battleReward;
	}

	private int battleReward;

	private int ended;

	private TurnState currentTurn;


	protected int ID;



//	Methods

	public BattleRoom() {
	}

	/**
	 * set new monsters (list of monsters in the room)
	 * @param value new monsters
	 */
	public void setMonsters(List value) {
		this.monsters = value;
		this.ended=this.monsters.size();
	}

	/**
	 * @return monsters (list of monsters in the room)
	 */
	public ArrayList<Monster> getMonsters() {
		try{
			return  (ArrayList<Monster>)monsters;
		}
		catch (Exception e){
			this.monsters = new ArrayList<Monster>(this.monsters);
			return (ArrayList<Monster>) this.monsters;
		}
	}

	@Override
	public void setID(int value) {
		this.ID=value;
	}

	@Override
	public int getID() {
		return 0;
	}

	/**
	 * start the operation that will be in the room
	 */
	public void enterRoom() {
		this.startBattle();
		this.playBattle();
	}


	/**
	 * @return ID (identifier of the instance also in DB)
	 */
	/*
	@Override
	public int getId() {
		return this.ID;
	}
	 */

	/**
	 * set new ID (identifier of the instance also in DB)
	 * @param id new ID
	 */
	/*
	@Override
	public void setId(int id) {
		this.ID=id;
	}
	 */


	/**
	 * start the operation that will be in the battle
	 */
	public void startBattle() {
		Adventurer.getInstance().setBattleState();
		this.currentTurn = new AdventurerTurn();
		this.ended=this.monsters.size();
	}

	/**
	 * run the battle passed between turn
	 */
	private void playBattle(){
		while (this.ended>0){
			this.startTurn();
			this.playTurn();
		}
	}

	/**
	 * start a turn
	 */
	public void startTurn() {
		this.currentTurn.startTurn(this);
	}

	/**
	 * play a turn
	 */
	public void playTurn() {
		this.currentTurn.playTurn(this);
	}

	/**
	 * pass tarn to Adventurer or monsters
	 */
	public void passTurn() {
		this.currentTurn.passTurn(this);
	}

	/**
	 * play a card or no op
	 * @param effectID id of the card
	 */
	public void performEffect(int effectID) {
		this.currentTurn.performEffect(this,effectID);
	}


	/**
	 * set new currentTurn (turn witch is actual run)
	 * @param currentTurn new currentTurn
	 */
	public void setCurrentTurn(TurnState currentTurn) {
		this.currentTurn=currentTurn;
	}

	/**
	 * @return true if battle is ended
	 */
	public boolean isBattleEnded() {
		if(this.ended>0)return false;
		else return true;
	}

	/**
	 * notify the death of a monster or the Adventurer
	 * @param monsterId monsterId or not use
	 */
	public void notifyDeath(int monsterId) {
		this.currentTurn.notifyDeath(this,monsterId);
	}

	/**
	 * ask the monster for choose a random action to play at the next monster turn
	 */
	public void setNextMonstersAction() {
		for (int i = 0; i < this.monsters.size(); i++) {
			Monster monster= this.monsters.get(i);
			Action action=monster.getRandomAction();
			monster.setNextAction(action);
		}
	}

	/**
	 * @param monsterIndex index of the moster tu return
	 * @return the monster whit position "monsterIndex" in the mosters list
	 */
	public Monster getMonsterByIndex(int monsterIndex) {
		return this.monsters.get(monsterIndex);
	}

	/**
	 * @param monsterId id of a monster
	 * @return the monster in the mosters list whit id "monsterId"
	 */
	public Monster getMonster(int monsterId) {
		for (int i = 0; i < this.monsters.size(); i++) {
			if(this.monsters.get(i).getID() == monsterId)
				return this.monsters.get(i);
		}
		return null;
	}

	/**
	 * @return ended (-1 if monsters has won 0 if adventurer has won other if the battle is not ended)
	 */
	public int getEnded() {
		return this.ended;
	}

	/**
	 * set new ended (-1 if monsters has won 0 if adventurer has won other if the battle is not ended)
	 * @param ended new ended
	 */
	public void setEnded(int ended) {
		this.ended=ended;
	}

	/**
	 * remove a monster and update ended
	 * @param monsterId ID of monster to remove
	 */
	public void removeMonster(int monsterId) {
		boolean removed=false;
		int i=0;
		while(i<this.monsters.size() && !removed){
			if(this.monsters.get(i).getID()==monsterId){
				this.monsters.remove(i);
				this.ended=this.ended-1;
				removed=true;
			}
			i=i+1;
		}
	}



	/**
	 * @param actualMonsterId monster of the previous monster that we want to take
	 * @return the moster after the monster whit "actualMonsterId" id in monsters list
	 */
	public Monster getNextMonster(int actualMonsterId) {
		boolean finded=false;
		int i=0;
		while(i<this.monsters.size() && !finded){
			if(this.monsters.get(i).getID()==actualMonsterId) finded=true;
			i=i+1;
		}
		if(i<this.monsters.size())return this.monsters.get(i);
		else return null;
	}

	/**
	 * @return the first monster of the list monsters
	 */
	public Monster getFirstMonster(){
		return this.monsters.get(0);
	}

	public String toString(){
		return this.getClass().getSimpleName();
	}

	public String var_dump(){
		return "ID:"+this.ID+" ended:"+this.ended+" monsters"+this.monsters+" currentTurn"+this.currentTurn;
	}
	
}
