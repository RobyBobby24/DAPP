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

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="BattleRoom")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("BattleRoom")
@PrimaryKeyJoinColumn(name="RoomID", referencedColumnName="ID")
public class BattleRoom extends Room implements Serializable {

	//	Attribute!!!
	@OneToMany(targetEntity= Monster.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="BattleRoomRoomID", nullable=false) })
	@org.hibernate.annotations.IndexColumn(name="BattleRoomIndex")	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private ArrayList monsters = new ArrayList();


	@Transient
	private int ended;

	@Transient
	private TurnState currentTurn;





//	Methods

	public BattleRoom() {
	}

	public void setMonsters(ArrayList value) {
		this.monsters = value;
	}
	
	public ArrayList getMonsters() {
		return monsters;
	}
	
	public void enterRoom() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}

	@Override
	public int getId() {
		return 0;
	}

	@Override
	public void setId(int id) {

	}

	public BattleRoom(int Id, ArrayList<Monster> monsters) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void startTurn() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public TurnState getCurrentTurn() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void setCurrentTurn(TurnState currentTurn) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void startBattle() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public boolean isBattleEnded() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void notifyDeath(int idMonster) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void setNextMonstersAction() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void performEffect(int effectID) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public Monster getMonster(int monsterID) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public int getEnded() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void setEnded(int ended) {
		//TODO: Implement Method
		this.ended=ended;
	}
	
	public void removeMonster(int monsterId) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void passTurn() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public Monster getNextMonster(int actualMonsterId) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return super.toString();
	}
	
}
