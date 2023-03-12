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
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.io.Serializable;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
public class DamageAction extends Action implements Serializable {
	public DamageAction() {
	}
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="MODEL_DAMAGEACTION_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="MODEL_DAMAGEACTION_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@Column(name="Damage", nullable=false, length=10)	
	private int damage;

	public DamageAction(int damage) {
		this.damage = damage;
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
	 * set new damage (hp that the effect take away by the adventurer)
	 * @param value new damage
	 */
	public void setDamage(int value) {
		this.damage = value;
	}

	/**
	 * @return damage (hp that the effect take away by the adventurer)
	 */
	public int getDamage() {
		return damage;
	}

	/**
	 * take away the hp to the Adventurer
	 * @param monster monster who activated the effect
	 */
	public void activateAction(Monster monster) {
		Adventurer.getInstance().takeDamage(this.damage);

		if(this.nextAction != null)
			this.nextAction.activateAction(monster);
	}

	public DamageAction clone(){
		return new DamageAction(this.getDamage());
	}
	
	public String toString() {
		if(this.nextAction != null)
			return "damage:"+this.damage+","+this.nextAction;

		else
			return "damage:"+this.damage;
	}

	public String var_dump(){
		return "ID:"+this.getID()+" damage:"+this.damage+" nextAction:"+this.nextAction;
	}
	
}
