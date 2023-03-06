package model;

public class ExtendedTomeAbility extends DecoratorState {

	public void drawCardsStartTurn() {

	}

	public void startTurn(){
    super.startTurn();
	drawCardsStartTurn();
	}

}