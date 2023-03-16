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
	 */
	public void takeDamage(int damage) {
		this.component.takeDamage( damage );
	}

	@Override
	public void removeCardFromHand(Card card) {
		this.component.removeCardFromHand( card );
	}

	@Override
	public boolean buyAcard(Card card) throws Exception {
		return this.component.buyAcard( card );
	}

	@Override
	public void addCoins(int coins) throws Exception {
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

	@Override
	public void restorePercentageHp(int percentage) {

	}

	public String toString(){
		return this.component.toString();
	}

}