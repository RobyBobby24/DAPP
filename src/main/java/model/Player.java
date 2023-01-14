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
@Table(name="Player")
public class Player implements Serializable {
	public Player() {
	}

	@Transient
	private static Player instance;


	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="MODEL_PLAYER_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="MODEL_PLAYER_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@Column(name="Nickname", nullable=true, length=255)	
	private String nickname;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setNickname(String value) {
		this.nickname = value;
	}
	
	public String getNickname() {
		return nickname;
	}
	

	public static Player getInstance() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
