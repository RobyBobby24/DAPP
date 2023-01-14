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
@Table(name="Deck")
public class Deck implements Serializable {
	public Deck() {
	}
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="MODEL_DECK_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="MODEL_DECK_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@OneToMany(targetEntity= Card.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="DeckID", nullable=true) })	
	@org.hibernate.annotations.IndexColumn(name="DeckIndex")	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.List cards = new ArrayList();






	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	private void setCards(ArrayList value) {
		this.cards = value;
	}
	
	private ArrayList<Card> getCards() {
		return (ArrayList<Card>) cards;
	}
	

	public int getNumberOfCards() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void addCard(Card card) {
		//TODO: Implement Method
		this.cards.add(card);
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
