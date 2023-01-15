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
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Hp")
public class Hp implements Serializable {
	public Hp() {
	}
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="MODEL_HP_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="MODEL_HP_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@Column(name="CurrentHp", nullable=false, length=10)	
	private int currentHp;
	
	@Column(name="MaxHp", nullable=false, length=10)	
	private int maxHp;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}

	public void addCurrentHp(int numberOfHp)
	{
		this.currentHp=this.currentHp+numberOfHp;
	}
	
	public void setCurrentHp(int value) {
		this.currentHp = value;
	}
	
	public int getCurrentHp() {
		return currentHp;
	}
	
	public void setMaxHp(int value) {
		this.maxHp = value;
	}
	
	public int getMaxHp() {
		return maxHp;
	}
	
	public void loseHp(int hit) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
