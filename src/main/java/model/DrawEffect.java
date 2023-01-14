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

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.io.Serializable;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@DiscriminatorValue("DrawEffect")
public class DrawEffect extends Effect implements Serializable {
	public DrawEffect() {
	}
	
	@Column(name="NumberCards", nullable=true, length=10)
	private int numberCards;
	
	public void setNumberCards(int value) {
		this.numberCards = value;
	}
	
	public int getNumberCards() {
		return numberCards;
	}
	
	public void activeEffect(BattleRoom battleField, int[] target) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public int numberOfTarget(int actualNumber) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return super.toString();
	}
	
}
