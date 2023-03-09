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
/*
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="room")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("Room")
 */
public abstract class Room implements Comparable<BattleRoom> {

	/*
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="MODEL_ROOM_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="MODEL_ROOM_ID_GENERATOR", strategy="native")
	 */

	
	abstract void setID(int value);
	
	abstract int getID();
	
	public abstract void enterRoom();

	public int compareTo(BattleRoom other) {
		return 0;
	}
	
}
