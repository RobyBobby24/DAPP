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
		// TODO - implement DecoratorState.drawCards
		throw new UnsupportedOperationException();
	}

	public int getProtection() {
		// TODO - implement DecoratorState.getProtection
		throw new UnsupportedOperationException();
	}

	@Override
	public void setProtection(int protection) {

	}

	public void setProtection() {
		// TODO - implement DecoratorState.setProtection
		throw new UnsupportedOperationException();
	}

	public int getEnergyPoint() {
		// TODO - implement DecoratorState.getEnergyPoint
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param energyPoint
	 */
	public void setEnergyPoint(int energyPoint) {
		// TODO - implement DecoratorState.setEnergyPoint
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param copiedDeck
	 */
	public void setDeck(Deck copiedDeck) {
		// TODO - implement DecoratorState.setDeck
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param cardIndex
	 */
	public Card getCardFromHand(int cardIndex) {
		// TODO - implement DecoratorState.getCardFromHand
		throw new UnsupportedOperationException();
	}

	public void passTurn() {
		// TODO - implement DecoratorState.passTurn
		throw new UnsupportedOperationException();
	}

	@Override
	public void startTurn() {

	}

	/**
	 * 
	 * @param protection
	 */
	public void addProtection(int protection) {
		// TODO - implement DecoratorState.addProtection
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param damage
	 * @param adventurer
	 */
	public void takeDamage(int damage, Adventurer adventurer) {
		// TODO - implement DecoratorState.takeDamage
		throw new UnsupportedOperationException();
	}

	@Override
	public void removeCardFromHand(Card card) {

	}

	@Override
	public void buyAcard(Card card) {

	}

	@Override
	public void addCoins(int coins) {

	}

	public List<Card> getCardsFromHand() {
		// TODO - implement DecoratorState.getCardsFromHand
		throw new UnsupportedOperationException();
	}

	public void buyACard() {
		// TODO - implement DecoratorState.buyACard
		throw new UnsupportedOperationException();
	}

	public void addCoins() {
		// TODO - implement DecoratorState.addCoins
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param card
	 */
	public void addCard(Card card) {
		// TODO - implement DecoratorState.addCard
		throw new UnsupportedOperationException();
	}

	public void drawCardsStartTurn() {
		// TODO - implement DecoratorState.drawCardsStartTurn
		throw new UnsupportedOperationException();
	}

	@Override
	public void catchReward(int coins) {

	}

}