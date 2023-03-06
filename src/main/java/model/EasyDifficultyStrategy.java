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

		RoomFactory roomFactory = ServicesFactory.getInstance().getRoomFactoryInstance();

		BattleRoom startingRoom = roomFactory.createBattleRoom();
		int number = random.nextInt(normalMonsters.size());
		startingRoom.addMonster(normalMonsters.get(number));

	}

}