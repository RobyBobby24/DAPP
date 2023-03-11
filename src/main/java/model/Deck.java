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
import org.hibernate.annotations.LazyCollectionOption;

import java.io.Serializable;
import java.util.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="deck")
public class Deck implements Serializable {

	
	@Column(name="ID", nullable=false, length=10)
	@Id	
	@GeneratedValue(generator="MODEL_DECK_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="MODEL_DECK_ID_GENERATOR", strategy="native")

	private int ID;


	/*
	@OneToMany(targetEntity= Card.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
	@JoinColumns({ @JoinColumn(name="DeckID", nullable=true) })
	@org.hibernate.annotations.IndexColumn(name="DeckIndex")
	@org.hibernate.annotations.LazyCollection(LazyCollectionOption.FALSE)
	 */
	@ManyToMany(targetEntity=model.Card.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
	@JoinTable(name="deck_card", joinColumns={ @JoinColumn(name="DeckID", referencedColumnName="ID", nullable=false) }, inverseJoinColumns={ @JoinColumn(name="CardID",referencedColumnName="ID", nullable=false) })
	@org.hibernate.annotations.IndexColumn(name="CardIndex")
	@org.hibernate.annotations.LazyCollection(LazyCollectionOption.FALSE)

	private List<Card> cards = new ArrayList<Card>();





	public Deck() {
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
	 * set new cards attribute (List of cards in the deck)
	 * @param value new cards attribute
	 */
	public void setCards(List<Card> value) {
		this.cards = value;
	}

	/**
	 * get and remove the number of card  specified as parameter from the Deck's attribute cards
	 * @param numberOfCards number of card to get and remove
	 * @return ArrayList composed by the cards got and removed from the Deck's attribute cards
	 */
	public ArrayList<Card> getAndRemoveCards(int numberOfCards){
		ArrayList<Card> result = new ArrayList<Card>();
		int i = 0;
		while( i < numberOfCards && this.cards.size() > 0){
			result.add(this.cards.remove(0));
			i = i + 1;
		}
		return result;
	}

	/**
	 * @param numberOfCards number of card to get
	 * @return ArrayList composed by the cards got and removed from the Deck's attribute cards
	 */
	public ArrayList<Card> getCards(int numberOfCards) {
		ArrayList<Card> result = new ArrayList<Card>();
		for (int i = 0; i < numberOfCards; i++) {
			result.add(this.cards.get(0));
		}
		return result;
	}

	/**
	 * @return ArrayList composed by the cards got from the Deck's attribute cards
	 */
	public ArrayList<Card> getCards() {
		try{
			return  (ArrayList<Card>)cards;
		}
		catch (Exception e){
			this.cards = new ArrayList<Card>(this.cards);
			return (ArrayList<Card>) this.cards;
		}
	}


	/**
	 * @return number of cards in the deck
	 */
	public int getNumberOfCards() {
		return this.cards.size();
	}

	/**
	 * add the card passed as parameter to the Deck's attribute cards
	 * @param card card to add to the Deck's attribute cards
	 */
	public void addCard(Card card) {
		this.cards.add(card);
	}

	/**
	 *  add the cards passed as parameter to the Deck's attribute cards
	 * @param cards cards to add to the Deck's attribute cards
	 */
	public void addCard(ArrayList<Card> cards) {
		this.cards.addAll(cards);
	}

	/**
	 * dispose the cards of deck in random sort
	 */
	public void shuffle(){
		Collections.shuffle(this.cards);
	}

	/**
	 * @return a copy of the object
	 */
	public Deck clone(){
		Deck result=new Deck();
		result.setCards(new ArrayList<>(this.cards));
		return result;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}

	public String var_dump(){
		return "ID:"+this.ID+" cards:"+this.getCards();
	}
	
}
