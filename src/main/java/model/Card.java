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
@Table(name="Card")
public class Card implements Serializable {
	public Card() {
	}
	
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
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setEnergyCost(int value) {
		this.energyCost = value;
	}

	public void setEffect(Effect effect){
		this.effect=effect;
	}

	public Effect getEffect(){
		return this.effect;
	}
	
	public int getEnergyCost() {
		return energyCost;
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return description;
	}

	

	

	public boolean canBePlayed() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public int getTarget() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void activeEffect(BattleRoom battleField, int[] target) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}

	public String var_dump() {
		return "id:"+this.ID+" energyCost:"+this.energyCost+" effect:"+this.effect+" description"+this.description;
	}
	
}
