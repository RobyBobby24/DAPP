package model;

public interface RoomFactory {

	/**
	 *
	 */
	public abstract Room createBattleRoom();

	public abstract Room createTreasureRoom();

	public abstract Room createBonfireRoom();

	public abstract Room createMerchantRoom();

}