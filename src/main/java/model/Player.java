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
import java.util.TreeMap;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Player")
public class Player implements Serializable {

	@Transient
	private static Player instance;


	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="MODEL_PLAYER_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="MODEL_PLAYER_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@Column(name="Nickname", nullable=true, length=255)	
	private String nickname;







	protected Player() {
	}

	private void setID(int value) {
		this.ID = value;
	}

	/**
	 * @return ID (identifier of the class)
	 */
	public int getID() {
		return ID;
	}

	/**
	 * set new nickname (how the game will call the player)
	 * @param nickname
	 */
	public void setNickname(String nickname) {
		this.nickname =nickname;
	}

	/**
	 * @return nickname (how the game will call the player)
	 */
	public String getNickname() {
		return nickname;
	}


	/**
	 * @return the unique instance of the player
	 */
	public static Player getInstance() {
		if(Player.instance==null){
			if(PersistenceInterface.getInstance().exist(new TreeMap<>(),Player.class)){
				Player.instance= (Player) PersistenceInterface.getInstance().search(new TreeMap<>(),Player.class).get(0);
			}
			else Player.instance= new Player();
		}
		return Player.instance;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}

	public String var_dump(){
		return "ID:"+this.ID+" nickname:"+this.nickname;
	}
	
}
