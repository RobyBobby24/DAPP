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

	public void chooseOperation(){
		try{
			if(Player.getInstance().getNickname()==null){
				this.setNickname();
				this.makeNewGame();
			}
			else{
				FrontView.getInstance().outputChooseOperation();//output chooseOperation(setNickname,makeNewGame)
				String operation=FrontView.getInstance().inputChooseOperation();
				if(operation.equals("set-nickname"))this.setNickname();
				else if(operation.equals("make-new-game"))this.makeNewGame();
			}
		}
		catch(Exception e){

		}

	}

	public void setNickname(){
		try{
			FrontView.getInstance().outputSetNickname();
			String nickname=FrontView.getInstance().inputSetNickname(); //input
			Player.getInstance().setNickname(nickname);
			FrontView.getInstance().setPlayer(Player.getInstance().getNickname());
		}
		catch (Exception e){

		}
	}

	public void makeNewGame() {
		try{
			List<Adventurer> adventurerList=(List<Adventurer>) PersistenceInterface.getIstance().search(new TreeMap<>(),Adventurer.class);
			FrontView.getInstance().outputMakeNewGame(adventurerList);
			chooseAdventurer();
		}
		catch(Exception e){

		}
	}

	/**
	 *
	 */
	public void chooseAdventurer() {
		try{
			AdventurerFactory.getInstance().setAdventurerClass(FrontView.getInstance().inputMakeNewGame());
			ArrayList<Room> availableRooms=DungeonMap.getInstance().giveMeAvailableRooms();
			FrontView.getInstance().outputChooseRoom(availableRooms);
			chooseRoom();
		}
		catch(Exception e){

		}
	}

	/**
	 *
	 */
	public void chooseRoom() {
		try{
			Room room=FrontView.getInstance().inputChooseRoom();
			DungeonMap.getInstance().setCurrentRoom(room);
			room.enterRoom();
		}
		catch(Exception e){

		}
	}

	public void nextBattleOp() {
		int operation=-1;//input
		if(operation==-1)this.passTurn();
		else this.playCard(operation);
	}

	/**
	 * 
	 * @param cardID
	 */
	public void playCard(int cardID) {
		BattleRoom battleRoom= (BattleRoom) DungeonMap.getInstance().getCurrentRoom();
		battleRoom.performEffect(cardID);
	}

	public int chooseTarget() {
		int target=0; //input
		return target;
	}

	public void passTurn() {
		BattleRoom battleRoom= (BattleRoom) DungeonMap.getInstance().getCurrentRoom();
		battleRoom.passTurn();
	}

}