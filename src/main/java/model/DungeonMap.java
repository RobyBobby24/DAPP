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
import services.PersistenceInterface;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="dungeonmap")
public class DungeonMap implements Serializable {



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


	protected DungeonMap() {
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
	
	public static DungeonMap getInstance() {
		if(DungeonMap.instance==null){
			if(PersistenceInterface.getInstance().exist(new TreeMap<>(),DungeonMap.class)){
				DungeonMap.instance=(DungeonMap)PersistenceInterface.getInstance().search(new TreeMap<>(),DungeonMap.class).get(0);
			}
			else{
				DungeonMap.instance=new DungeonMap();
			}
		}
		return DungeonMap.instance;
	}

	/**
	 * build the map with all its room
	 */
	public void buildMap() {
		StandardRoomFactory standardRoomFactory =new StandardRoomFactory();
		this.rooms.add(standardRoomFactory.createBattleRoom());
	}

	/**
	 * @return the list of the room reachable where the Adventurer is
	 */
	public ArrayList<Room> giveMeAvailableRooms() {
		return new ArrayList<Room>(this.rooms);
	}

	/**
	 * @param roomId ID of the room sought
	 * @return the room that has "roomId" as ID
	 */
	public Room getRoom(int roomId) {
		for (Room room : this.rooms) {
			if (room.getID() == roomId) return room;
		}
		return null;
	}

	/**
	 * @return the room where there is the Adventurer
	 */
	public Room getCurrentRoom() {
		return this.currentRoom;
	}

	/**
	 * set new actualRoom (the room where there is the Adventurer)
	 * @param currentRoom new actualRoom
	 */
	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom=currentRoom;
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
