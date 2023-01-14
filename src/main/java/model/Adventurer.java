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
@Entity
@org.hibernate.annotations.Proxy(lazy=true)
@Table(name="Adventurer")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Discriminator", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("Adventurer")
public abstract class Adventurer implements Serializable {
	protected Adventurer() {

	}
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="MODEL_ADVENTURER_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="MODEL_ADVENTURER_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@OneToOne(targetEntity= Hp.class, fetch=FetchType.EAGER)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK, org.hibernate.annotations.CascadeType.DELETE})	
	@JoinColumns(value={ @JoinColumn(name="HpID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="FKAdventurer647017"))	
	private Hp hp;
	
	@OneToOne(targetEntity= Deck.class, fetch=FetchType.EAGER)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="DeckID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="FKAdventurer341408"))	
	private Deck deck;
	
	@Column(name="Protection", nullable=false, length=10)	
	private int protection;

	@Transient
	private static Adventurer instance;

	@Transient
	private AdventurerState currentState;









	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setProtection(int value) {
		this.protection = value;
	}
	
	public int getProtection() {
		return protection;
	}
	
	public void setDeck(Deck value) {
		this.deck = value;
	}
	
	public Deck getDeck() {
		return deck;
	}
	
	public void setHp(Hp value) {
		this.hp = value;
	}
	
	public Hp getHp() {
		return hp;
	}
	

	
	public static Adventurer getInstance() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public abstract int getId();
	
	public abstract void setId(int id);
	
	public abstract AdventurerState getCurrentState();
	
	public abstract void setBattleState();
	
	public void drawCards(int numberOfCards) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	private Deck getACopyOfDeck() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public Card getCardFromHand(int cardID) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void addProtection(int protection) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void drawCards() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void passTurn() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void takeDamage(int damage) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
