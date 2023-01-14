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
@Table(name="Monster")
public class Monster implements Serializable {
	public Monster() {
	}
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="MODEL_MONSTER_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="MODEL_MONSTER_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@ManyToOne(targetEntity= Hp.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK, org.hibernate.annotations.CascadeType.DELETE})	
	@JoinColumns(value={ @JoinColumn(name="HpID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="FKMonster438639"))	
	private Hp hp;
	
	@Column(name="Name", nullable=false, length=255)
	private String name;
	
	@Column(name="Type", nullable=false, length=255)
	private String type;
	
	@Column(name="ChallengeRating", nullable=false)
	private Float challengeRating;
	
	@Column(name="Protection", nullable=false, length=10)	
	private int protection;
	
	@OneToMany(targetEntity= Action.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="MonsterID", nullable=false) })	
	@org.hibernate.annotations.IndexColumn(name="MonsterIndex")	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private ArrayList availableActions = new ArrayList();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setType(String value) {
		this.type = value;
	}
	
	public String getType() {
		return type;
	}
	
	public void setChallengeRating(float value) {
		setChallengeRating(Float.valueOf(value));
	}
	
	public void setChallengeRating(Float value) {
		this.challengeRating = value;
	}
	
	public Float getChallengeRating() {
		return challengeRating;
	}
	
	public void setProtection(int value) {
		this.protection = value;
	}
	
	public int getProtection() {
		return protection;
	}
	
	private void setAvailableActions(ArrayList value) {
		this.availableActions = value;
	}
	
	private ArrayList getAvailableActions() {
		return availableActions;
	}

	public void setHp(Hp value) {
		this.hp = value;
	}
	
	public Hp getHp() {
		return hp;
	}
	
	@Transient	
	private Action nextAction;
	
	public Action getNextAction() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void setNextAction(Action nextAction) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public Action getRandomAction() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public int getId() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void setId(int id) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void takeDamage(int damage) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void addProtection(int protection) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}

	public void addActionToAvailable(Action action){
		this.availableActions.add(action);
	}
	
}
