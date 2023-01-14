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
import java.util.ArrayList;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="DungeonMap")
public class DungeonMap implements Serializable {
	public DungeonMap() {
	}


	@Transient
	private static DungeonMap instance;

	@Transient
	private Room currentRoom;

	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="MODEL_DUNGEONMAP_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="MODEL_DUNGEONMAP_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@OneToMany(targetEntity= Room.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="DungeonMapID", nullable=false) })	
	@org.hibernate.annotations.IndexColumn(name="DungeonMapIndex")	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private ArrayList rooms = new ArrayList();





	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	private void setORM_Rooms(ArrayList value) {
		this.rooms = value;
	}
	
	private ArrayList getORM_Rooms() {
		return rooms;
	}
	
	public static DungeonMap getInstance() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public Void buildMap() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public ArrayList<Room> giveMeAvailableRooms() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public Room getRoom(int roomId) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public Room getCurrentRoom() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void setCurrentRoom(Room currentRoom) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}

	public void addRoom(Room room){
		this.rooms.add(room);
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
