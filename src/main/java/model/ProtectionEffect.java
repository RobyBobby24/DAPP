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
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@DiscriminatorValue("ProtectionEffect")
public class ProtectionEffect extends Effect implements Serializable {
	public ProtectionEffect() {
	}
	
	@Column(name="Protection", nullable=true, length=10)	
	private int protection;
	
	public void setProtection(int value) {
		this.protection = value;
	}
	
	public int getProtection() {
		return protection;
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
