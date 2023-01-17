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
import java.util.List;

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
	private List<Room> rooms = new ArrayList<Room>();


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
	
	public static DungeonMap getInstance() {
		if(DungeonMap.instance==null){
			DungeonMap.instance=DungeonMapFactory.getInstance().loadDungeonMap();
			if(DungeonMap.instance==null){
				DungeonMap.instance=new DungeonMap();
			}
		}
		return DungeonMap.instance;
	}

	/**
	 * build the map with all its room
	 */
	public void buildMap() {
		BattleRoomFactory battleRoomFactory=new BattleRoomFactory();
		this.rooms.add(battleRoomFactory.createRoom());
	}

	/**
	 * @return the list of the room reachable where the Adventurer is
	 */
	public ArrayList<Room> giveMeAvailableRooms() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}

	/**
	 * @param roomId ID of the room sought
	 * @return the room that has "roomId" as ID
	 */
	public Room getRoom(int roomId) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}

	/**
	 * @return the room where there is the Adventurer
	 */
	public Room getCurrentRoom() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}

	/**
	 * set new actualRoom (the room where there is the Adventurer)
	 * @param currentRoom new actualRoom
	 */
	public void setCurrentRoom(Room currentRoom) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}

	/**
	 * add a room to the map
	 * @param room room to add
	 */
	public void addRoom(Room room){
		this.rooms.add(room);
	}
	
	public String toString() {
		return String.valueOf(getID());
	}

	public String var_dump(){
		return "ID:"+this.ID+" rooms:"+this.rooms+" currentRoom:"+this.currentRoom;
	}
	
}
