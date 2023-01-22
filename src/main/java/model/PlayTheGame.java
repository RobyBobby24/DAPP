package model;

import services.PersistenceInterface;
import view.FrontView;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class PlayTheGame {

	private static PlayTheGame instance;

	private PlayTheGame() {

	}

	public static PlayTheGame getInstance() {
		if(PlayTheGame.instance==null){
			PlayTheGame.instance=new PlayTheGame();
		}
		return PlayTheGame.instance;
	}

	/**
	 * choose an operation between set-nickname e make-new-game
	 */
	public void chooseOperation(){
		try{
			if(Player.getInstance().getNickname()==null){
				this.setNickname();
			}
			else{
				FrontView.getInstance().setPlayer(Player.getInstance().getNickname());
				FrontView.getInstance().outputChooseOperation();//output chooseOperation(setNickname,makeNewGame)
				String operation=FrontView.getInstance().inputChooseOperation();
				if(operation.equals("set-nickname"))this.setNickname();
				else if(operation.equals("make-new-game"))this.makeNewGame();
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());

		}

	}

	/**
	 * set new nickname
	 */
	public void setNickname(){
		try{
			FrontView.getInstance().outputSetNickname();
			String nickname=FrontView.getInstance().inputSetNickname(); //input
			Player.getInstance().setNickname(nickname);
			FrontView.getInstance().setPlayer(Player.getInstance().getNickname());
			if(PersistenceInterface.getInstance().exist(new TreeMap<>(),Player.class)){
				PersistenceInterface.getInstance().update(Player.getInstance());
			}
			else PersistenceInterface.getInstance().store(Player.getInstance());
			this.chooseOperation();
		}
		catch (Exception e){
			System.out.println(e.getMessage());

		}
	}

	/**
	 * start the game
	 */
	public void makeNewGame() {
		try{
			List<Adventurer> adventurerList=(List<Adventurer>) PersistenceInterface.getInstance().search(new TreeMap<>(),Adventurer.class);
			FrontView.getInstance().outputMakeNewGame(adventurerList);
			chooseAdventurer();
		}
		catch(Exception e){
			FrontView.getInstance().outputError("l'avventuriero inserito non è valido!!!");
			this.makeNewGame();

		}
	}

	/**
	 * set the new adventurer chosen
	 */
	public void chooseAdventurer() {
		try{
			AdventurerFactory.getInstance().setAdventurerClass(FrontView.getInstance().inputMakeNewGame());
			ArrayList<Room> availableRooms=DungeonMap.getInstance().giveMeAvailableRooms();
			FrontView.getInstance().outputChooseRoom(availableRooms);
			chooseRoom();
		}
		catch(Exception e){
			FrontView.getInstance().outputError("la stanza scelta non è valida!!!");
			this.chooseAdventurer();
		}
	}

	/**
	 * set new room chosen
	 */
	public void chooseRoom() {
		try{
			Room room=FrontView.getInstance().inputChooseRoom();
			DungeonMap.getInstance().setCurrentRoom(room);
			room.enterRoom();
		}
		catch(Exception e){
			FrontView.getInstance().outputError("l'avvio della battaglia non è andato a buon fine!!!");
			this.chooseRoom();
		}
	}

	/**
	 * choose next battle operation
	 */
	public void nextBattleOp() {
		try{
			BattleRoom battleRoom=(BattleRoom) DungeonMap.getInstance().getCurrentRoom();
			FrontView.getInstance().outputChooseBattleOp(Adventurer.getInstance(),battleRoom);
			String operation=FrontView.getInstance().inputChooseBattleOp();//input
			if(operation.equals("pass-turn"))this.passTurn();
			else if (operation.equals("play-card"))this.playCard();
			else throw new Exception("operation selected do not exist");
		}
		catch (Exception e){
			FrontView.getInstance().outputError("l'operazione selezionata non è supportata!!!");
			this.nextBattleOp();
		}

	}

	/**
	 * play the card chosen
	 */
	public void playCard() {
		try{
			List<Card> cards=Adventurer.getInstance().getCardsFromHand();
			BattleRoom battleRoom=(BattleRoom) DungeonMap.getInstance().getCurrentRoom();
			Adventurer adventurer=Adventurer.getInstance();
			FrontView.getInstance().outputPlayCard(cards,adventurer,battleRoom);
			battleRoom.performEffect(FrontView.getInstance().inputPlayCard());
		}
		catch (Exception e){
			FrontView.getInstance().outputError("la carta selezionata non è disponibile!!!");
			this.playCard();
		}
	}

	/**
	 * @return the target chosen
	 */
	public int chooseTarget() {
		try{
			BattleRoom room=(BattleRoom) DungeonMap.getInstance().getCurrentRoom();
			List<Monster> monsters=room.getMonsters();
			FrontView.getInstance().outputChooseTarget(monsters);
			return FrontView.getInstance().inputChooseTarget();
		}
		catch (Exception e){
			FrontView.getInstance().outputError("il target selezionato non è valido!!!");
			return this.chooseTarget();
		}
	}

	/**
	 * pass turn to the monsters
	 */
	public void passTurn() {
		try{
			BattleRoom battleRoom= (BattleRoom) DungeonMap.getInstance().getCurrentRoom();
			battleRoom.passTurn();
		}
		catch(Exception e){
			FrontView.getInstance().outputError("non siamo riusciti a passre il turno!!!");
			this.nextBattleOp();
		}
	}

}