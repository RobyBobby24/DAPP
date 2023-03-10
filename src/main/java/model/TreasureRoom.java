package model;

import java.util.*;

public class TreasureRoom extends Room {
	ArrayList<Treasure> treasures = new ArrayList<>();

	public ArrayList<Treasure> getTreasures() {
		return this.treasures;
	}

	public void setTreasures(ArrayList<Treasure> treasures) {
		this.treasures = treasures;
	}

	public TreasureRoom() {
		super();
	}

	@Override
	public void enterRoom() {
		FrontController.getInstance().chooseTreasure(this.treasures);
	}

	public void addTreasure(Treasure treasure){
		this.treasures.add(treasure);
	}
}