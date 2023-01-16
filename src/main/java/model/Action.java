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
@Table(name="Action")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Action implements Serializable {
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	//@GeneratedValue(generator="MODEL_ACTION_ID_GENERATOR")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@org.hibernate.annotations.GenericGenerator(name="MODEL_ACTION_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@ManyToOne(targetEntity= Action.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="ActionID", referencedColumnName="ID") }, foreignKey=@ForeignKey(name="FKAction727678"))	
	protected Action nextAction;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setNextAction(Action value) {
		this.nextAction = value;
	}
	
	public Action getNextAction() {
		return nextAction;
	}
	
	public abstract void activeAction(Monster monster);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
