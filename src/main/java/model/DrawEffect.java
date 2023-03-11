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
import java.util.ArrayList;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@DiscriminatorValue("DrawEffect")
public class DrawEffect extends Effect implements Serializable {
	
	@Column(name="NumberCards", nullable=true, length=10)
	private int numberCards;



	public DrawEffect() {
	}

	public DrawEffect(int numberCards) {
		this.numberCards = numberCards;
	}

	/**
	 * set new numberCards (number of card that the effect allows to draw at the Adventurer)
	 * @param value new numberCards
	 */
	public void setNumberCards(int value) {
		this.numberCards = value;
	}

	/**
	 * @return numberCards (number of card that the effect allows to draw at the Adventurer)
	 */
	public int getNumberCards() {
		return numberCards;
	}

	/**
	 * add to Adventurer Deck "numberCards" cards
	 * @param battleField field that contain all the variable that an effect could change
	 * @param target id of the target who will be changed in this effect or in the next
	 */
	public void activateEffect(BattleRoom battleField, ArrayList<Integer> target) {
		Adventurer.getInstance().drawCards(this.numberCards);
		if(this.nextEffect != null)
			this.nextEffect.activateEffect(battleField,target);
	}
	
	public String toString() {
		if(this.nextEffect != null)
			return "draw:"+this.numberCards+","+this.nextEffect;
		else
			return "draw:"+this.numberCards;
	}

	public String var_dump(){
		return super.var_dump()+" numberCards:"+this.numberCards;
	}
	
}
