package model;

import services.PersistenceInterface;

import java.util.*;

public class MediumDifficultyStrategy implements BuildMapDifficultyStrategy {

	public void MediumDifficultySrategy() {
		// TODO - implement MediumDifficultyStrategy.MediumDifficultySrategy
		throw new UnsupportedOperationException();
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
		
		List<Room> rooms = new ArrayList<Room>();
		for (int i = 0; i < 6; i++) {
			rooms.add(this.createBattleRoomRandomNormalMonster(normalMonsters,normalMonstersRatingOne));
		}
		for (int i = 0; i < 3; i++) {
			rooms.add(this.createMerchantRoomRandomCards(cards));
		}
		for (int i = 0; i < 3; i++) {
			rooms.add(this.createTreasureRoomRandomTreasure(treasures));
		}
		for (int i = 0; i < 3; i++) {
			RoomFactory roomFactory = ServicesFactory.getInstance().getRoomFactoryInstance();
			BonfireRoom bonfireRoom=roomFactory.createBonfireRoom();
		}
		Random random = new Random();

		dungeonMap.setCurrentRoom(startingRoom);

		List<Room> secondLevel = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			secondLevel.add( rooms.remove( random.nextInt( rooms.size() ) ) );
			dungeonMap.addRoom( startingRoom, secondLevel.get(i) );
		}
		for( Room room : secondLevel){
			List<Room> level = new ArrayList<>();
			level.add(room);
			int choose = random.nextInt( 3 );
			for (int i = 0; i < 4; i++) {
				List<Room> actualLevel = new ArrayList<>();
				actualLevel.add( rooms.remove( random.nextInt( rooms.size() ) ) );
				if( choose==i ) actualLevel.add( rooms.remove( random.nextInt( rooms.size() ) ) );
				for (Room r : level){
					for (Room r1 : actualLevel){
						dungeonMap.addRoom(r,r1);
					}
				}
				level = new ArrayList<>(actualLevel);
			}
		}

		
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