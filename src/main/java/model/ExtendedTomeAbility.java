package model;

public class ExtendedTomeAbility extends DecoratorState {

	public void drawCardsStartTurn() {
    Adventurer.getInstance().drawCards(2);
	}
	private final String description = "pesca 2 carte in più ad ogni turno";

	public void startTurn(){
    	super.startTurn();
		this.drawCardsStartTurn();
	}

	public String toString(){
		return "Ability : "+this.description+this.getComponent();
	}

}