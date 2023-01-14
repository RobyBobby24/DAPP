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
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("DamageEffect")
public class DamageEffect extends Effect implements Serializable {
	public DamageEffect() {
	}
	
	@Column(name="Damage", nullable=true, length=10)	
	private int damage;
	
	public void setDamage(int value) {
		this.damage = value;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public void activeEffect(BattleRoom battleField, int[] target) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public int numberOfTarget(int actualNumber) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return super.toString();
	}
	
}
