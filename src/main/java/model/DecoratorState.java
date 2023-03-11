package model;

import java.util.List;

public class DecoratorState implements AdventurerState {

	private AdventurerState component;

	public AdventurerState getComponent() {
		return this.component;
	}

	public void setComponent(AdventurerState component) {
		this.component = component;
	}

	/**
	 * 
	 * @param numberOfCards
	 */
	public void drawCards(int numberOfCards) {
		this.component.drawCards(numberOfCards);
	}

	public int getProtection() {
		return this.component.getProtection();
	}

	@Override
	public void setProtection(int protection) {
		this.component.setEnergyPoint(protection);
	}

	public int getEnergyPoint() {
		return this.component.getEnergyPoint();
	}

	/**
	 * 
	 * @param energyPoint
	 */
	public void setEnergyPoint(int energyPoint) {
		this.component.setEnergyPoint( energyPoint );
	}

	/**
	 * 
	 * @param copiedDeck
	 */
	public void setDeck(Deck copiedDeck) {
		this.setDeck( copiedDeck );
	}

	/**
	 * 
	 * @param cardIndex
	 */
	public Card getCardFromHand(int cardIndex) {
		return this.component.getCardFromHand( cardIndex );
	}

	public void passTurn() {
		this.component.passTurn();
	}

	@Override
	public void startTurn() {
      this.component.startTurn();
	}

	/**
	 * 
	 * @param protection
	 */
	public void addProtection(int protection) {
		this.component.addProtection( protection );
	}

	/**
	 * 
	 * @param damage
	 * @param adventurer
	 */
	public void takeDamage(int damage, Adventurer adventurer) {
		this.component.takeDamage( damage , adventurer);
	}

	@Override
	public void removeCardFromHand(Card card) {
		this.component.removeCardFromHand( card );
	}

	@Override
	public void buyAcard(Card card) {
		this.component.buyAcard( card );
	}

	@Override
	public void addCoins(int coins) {
		this.component.addCoins( coins );
	}

	public List<Card> getCardsFromHand() {
		return this.component.getCardsFromHand();
	}

	/**
	 * 
	 * @param card
	 */
	public void addCard(Card card) {
		this.addCard( card );
	}

	@Override
	public void catchBattleReward() {
    	this.component.catchBattleReward();
	}

}