package model;

public class ExtendedTomeAbility extends DecoratorState {



	public void drawCardsStartTurn() {
    Adventurer.getInstance().drawCards(5);
	}

	public void startTurn(){
    super.startTurn();
	drawCardsStartTurn();
	}

}