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
@Table(name="Room")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("Room")
public abstract class Room implements Serializable {
	public Room() {
	}
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="MODEL_ROOM_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="MODEL_ROOM_ID_GENERATOR", strategy="native")	
	protected int ID;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public abstract void enterRoom();
	
	public abstract int getId();
	
	public abstract void setId(int id);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
