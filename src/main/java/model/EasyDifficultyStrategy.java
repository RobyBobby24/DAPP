package model;

import services.PersistenceInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

public class EasyDifficultyStrategy implements BuildMapDifficultyStrategy {

	public EasyDifficultyStrategy() {
		// TODO - implement EasyDifficultyStrategy.EasyDifficultyStrategy
		throw new UnsupportedOperationException();
	}

	@Override
	public void buildMap(DungeonMap dungeonMap) {
		Random random = new Random();

		TreeMap<String,String> key_value = new TreeMap<>();
		key_value.put("type","normal");
		key_value.put("challengeRating","1");
		List<Monster>  normalMonsters = (List<Monster>) PersistenceInterface.getInstance().search(key_value,Monster.class);
		key_value = new TreeMap<>();
		key_value.put("type","boss");
		key_value.put("challengeRating","1");
		List<Monster>  bossMonsters = (List<Monster>) PersistenceInterface.getInstance().search(key_value,Monster.class);

		List<Card>  cards = (List<Card>) PersistenceInterface.getInstance().search(new TreeMap<>(),Card.class);

		List<Treasure>  treasures = (List<Treasure>) PersistenceInterface.getInstance().search(new TreeMap<>(),Treasure.class);

		RoomFactory roomFactory = ServicesFactory.getInstance().getRoomFactoryInstance();

		BattleRoom startingRoom = roomFactory.createBattleRoom();
		int number = random.nextInt(normalMonsters.size());
		startingRoom.addMonster(normalMonsters.get(number));

		MerchantRoom merchantRoom=roomFactory.createMerchantRoom();
		number = random.nextInt(cards.size());
		merchantRoom.addCard(cards.get(number));
		number = random.nextInt(cards.size());
		merchantRoom.addCard(cards.get(number));
		number = random.nextInt(cards.size());
		merchantRoom.addCard(cards.get(number));

		TreasureRoom treasureRoom=roomFactory.createTreasureRoom();
		number = random.nextInt(treasures.size());
		treasureRoom.addTreasure(treasures.get(number));
		number = random.nextInt(treasures.size());
		treasureRoom.addTreasure(treasures.get(number));
		number = random.nextInt(treasures.size());
		treasureRoom.addTreasure(treasures.get(number));

		BonfireRoom bonfireRoom=roomFactory.createBonfireRoom();

		BattleRoom endRoom = roomFactory.createBattleRoom();
		number = random.nextInt(bossMonsters.size());
		startingRoom.addMonster(bossMonsters.get(number));

		dungeonMap.setCurrentRoom(startingRoom);

		dungeonMap.addRoom(startingRoom,bonfireRoom);
		dungeonMap.addRoom(startingRoom,merchantRoom);
		dungeonMap.addRoom(startingRoom,treasureRoom);

		dungeonMap.addRoom(bonfireRoom,endRoom);
		dungeonMap.addRoom(merchantRoom,endRoom);
		dungeonMap.addRoom(treasureRoom,endRoom);

		dungeonMap.addRoom(endRoom,null);
	}

}