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
import java.lang.reflect.InvocationTargetException;

@Entity
@org.hibernate.annotations.Proxy(lazy=true)
@Table(name="Adventurer")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Discriminator", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("Adventurer")
public abstract class Adventurer implements Serializable {

	@Column(name="ID", nullable=false, length=10)
	@Id
	@GeneratedValue(generator="MODEL_ADVENTURER_ID_GENERATOR")
	@org.hibernate.annotations.GenericGenerator(name="MODEL_ADVENTURER_ID_GENERATOR", strategy="native")
	protected int ID;

	@OneToOne(targetEntity= Hp.class, fetch=FetchType.EAGER)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK, org.hibernate.annotations.CascadeType.DELETE})
	@JoinColumns(value={ @JoinColumn(name="HpID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="FKAdventurer647017"))
	protected Hp hp;

	@OneToOne(targetEntity= Deck.class, fetch=FetchType.EAGER)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
	@JoinColumns(value={ @JoinColumn(name="DeckID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="FKAdventurer341408"))
	protected Deck deck;

	@OneToOne(targetEntity= Adventurer.class, fetch=FetchType.EAGER)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK, org.hibernate.annotations.CascadeType.DELETE})
	@JoinColumns(value={ @JoinColumn(name="ID", referencedColumnName="ID", nullable=false) })
	protected static Adventurer instance;

	@Transient
	protected AdventurerState currentState;






	protected Adventurer() {

	}

	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}

	public void setProtection(int value){
		this.currentState.setProtection(value);
	}

	public int getProtection() {
		return this.currentState.getProtection();
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

	public int getEnergyPoint(){
		return this.currentState.getEnergyPoint();
	}

	public void setEnergyPoint(int numberOfEnergyPoint){
		this.currentState.setEnergyPoint(numberOfEnergyPoint);
	}
	

	
	public static Adventurer getInstance() {
		if(Adventurer.instance==null) {
			Adventurer.instance=AdventurerFactory.getInstance().getAdventurerInstance();
		}
		return Adventurer.instance;
	}
	
	public AdventurerState getCurrentState(){
		return this.currentState;
	}
	
	public abstract void setBattleState();

	public abstract void setNormalState();
	
	public void drawCards(int numberOfCards) {
		this.currentState.drawCards(numberOfCards);
	}
	
	private Deck getACopyOfDeck() {
		return this.deck.clone();
	}
	
	public Card getCardFromHand(int cardIndex) {
		return this.currentState.getCardFromHand(cardIndex);
	}
	
	public void addProtection(int protection) {
		this.currentState.addProtection(protection);
	}
	
	public void drawCards() {
		this.currentState.drawCards(5);
	}
	
	public void passTurn() {
		this.currentState.passTurn();
	}
	
	public void takeDamage(int damage) {
		this.currentState.takeDamage(damage,this);
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
