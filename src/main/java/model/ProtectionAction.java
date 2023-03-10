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
@Table(name="protectionaction")
public class ProtectionAction extends Action implements Serializable {

	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="MODEL_PROTECTIONACTION_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="MODEL_PROTECTIONACTION_ID_GENERATOR", strategy="native")	

	private int ID;
	
	@Column(name="Protection", nullable=false, length=10)	

	private int protection;


	public ProtectionAction() {
	}
	public ProtectionAction( int protection) {
		this.protection = protection;
	}
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
	 * set new protection (number of damage that the adventurer will be taken without lose hp)
	 * @param value new protection
	 */
	public void setProtection(int value) {
		this.protection = value;
	}

	/**
	 * @return protection (number of damage that the adventurer will be taken without lose hp)
	 */
	public int getProtection() {
		return protection;
	}

	/**
	 * after that the Adventurer can take "protection" damage without lose hp
	 * @param monster monster who activated the action and take the protection
	 */
	public void activateAction(Monster monster) {

		monster.addProtection(this.protection);
	}

	public ProtectionAction clone(){
		return new ProtectionAction(this.getProtection());
	}



	public String toString() {
		if(this.nextAction!=null)return "protection:"+this.protection+", "+this.nextAction;
		else return "protection:"+this.protection;
	}

	public String var_dump(){
		return "ID:"+this.getID()+" protection:"+this.protection+" nextAction:"+this.nextAction;
	}
	
}
