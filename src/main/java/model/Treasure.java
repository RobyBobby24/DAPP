package model;

import jakarta.persistence.*;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="treasure")
public class Treasure {

	@Column(name="ID", nullable=false, length=10)
	@Id
	@GeneratedValue(generator="MODEL_CARD_ID_GENERATOR")
	@org.hibernate.annotations.GenericGenerator(name="MODEL_CARD_ID_GENERATOR", strategy="native")
	private int ID;
	@Column(name="rewardCoins", nullable=false, length=10)
	private int rewardCoins;

	@OneToOne(targetEntity= Card.class, fetch=FetchType.EAGER)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
	@JoinColumns(value = { @JoinColumn(name="CardID",referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="FKCard"))
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

	public void setCard(Card card) {
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