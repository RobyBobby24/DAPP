package model;

public class ExtendedTomeAbility extends DecoratorState {

	public void drawCardsStartTurn() {
    Adventurer.getInstance().drawCards(2);
	}

	public void startTurn(){
    	super.startTurn();
		this.drawCardsStartTurn();
	}

}