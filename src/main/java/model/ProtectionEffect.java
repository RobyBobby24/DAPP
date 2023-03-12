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
@DiscriminatorValue("ProtectionEffect")
public class ProtectionEffect extends Effect implements Serializable {

	
	@Column(name="Protection", nullable=true, length=10)	
	private int protection;


	public ProtectionEffect() {
		this.target=false;
	}

	public ProtectionEffect(int protection) {
		this.protection = protection;
	}

	/**
	 * set protection (number of damage that the adventurer will be taken without lose hp)
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
	 * @param battleField field that contain all the variable that an effect could change
	 * @param target id of the target who will be changed in this effect or in the next
	 */
	public void activateEffect(BattleRoom battleField, ArrayList<Monster> target) {
		Adventurer.getInstance().addProtection(this.protection);
		if(this.nextEffect != null)
			this.nextEffect.activateEffect(battleField,target);
	}

	
	public String toString() {
		if(this.nextEffect!=null)return "protection:"+this.protection+", "+this.nextEffect;
		else return "protection:"+this.protection;
	}

	public String var_dump(){
		return super.var_dump()+" protection:"+this.protection;
	}
	
}
