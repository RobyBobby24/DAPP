package model;

import java.util.ArrayList;

public class BattleState implements AdventurerState {

	private Hand hand;
	private DiscardPile discardPile;
	private Deck deck;
	private int protection;
	private int energyPoint;




	public BattleState() {
		this.hand = new Hand();
		this.discardPile = new DiscardPile();
		this.deck = new Deck();
		this.energyPoint=0;
		this.protection=0;
	}

	/**
	 * @return protection (number of damage that adventurer could take without lose hp)
	 */
	public int getProtection() {
		return this.protection;
	}

	/**
	 * set new protection (number of damage that adventurer could take without lose hp)
	 * @param protection new protection
	 */
	public void setProtection(int protection) {
		this.protection = protection;
	}

	/**
	 * add "protection" point to the protection
	 * @param protection number of protection point to add
	 */
	@Override
	public void addProtection(int protection) {
		this.protection=this.protection+protection;
	}


	/**
	 * @return energyPoint ( a sort of money useful for play a card)
	 */
	public int getEnergyPoint() {
		return this.energyPoint;
	}

	/**
	 * set new energyPoint ( a sort of money useful for play a card)
	 * @param energyPoint new energyPoint
	 */
	public void setEnergyPoint(int energyPoint) {
		this.energyPoint = energyPoint;
	}

	/**
	 * take card from deck and put they to the hand
	 * @param numberOfCards number of cards to draw
	 */
	public void drawCards(int numberOfCards) {
		int numberCardsOfDeck = this.deck.getNumberOfCards();
		if(numberCardsOfDeck > numberOfCards) {
			ArrayList<Card> cards = this.deck.getAndRemoveCards(numberOfCards);
			this.hand.addCard(cards);
		}
		else{
			ArrayList<Card> cards = this.deck.getAndRemoveCards(numberCardsOfDeck);
			this.hand.addCard(cards);
			ArrayList<Card> discardPileCards = this.discardPile.getAndRemoveCards();
			this.deck.addCard(discardPileCards);
			this.deck.shuffle();
			ArrayList<Card> otherCards = this.deck.getAndRemoveCards(numberOfCards- numberCardsOfDeck);
			this.hand.addCard(otherCards);
		}
	}

	/**
	 * set new Deck (list of card available for the adventurer)
	 * @param copiedDeck new Deck
	 */
	public void setDeck(Deck copiedDeck) {
		this.deck = copiedDeck;
	}

	/**
	 * @param cardIndex index of the card to get
	 * @return the card chosen
	 */
	public Card getCardFromHand(int cardIndex) {
		return this.hand.getCard(cardIndex);
	}

	@Override
	public ArrayList<Card> getCardsFromHand() {
		return this.hand.getCards();
	}


	/**
	 * do all the action that deck,discardPile and hand need at the end of the Adventurer turn
	 */
	@Override
	public void passTurn() {
		ArrayList<Card> cards = this.hand.getAndRemoveCards();
		this.discardPile.addCard(cards);
	}

	@Override
	public void startTurn() {
		this.setEnergyPoint(3);
		this.drawCards(5);
	}

	/**
	 * decrease currentHp and/or protection in case there is
	 *
	 * @param damage number of point to decrease
	 */
	@Override
	public void takeDamage(int damage) {
		if ( this.protection < damage ){
			Adventurer.getInstance().getHp().addCurrentHp(this.protection-damage);
			this.protection = 0;
		}
		else{
			this.protection=this.protection-damage;
		}
		if(Adventurer.getInstance().getHp().getCurrentHp() == 0){
			BattleRoom battleRoom = (BattleRoom)DungeonMap.getInstance().getCurrentRoom();
			battleRoom.notifyDeath(null);
			FrontController.getInstance().setEndBattle(true);
			FrontController.getInstance().setLost();
		}
	}

	public String toString(){
		return "Protection="+this.protection+", EnergyPoint="+this.energyPoint;
	}

	@Override
	public void removeCardFromHand(Card card) {
		this.hand.removeCard(card);
		this.discardPile.addCard(card);
	}

	@Override
	public boolean buyAcard(Card card) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void addCoins(int coins) {

	}

	@Override
	public void addCard(Card card) {

	}



	@Override
	public void catchBattleReward() {

	}

}