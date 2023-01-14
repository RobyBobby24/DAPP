package model;

public class BattleState implements AdventurerState {

	private Hand[] hand;
	private DiscardPile discardPile;
	private Deck deck;
	private int protection;
	private int energyPoint;

	public int getProtection() {
		return this.protection;
	}

	/**
	 * 
	 * @param protection
	 */
	public void setProtection(int protection) {
		this.protection = protection;
	}

	public int getEnergyPoint() {
		return this.energyPoint;
	}

	/**
	 * 
	 * @param energyPoint
	 */
	public void setEnergyPoint(int energyPoint) {
		this.energyPoint = energyPoint;
	}

	public BattleState BattleState() {
		// TODO - implement BattleState.BattleState
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param numberOfCards
	 */
	public void drawCards(int numberOfCards) {
		// TODO - implement BattleState.drawCards
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param copyDeck
	 */
	public void setDeck(Deck copyDeck) {
		this.deck = copyDeck;
	}

	/**
	 * 
	 * @param cardID
	 */
	public Card getCardFromHand(int cardID) {
		// TODO - implement BattleState.getCardFromHand
		throw new UnsupportedOperationException();
	}

}