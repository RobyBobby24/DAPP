package model;

import services.PersistenceInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

public class EasyDifficultyStrategy implements BuildMapDifficultyStrategy {

	public EasyDifficultyStrategy() {

	}

	@Override
	public void buildMap(DungeonMap dungeonMap) throws IOException {
		ArrayList<TreeMap<String,String>> clause= new ArrayList<>();
		ArrayList<String> operation= new ArrayList<>();
		TreeMap<String,String> key_value_equal = new TreeMap<>();
		TreeMap<String,String> key_value_lessEqual = new TreeMap<>();

		//query normal monsters with challengeRating<1
		key_value_equal.put("type","normal");
		operation.add("=");
		clause.add(key_value_equal);

		key_value_lessEqual.put("challengeRating","1");
		operation.add("<=");
		clause.add(key_value_lessEqual);

		List<Monster>  normalMonsters = (List<Monster>) PersistenceInterface.getInstance().complexSearch(clause,operation,Monster.class);


		//query boss monsters with challengeRating<1
		key_value_equal.put("type","boss");

		List<Monster>  bossMonsters = (List<Monster>) PersistenceInterface.getInstance().complexSearch(clause,operation,Monster.class);

		//query cards
		List<Card>  cards = (List<Card>) PersistenceInterface.getInstance().search(new TreeMap<>(),Card.class);

		//query treasures
		List<Treasure>  treasures = (List<Treasure>) PersistenceInterface.getInstance().search(new TreeMap<>(),Treasure.class);

		BattleRoom startingRoom = this.createBattleRoomRandomMonster(normalMonsters);

		MerchantRoom merchantRoom=this.createMerchantRoomRandomCards(cards);

		TreasureRoom treasureRoom=this.createTreasureRoomRandomTreasure(treasures);


		RoomFactory roomFactory = ServicesFactory.getInstance().getRoomFactoryInstance();
		BonfireRoom bonfireRoom=roomFactory.createBonfireRoom();

		BattleRoom endRoom = this.createBattleRoomRandomMonster( bossMonsters );
		dungeonMap.setCurrentRoom(startingRoom);

		dungeonMap.addRoom(startingRoom,bonfireRoom);
		dungeonMap.addRoom(startingRoom,merchantRoom);
		dungeonMap.addRoom(startingRoom,treasureRoom);

		dungeonMap.addRoom(bonfireRoom,endRoom);
		dungeonMap.addRoom(merchantRoom,endRoom);
		dungeonMap.addRoom(treasureRoom,endRoom);

		dungeonMap.addRoom(endRoom,null);
	}

	private BattleRoom createBattleRoomRandomMonster(List<Monster> monsters){
		Random random = new Random();
		RoomFactory roomFactory = ServicesFactory.getInstance().getRoomFactoryInstance();
		BattleRoom battleRoom = roomFactory.createBattleRoom();
		int number = random.nextInt(monsters.size());
		battleRoom.addMonster(monsters.get(number));
		return battleRoom;
	}

	private MerchantRoom createMerchantRoomRandomCards(List<Card> cards){
		Random random = new Random();
		RoomFactory roomFactory = ServicesFactory.getInstance().getRoomFactoryInstance();
		MerchantRoom merchantRoom=roomFactory.createMerchantRoom();
		for(int i=0;i<3;i++){
			merchantRoom.addCard( cards.get( random.nextInt( cards.size() ) ) );
		}
		return merchantRoom;
	}

	private TreasureRoom createTreasureRoomRandomTreasure(List<Treasure> treasures){
		Random random = new Random();
		RoomFactory roomFactory = ServicesFactory.getInstance().getRoomFactoryInstance();
		TreasureRoom treasureRoom=roomFactory.createTreasureRoom();
		for(int i=0;i<3;i++){
			treasureRoom.addTreasure(treasures.get( random.nextInt(treasures.size()) ));
		}
		return treasureRoom;
	}

}