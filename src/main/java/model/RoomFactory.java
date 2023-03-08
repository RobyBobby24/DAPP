package model;

import java.io.IOException;

public interface RoomFactory {

	public abstract BattleRoom createBattleRoom();

	public abstract TreasureRoom createTreasureRoom();

	public abstract BonfireRoom createBonfireRoom() throws IOException;

	public abstract MerchantRoom createMerchantRoom();

}