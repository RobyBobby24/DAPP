package model;

import java.util.*;

public class TreasureRoom implements Room {

	protected int ID;
	ArrayList<Treasure> treasures;

	public ArrayList<Treasure> getTreasures() {
		return this.treasures;
	}

	public void setTreasures(ArrayList<Treasure> treasures) {
		this.treasures = treasures;
	}

	public TreasureRoom() {
	}

	@Override
	public void setID(int value) {

	}

	@Override
	public int getID() {
		return 0;
	}

	@Override
	public void enterRoom() {
		FrontController.getInstance().chooseTreasure();
	}

	public void addTreasure(Treasure treasure){
		this.treasures.add(treasure);
	}
}