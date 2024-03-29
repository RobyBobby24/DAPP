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

import controller.FrontController;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/*
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="dungeonmap")
 */
public class DungeonMap implements Serializable {



	//@Transient
	private static DungeonMap instance;

	//@Transient
	private Room currentRoom;

	/*
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="MODEL_DUNGEONMAP_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="MODEL_DUNGEONMAP_ID_GENERATOR", strategy="native")
	 */
	private int ID;

	/*
	@OneToMany(targetEntity= Room.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="DungeonMapID", nullable=false) })	
	@org.hibernate.annotations.IndexColumn(name="DungeonMapIndex")	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	 */
	private TreeMap< Room, List<Room>> rooms = new TreeMap();

	private List<Room> startingRooms = new ArrayList<>();

	//@Transient
	private BuildMapDifficultyStrategy difficulty;


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
		if(DungeonMap.instance == null){
			DungeonMap.instance = new DungeonMap();
		}
		return DungeonMap.instance;
	}

	public static void resetDungeonMap(){
		DungeonMap.instance = null;
	}

	/**
	 * build the map with all its room
	 */
	public void buildMap() throws IOException {
		this.difficulty.buildMap();
	}

	/**
	 * @return the list of the room reachable where the Adventurer is
	 */
	public ArrayList<Room> giveMeAvailableRooms() {
		if( this.currentRoom==null ) return new ArrayList<Room>(this.startingRooms);
		else return new ArrayList<Room>(this.rooms.get(this.currentRoom));
	}

	/**
	 * @param roomId ID of the room sought
	 * @return the room that has "roomId" as ID
	 */
	public Room getRoom(int roomId) {
		for (Room room : this.rooms.keySet()) {
			if (room.getID() == roomId)
				return room;
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
		if( !this.areThereAvailableRooms() ) FrontController.getInstance().setEndBattle( 1 );
	}


	public void setDifficulty(BuildMapDifficultyStrategy difficultyStrategy) {
		this.difficulty = difficultyStrategy;
	}

	public BuildMapDifficultyStrategy getDifficulty() {
		return difficulty;
	}

	public boolean areThereAvailableRooms() {
		if(this.currentRoom == null && this.startingRooms.size()>0){
			return true;
		}
		else if (rooms.get(currentRoom) != null){
			return true;
		}
		return false;
	}
	/**
	 * add a room to the map
	 */
	public void addRoom(Room keyRoom, Room roomToAdd){
		if(keyRoom==null) this.startingRooms.add(roomToAdd);
		else if( roomToAdd==null ) this.rooms.put(keyRoom,null);
		else if(this.rooms.containsKey(keyRoom)){
			this.rooms.get(keyRoom).add(roomToAdd);
		}
		else {
			ArrayList<Room> arrayRoom = new ArrayList<>();
			arrayRoom.add(roomToAdd);
			this.rooms.put(keyRoom, arrayRoom);
		}
	}

	public TreeMap<Room, List<Room>> getRooms() {
		return rooms;
	}

	public String toString() {
		return String.valueOf(this.rooms.size());
	}

	public String var_dump(){
		return "ID:"+this.ID+" rooms:"+this.rooms+" currentRoom:"+this.currentRoom;
	}
	
}
