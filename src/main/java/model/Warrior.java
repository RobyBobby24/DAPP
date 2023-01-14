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

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

import java.io.Serializable;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("Warrior")
public class Warrior extends Adventurer implements Serializable {
	public Warrior() {
	}

	@Override
	public int getId() {
		return 0;
	}

	@Override
	public void setId(int id) {

	}

	@Override
	public AdventurerState getCurrentState() {
		return null;
	}

	@Override
	public void setBattleState() {

	}

	public String toString() {
		return super.toString();
	}
	
}
