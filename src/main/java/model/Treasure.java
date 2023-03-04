package model;

public abstract class Treasure {

	private int rewardCoins;
	private Card[] cards;

	public int getRewardCoins() {
		return this.rewardCoins;
	}

	public void setRewardCoins(int rewardCoins) {
		this.rewardCoins = rewardCoins;
	}

	public Card[] getCards() {
		return this.cards;
	}

	public void setCards(Card[] cards) {
		this.cards = cards;
	}

	public void provideReward() {
		// TODO - implement Treasure.provideReward
		throw new UnsupportedOperationException();
	}

	public String giveTreasureDescription() {
		// TODO - implement Treasure.giveTreasureDescription
		throw new UnsupportedOperationException();
	}

}