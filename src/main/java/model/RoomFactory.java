package model;

import services.Configuration;

import java.lang.reflect.Method;

public interface RoomFactory {

	public abstract BattleRoom createBattleRoom();

	public abstract TreasureRoom createTreasureRoom();

	public abstract BonfireRoom createBonfireRoom();

	public abstract MerchantRoom createMerchantRoom();

}