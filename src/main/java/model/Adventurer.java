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
import java.util.List;

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

	protected static Adventurer instance;

	@Transient
	protected AdventurerState currentState;






	protected Adventurer() {

	}

	/**
	 * set new ID (identifier of object used also in DB)
	 * @param value new ID
	 */
	private void setID(int value) {
		this.ID = value;
	}

	/**
	 * @return ID (identifier of object used also in DB)
	 */
	public int getID() {
		return ID;
	}

	/**
	 * set new protection (number of damage that adventurer could take without lose hp)
	 * @param value new protection
	 */
	public void setProtection(int value){
		this.currentState.setProtection(value);
	}

	/**
	 * @return protection (number of damage that adventurer could take without lose hp)
	 */
	public int getProtection() {
		return this.currentState.getProtection();
	}

	/**
	 * set new Deck (list of card that the Adventurer has)
	 * @param value new Deck
	 */
	public void setDeck(Deck value) {
		this.deck = value;
	}

	/**
	 * @return Deck (list of card that the Adventurer has)
	 */
	public Deck getDeck() {
		return deck;
	}

	/**
	 * set new Hp (number of object that the adventurer can take without die)
	 * @param value new Hp
	 */
	public void setHp(Hp value) {
		this.hp = value;
	}

	/**
	 * @return Hp (number of object that the adventurer can take without die)
	 */
	public Hp getHp() {
		return hp;
	}

	/**
	 * @return energyPoint (a sort of money useful for play the cards)
	 */
	public int getEnergyPoint(){
		return this.currentState.getEnergyPoint();
	}

	/**
	 * set new energyPoint (a sort of money useful for play the cards)
	 * @param numberOfEnergyPoint new energyPoint
	 */
	public void setEnergyPoint(int numberOfEnergyPoint){
		this.currentState.setEnergyPoint(numberOfEnergyPoint);
	}


	/**
	 * @return the unique instance of the Adventurer
	 */
	public static Adventurer getInstance() {
		if(Adventurer.instance==null) {
			Adventurer.instance=AdventurerFactory.getInstance().getAdventurerInstance();
		}
		return Adventurer.instance;
	}

	/**
	 * @return the currentState based on witch depend on the effect of the Adventurer operation
	 */
	public AdventurerState getCurrentState(){
		return this.currentState;
	}

	/**
	 * set currentState to BattleState (behavior of Adventurer during a battle)
	 */
	public abstract void setBattleState();

	/**
	 * set currentState to CurrentState (behavior of Adventurer out of all Room)
	 */
	public abstract void setNormalState();

	/**
	 * add card to the hand from the deck
	 * @param numberOfCards number of cards to draw
	 */
	public void drawCards(int numberOfCards) {
		this.currentState.drawCards(numberOfCards);
	}

	/**
	 * @return a copy of Deck (list of card that the Adventurer has)
	 */
	private Deck getACopyOfDeck() {
		return this.deck.clone();
	}

	/**
	 * @param cardIndex index of the card in the hand
	 * @return a card token from the hand
	 */
	public Card getCardFromHand(int cardIndex) {
		return this.currentState.getCardFromHand(cardIndex);
	}

	public List<Card> getCardsFromHand(){
		return this.currentState.getCardsFromHand();
	}

	/**
	 * add "protection" point to the protection
	 * @param protection number of protection point to add
	 */
	public void addProtection(int protection) {
		this.currentState.addProtection(protection);
	}

	/**
	 * take the number of card to take at the start turn from deck and put they to the hand
	 */
	public void drawCards() {
		this.currentState.drawCards(5);
	}

	/**
	 * do all the action that deck,discardPile ,hand and energyPoint need at the end of the Adventurer turn
	 */
	public void passTurn() {
		this.currentState.passTurn();
	}

	/**
	 * do all the action that deck,discardPile ,hand and energyPoint need at the start of the Adventurer turn
	 */
	public void startTurn(){
		this.currentState.startTurn();
	}

	/**
	 * decrease currentHp
	 * @param damage number of point to decrease
	 */
	public void takeDamage(int damage) {
		this.currentState.takeDamage(damage,this);
	}
	
	public String toString() {
		return String.valueOf(getID());
	}

	public String var_dump(){
		return "ID:"+this.ID+" hp:"+this.hp+" deck"+this.deck+" currentState:"+this.currentState+" instance:"+Adventurer.instance;
	}
	
}
