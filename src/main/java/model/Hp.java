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

	/**
	 * set new ID (identifier of the instance also in DB)
	 * @param value new ID
	 */
	private void setID(int value) {
		this.ID = value;
	}

	/**
	 * @return ID (identifier of the instance also in DB)
	 */
	public int getID() {
		return ID;
	}

	/**
	 * increase or decrease of "numberOfHp" the currentHp
	 * @param numberOfHp number of Hp to add
	 */
	public void addCurrentHp(int numberOfHp) {
		if(this.currentHp+numberOfHp>this.maxHp) this.currentHp=this.maxHp;
		else if (this.currentHp+numberOfHp<0) this.currentHp=0;
		else this.currentHp=this.currentHp+numberOfHp;
	}

	/**
	 * set new currentHp (number of damage that could be lost without die)
	 * @param value new currentHp
	 */
	public void setCurrentHp(int value) throws Exception {
		if(value>this.maxHp || value<0) throw new Exception("currentHp must be minors than maxHp and greater of 0");
		this.currentHp = value;
	}

	/**
	 * set currentHp=maxHp
	 */
	public void resetCurrentHp(){
		this.currentHp=this.maxHp;
	}

	/**
	 * @return currentHp (number of damage that could be lost without die)
	 */
	public int getCurrentHp() {
		return currentHp;
	}

	/**
	 * set new maxHp (max value of currentHp)
	 * @param value new maxHp
	 */
	public void setMaxHp(int value) throws Exception {
		if(value<this.currentHp) throw new Exception("maxHp must be greater than maxHp");
		this.currentHp = value;
		this.maxHp = value;
	}

	/**
	 * @return maxHp (max value of currentHp)
	 */
	public int getMaxHp() {
		return maxHp;
	}
	
	public String toString() {
		return this.currentHp+"/"+this.maxHp;
	}

	public String var_dump(){
		return "ID:"+this.ID+" currentHp:"+this.currentHp+" maxHp:"+this.maxHp;
	}
	
}
