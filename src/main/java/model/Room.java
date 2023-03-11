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
public abstract class Room implements Comparable<Room> {

	/*
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="MODEL_ROOM_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="MODEL_ROOM_ID_GENERATOR", strategy="native")
	 */
	private static int idCount = 0;

	protected int ID;

	public  Room() {
		this.setID(Room.idCount);
		Room.idCount = Room.idCount +1;
	}

	private void setID(int value){
		this.ID = value;
	}
	
	public int getID(){
		return this.ID;
	}
	
	public abstract void enterRoom() throws Exception;

	public int compareTo(Room other) {
		if(this.ID > other.ID) return 1;
		else if (this.ID == other.ID) return 0;
		else return -1;
	}

	public String toString(){
		return this.getClass().getSimpleName();
	}
	
}
