package model;

public abstract class Treasure {

	private int rewardCoins;
	private Card card;

	public int getRewardCoins() {
		return this.rewardCoins;
	}

	public void setRewardCoins(int rewardCoins) {
		this.rewardCoins = rewardCoins;
	}

	public Card getCard() {
		return this.card;
	}

	public void setCards(Card card) {
		this.card = card;
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