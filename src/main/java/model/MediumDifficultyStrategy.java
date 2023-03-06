package model;

import services.PersistenceInterface;

import java.util.*;

public class MediumDifficultyStrategy implements BuildMapDifficultyStrategy {

	int numberOfLevel=6;
	int numberOfBattleRoom=8;
	int numberOfMerchantRoom=3;
	int numberOfTreasureRoom=3;
	int numberOfBonfireRoom=3;

	public void MediumDifficultySrategy() {

	}
	public void buildMap(DungeonMap dungeonMap) {
		TreeMap<String,String> key_value = new TreeMap<>();
		key_value.put("type","normal");
		key_value.put("challengeRating","2");
		List<Monster> normalMonsters = (List<Monster>) PersistenceInterface.getInstance().search(key_value,Monster.class);
		key_value = new TreeMap<>();
		key_value.put("type","normal");
		key_value.put("challengeRating","1");
		List<Monster> normalMonstersRatingOne = (List<Monster>) PersistenceInterface.getInstance().search(key_value,Monster.class);
		normalMonsters.addAll( normalMonstersRatingOne );
		Collections.shuffle(normalMonsters);

		key_value = new TreeMap<>();
		key_value.put("type","boss");
		key_value.put("challengeRating","2");
		List<Monster>  bossMonsters = (List<Monster>) PersistenceInterface.getInstance().search(key_value,Monster.class);

		List<Card>  cards = (List<Card>) PersistenceInterface.getInstance().search(new TreeMap<>(),Card.class);

		List<Treasure>  treasures = (List<Treasure>) PersistenceInterface.getInstance().search(new TreeMap<>(),Treasure.class);

		BattleRoom startingRoom = this.createBattleRoomRandomNormalMonster(normalMonsters,normalMonstersRatingOne);

		List<Room> rooms = this.takeRooms(normalMonsters,normalMonstersRatingOne,cards,treasures);

		Random random = new Random();

		dungeonMap.setCurrentRoom(startingRoom);

		List<Room> secondLevel = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			secondLevel.add( rooms.remove( random.nextInt( rooms.size() ) ) );
			dungeonMap.addRoom( startingRoom, secondLevel.get(i) );
		}
		BattleRoom endRoom = this.createBattleRoomRandomBossMonster(bossMonsters);
		for( Room room : secondLevel){
			List<Room> level = new ArrayList<>();
			level.add(room);
			int choose = random.nextInt( this.numberOfLevel-2 );
			for (int i = 0; i < this.numberOfLevel-2; i++) {
				List<Room> actualLevel = new ArrayList<>();
				actualLevel.add( rooms.remove( random.nextInt( rooms.size() ) ) );
				if( choose==i ) actualLevel.add( rooms.remove( random.nextInt( rooms.size() ) ) );
				for (Room rKey : level){
					for (Room rValue : actualLevel){
						dungeonMap.addRoom(rKey, rValue);
					}
				}
				level = new ArrayList<>(actualLevel);
			}
			for( Room secondLastRoom : secondLevel){
				dungeonMap.addRoom(secondLastRoom,endRoom);
			}
		}

		
	}

	private List<Room> takeRooms(List<Monster> normalMonsters,List<Monster> normalMonstersRatingOne,List<Card>  cards,List<Treasure>  treasures ){

		List<Room> rooms = new ArrayList<Room>();
		for (int i = 0; i < numberOfBattleRoom-2; i++) {
			rooms.add(this.createBattleRoomRandomNormalMonster(normalMonsters,normalMonstersRatingOne));
		}
		for (int i = 0; i < this.numberOfMerchantRoom; i++) {
			rooms.add(this.createMerchantRoomRandomCards(cards));
		}
		for (int i = 0; i < this.numberOfTreasureRoom; i++) {
			rooms.add(this.createTreasureRoomRandomTreasure(treasures));
		}
		for (int i = 0; i < this.numberOfBonfireRoom; i++) {
			RoomFactory roomFactory = ServicesFactory.getInstance().getRoomFactoryInstance();
			BonfireRoom bonfireRoom=roomFactory.createBonfireRoom();
			rooms.add(bonfireRoom);
		}
		return rooms;
	}

	private BattleRoom createBattleRoomRandomNormalMonster(List<Monster> monsters, List<Monster> monstersRatingOne){
		Random random = new Random();
		RoomFactory roomFactory = ServicesFactory.getInstance().getRoomFactoryInstance();
		BattleRoom battleRoom = roomFactory.createBattleRoom();
		int number = random.nextInt( monsters.size() );
		Monster monster = monsters.get( number );
		battleRoom.addMonster( monster );
		if( monster.getChallengeRating()==1 ){
			number = random.nextInt( monsters.size() );
			battleRoom.addMonster( monsters.get(number) );
		}
		return battleRoom;
	}

	private BattleRoom createBattleRoomRandomBossMonster(List<Monster> monsters){
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