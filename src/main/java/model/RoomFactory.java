package model;

public interface RoomFactory {

	public abstract BattleRoom createBattleRoom();

	public abstract TreasureRoom createTreasureRoom();

	public abstract BonfireRoom createBonfireRoom();

	public abstract MerchantRoom createMerchantRoom();

}