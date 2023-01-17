package model;

public interface AdventurerState {

	/**
	 * take card from deck and put they to the hand
	 * @param numberOfCards number of cards to draw
	 */
	void drawCards(int numberOfCards);

	/**
	 * @return protection (number of damage that adventurer could take without lose hp)
	 */
	int getProtection();

	/**
	 * set new protection (number of damage that adventurer could take without lose hp)
	 * @param protection new protection
	 */
	void setProtection(int protection);

	/**
	 * add "protection" point to the protection
	 * @param protection number of protection point to add
	 */
	public void addProtection(int protection);

	/**
	 * @return energyPoint ( a sort of money useful for play a card)
	 */
	int getEnergyPoint();

	/**
	 * set new energyPoint ( a sort of money useful for play a card)
	 * @param energyPoint new energyPoint
	 */
	void setEnergyPoint(int energyPoint);

	/**
	 * set new Deck (list of card available for the adventurer)
	 * @param copiedDeck new Deck
	 */
	void setDeck(Deck copiedDeck);

	/**
	 * @param cardIndex index of the card to get
	 * @return the card chosen
	 */
	Card getCardFromHand(int cardIndex);

	/**
	 * do all the action that deck,discardPile, hand and energyPoint need at the end of the Adventurer turn
	 */
	void passTurn();

	/**
	 * do all the action that deck,discardPile, hand and energyPoint need at the start of the Adventurer turn
	 */
	void startTurn();

	/**
	 * decrease currentHp
	 * @param damage number of point to decrease
	 * @param adventurer adventurer who take damage
	 */
	void takeDamage(int damage,Adventurer adventurer);

	@Override
	public String toString();



}