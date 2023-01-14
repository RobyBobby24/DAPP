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
@Table(name="ProtectionAction")
public class ProtectionAction extends Action implements Serializable {
	public ProtectionAction() {
	}
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="MODEL_PROTECTIONACTION_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="MODEL_PROTECTIONACTION_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@Column(name="Protection", nullable=false, length=10)	
	private int protection;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setProtection(int value) {
		this.protection = value;
	}
	
	public int getProtection() {
		return protection;
	}
	
	public void activeAction(Monster monster) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
