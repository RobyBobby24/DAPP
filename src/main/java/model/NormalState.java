package model;

import java.util.List;

public class NormalState implements AdventurerState {

	/**
	 * no op
	 * @param numberOfCards number of cards to draw
	 */
	public void drawCards(int numberOfCards) {
	}

	/**
	 * @return exception
	 */
	@Override
	public int getProtection() {
		throw new UnsupportedOperationException();
	}

	/**
	 * no op
	 * @param protection new protection
	 */
	@Override
	public void setProtection(int protection) {

	}


	/**
	 * no op
	 * @param protection number of protection point to add
	 */
	@Override
	public void addProtection(int protection) {

	}

	/**
	 * @return exception
	 */
	@Override
	public int getEnergyPoint() {
		throw new UnsupportedOperationException();
	}

	/**
	 * no op
	 * @param energyPoint new energyPoint
	 */
	@Override
	public void setEnergyPoint(int energyPoint) {

	}

	/**
	 * no op
	 * @param copiedDeck new Deck
	 */
	@Override
	public void setDeck(Deck copiedDeck) {

	}

	/**
	 * no op
	 * @param cardIndex index of the card to get
	 * @return exception
	 */
	@Override
	public Card getCardFromHand(int cardIndex) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Card> getCardsFromHand() {
		throw new UnsupportedOperationException();
	}

	/**
	 * no op
	 */
	@Override
	public void passTurn() {

	}

	@Override
	public void startTurn() {

	}

	/**
	 * decrease currentHp
	 * @param damage number of point to decrease
	 * @param adventurer adventurer who take damage
	 */
	@Override
	public void takeDamage(int damage, Adventurer adventurer) {
		adventurer.getHp().addCurrentHp(-damage);
	}

	public String toString(){
		return this.getClass().getSimpleName();
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

	@Override
	public void addCard(Card card) {

	}

	@Override
	public void drawCardsStartTurn() {

	}

	@Override
	public void catchReward(int coins) {

	}

}