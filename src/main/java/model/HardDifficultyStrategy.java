package model;

import services.ConfigurationReader;
import services.PersistenceInterface;

import java.io.IOException;
import java.util.*;

public class HardDifficultyStrategy implements BuildMapDifficultyStrategy {

	int numberOfLevel=6;
	int numberOfBattleRoom=8;
	int numberOfMerchantRoom=3;
	int numberOfTreasureRoom=3;
	int numberOfBonfireRoom=3;

	public HardDifficultyStrategy() throws IOException, ClassNotFoundException {
		String difficultyStrategyName = "Hard";
		this.numberOfLevel = ConfigurationReader.getInstance().getDifficultyStrategyParameter(difficultyStrategyName,"numberOfLevel");
		this.numberOfBattleRoom = ConfigurationReader.getInstance().getDifficultyStrategyParameter(difficultyStrategyName,"numberOfBattleRoom");
		this.numberOfMerchantRoom = ConfigurationReader.getInstance().getDifficultyStrategyParameter(difficultyStrategyName,"numberOfMerchantRoom");
		this.numberOfTreasureRoom = ConfigurationReader.getInstance().getDifficultyStrategyParameter(difficultyStrategyName,"numberOfTreasureRoom");
		this.numberOfBonfireRoom = ConfigurationReader.getInstance().getDifficultyStrategyParameter(difficultyStrategyName,"numberOfBonfireRoom");
	}

	public void buildMap(DungeonMap dungeonMap) throws IOException {
		ArrayList<TreeMap<String,String>> clause= new ArrayList<>();
		ArrayList<String> operation= new ArrayList<>();
		TreeMap<String,String> key_value_equal = new TreeMap<>();
		TreeMap<String,String> key_value_lessEqual = new TreeMap<>();

		//query normal monsters with challengeRating<=2
		key_value_equal.put("type","normal");
		operation.add("=");
		clause.add(key_value_equal);

		key_value_lessEqual.put("challengeRating","3");
		operation.add("<=");
		clause.add(key_value_lessEqual);

		List<Monster>  normalMonsters = (List<Monster>) PersistenceInterface.getInstance().complexSearch(clause,operation,Monster.class);


		//query normal monsters with challengeRating<=2
		key_value_lessEqual.put("challengeRating","2");

		List<Monster> normalMonstersRatingTwo = (List<Monster>) PersistenceInterface.getInstance().complexSearch(clause,operation,Monster.class);


		//query normal monsters with challengeRating<=1
		key_value_lessEqual.put("challengeRating","1");

		List<Monster> normalMonstersRatingOne = (List<Monster>) PersistenceInterface.getInstance().complexSearch(clause,operation,Monster.class);


		Collections.shuffle(normalMonsters);

		//query boss monsters with challengeRating=2
		key_value_equal.put("type","boss");
		key_value_equal.put("challengeRating","2");
		List<Monster>  bossMonsters = (List<Monster>) PersistenceInterface.getInstance().search(key_value_equal,Monster.class);

		//query cards
		List<Card>  cards = (List<Card>) PersistenceInterface.getInstance().search(new TreeMap<>(),Card.class);

		//query treasures
		List<Treasure>  treasures = (List<Treasure>) PersistenceInterface.getInstance().search(new TreeMap<>(),Treasure.class);

		BattleRoom startingRoom = this.createBattleRoomRandomNormalMonster( normalMonsters , normalMonstersRatingOne , normalMonstersRatingTwo );

		List<Room> rooms = this.takeRooms( normalMonsters , normalMonstersRatingOne , normalMonstersRatingTwo , cards , treasures );

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


	private List<Room> takeRooms(List<Monster> normalMonsters, List<Monster> normalMonstersRatingOne , List<Monster> normalMonstersRatingTwo , List<Card>  cards, List<Treasure>  treasures ) throws IOException {

		List<Room> rooms = new ArrayList<Room>();
		for (int i = 0; i < numberOfBattleRoom-2; i++) {
			rooms.add(this.createBattleRoomRandomNormalMonster(normalMonsters,normalMonstersRatingOne,normalMonstersRatingTwo));
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

	private BattleRoom createBattleRoomRandomNormalMonster(List<Monster> monsters, List<Monster> monstersRatingOne , List<Monster> monstersRatingTwo ){
		Random random = new Random();
		RoomFactory roomFactory = ServicesFactory.getInstance().getRoomFactoryInstance();
		BattleRoom battleRoom = roomFactory.createBattleRoom();
		int number = random.nextInt( monsters.size() );
		Monster monster = monsters.get( number );
		battleRoom.addMonster( monster );
		double monsterRating=monster.getChallengeRating();
		while( monsterRating<=1 ){
			number = random.nextInt(  monstersRatingTwo.size() );
			monsterRating = monsterRating + monstersRatingTwo.get(number).getChallengeRating();
			battleRoom.addMonster(  monstersRatingTwo.get(number) );
		}
		while( monsterRating<=2 ){
			number = random.nextInt(  monstersRatingOne.size() );
			monsterRating = monsterRating + monstersRatingOne.get(number).getChallengeRating();
			battleRoom.addMonster(  monstersRatingOne.get(number) );
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