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

	@Override
	public void enterRoom() {

	}

	@Override
	public int getId() {
		return 0;
	}

	@Override
	public void setId(int id) {

	}

}