package model;

import java.util.*;

public class TreasureRoom implements Room {

	ArrayList<Treasure> treasures;

	public ArrayList<Treasure> getTreasures() {
		return this.treasures;
	}

	public void setTreasures(ArrayList<Treasure> treasures) {
		this.treasures = treasures;
	}

	public TreasureRoom() {
		// TODO - implement TreasureRoom.TreasureRoom
		throw new UnsupportedOperationException();
	}

}