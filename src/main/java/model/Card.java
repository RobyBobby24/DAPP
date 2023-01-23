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
@Table(name="card")
public class Card implements Serializable {

	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="MODEL_CARD_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="MODEL_CARD_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@Column(name="EnergyCost", nullable=false, length=10)	
	private int energyCost;
	
	@Column(name="Description", nullable=false, length=255)
	private String description="";




	@OneToOne(targetEntity= Effect.class, fetch=FetchType.EAGER)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK, org.hibernate.annotations.CascadeType.DELETE})
	@JoinColumns(value = { @JoinColumn(name="EffectID",referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="FKEffect1"))
	private Effect effect;




	public Card() {
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
	 * set new energyCost (cost for the Adventurer to activate the effects of the card)
	 * @param value new energyCost
	 */
	public void setEnergyCost(int value) {
		this.energyCost = value;
	}


	/**
	 * @return energyCost (cost for the Adventurer to activate the effects of the card)
	 */
	public int getEnergyCost() {
		return energyCost;
	}

	/**
	 * set new effect (the behavior of the card when activated)
	 * @param effect new effect
	 */
	public void setEffect(Effect effect){
		this.effect=effect;
	}

	/**
	 * @return effect (the behavior of the card when activated)
	 */
	public Effect getEffect(){
		return this.effect;
	}

	/**
	 * set new description (explanation of the card effects behavior)
	 * @param value new description
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * @return description (explanation of the card effects behavior)
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @return true if the Adventure has enough energy point to play the card
	 */
	public boolean canBePlayed() {
		if(Adventurer.getInstance().getEnergyPoint()>=this.energyCost)return true;
		else return false;
	}

	/**
	 * @return numberOfTarget (number of effects card that need a target to be performed)
	 */
	public int getNumberOfTarget() {
		return this.effect.numberOfTarget(0);
	}

	/**
	 * execute the effect of the card
	 * @param battleField field that could be change by the effects
	 * @param target id of the target to change
	 */
	public void activeEffect(BattleRoom battleField, ArrayList<Integer> target) {
		this.effect.activeEffect(battleField,target);
		int newEnergyPoint=Adventurer.getInstance().getEnergyPoint()-this.energyCost;
		Adventurer.getInstance().setEnergyPoint(newEnergyPoint);
	}
	
	public String toString() {
		return "Effect="+this.effect+", Description="+this.description;
	}

	public String var_dump() {
		return "id:"+this.ID+" energyCost:"+this.energyCost+" effect:"+this.effect+" description"+this.description;
	}
	
}
