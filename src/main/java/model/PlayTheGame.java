package model;

import services.ConfigurationReader;
import services.PersistenceInterface;
import view.FrontView;
import view.NavigateDungeonMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import static java.lang.System.exit;

public class PlayTheGame {

	private static PlayTheGame instance;
	private int endGame;

	private PlayTheGame() {

	}

	public static PlayTheGame getInstance() {
		if(PlayTheGame.instance == null){
			PlayTheGame.instance = new PlayTheGame();
		}
		return PlayTheGame.instance;
	}

	public int getEndGame() {
		return this.endGame;
	}


	public void setEndGame(int endGame) {
		this.endGame = endGame;
	}
	/*
	public boolean getEndGame() {
		if( this.endGame == 0)return false;
		else return true;
	}


	public void setEndGame(boolean endGame) {
		if( endGame ) this.endGame = 1;
		else this.endGame = 0;
	}

	public void setLost() {
		this.endGame = -1;
	}

	public boolean getLost() {
		if( this.endGame == -1) return true;
		return false;
	}
	 */
	/**
	 * choose an operation between set-nickname e make-new-game
	 */
	public void chooseOperation(){
		try{
			if(Player.getInstance().getNickname() == null){
				this.setNickname();
			}
			else{
				FrontView.getInstance().setPlayer(Player.getInstance().getNickname());
				FrontView.getInstance().outputChooseOperation();//output chooseOperation(setNickname,makeNewGame)
				String operation = FrontView.getInstance().inputChooseOperation();
				if(operation.equals("set-nickname"))
					this.setNickname();
				else if(operation.equals("make-new-game"))
					this.makeNewGame();
				else if(operation.equals("exit")==false) throw new Exception("operazione non valida");
			}
		}
		catch(Exception e){
			FrontView.getInstance().outputError("l'operazione inserita non è valida");
			if(FrontView.getInstance().inputError()) this.chooseOperation();
			exit(0);
		}

	}

	/**
	 * set new nickname
	 */
	public void setNickname(){
		try{
			FrontView.getInstance().outputSetNickname();
			String nickname = FrontView.getInstance().inputSetNickname(); //input
			Player.getInstance().setNickname(nickname);
			FrontView.getInstance().setPlayer(Player.getInstance().getNickname());
			if(PersistenceInterface.getInstance().exist(new TreeMap<>(),Player.class)){
				PersistenceInterface.getInstance().update(Player.getInstance());
			}
			else
				PersistenceInterface.getInstance().store(Player.getInstance());
			this.chooseOperation();
		}
		catch (Exception e){
			FrontView.getInstance().outputError("l'operazione non è andata a buon fine");
			if(FrontView.getInstance().inputError()) this.setNickname();
			else this.restartGame();
			exit(0);
		}
	}

	/**
	 * start the game
	 */
	public void makeNewGame() {
		try{
			this.chooseDifficulty();
			this.chooseAdventurer();
			this.playGame();
			this.restartGame();
		}
		catch(Exception e){
			FrontView.getInstance().outputError("l'operazione non è andata a buon fine!!!");
			if(FrontView.getInstance().inputError()) this.makeNewGame();
			else this.restartGame();
			exit(0);
		}
	}

	public void chooseDifficulty() {
		try{
			Set<String> difficultyStrategyNameSet = ConfigurationReader.getInstance().getDifficultyStrategyNameSet();
			FrontView.getInstance().outputChooseDifficulty(difficultyStrategyNameSet);
			String difficultyStrategyName = FrontView.getInstance().inputChooseDifficulty();
			DungeonMap.getInstance().setDifficulty( ServicesFactory.getInstance().getDifficultyStrategyInstance( difficultyStrategyName ));
			DungeonMap.getInstance().buildMap();
		}
		catch (Exception e){
			FrontView.getInstance().outputError("l'operazione non è andata a buon fine!!!");
			if(FrontView.getInstance().inputError()) this.chooseDifficulty();
			else this.restartGame();
			exit(0);
		}
	}

	/**
	 * set the new adventurer chosen
	 */
	public void chooseAdventurer() {
		try{
			List<AdventurerDescription> adventurerList = (List<AdventurerDescription>) PersistenceInterface.getInstance().search(new TreeMap<>(), AdventurerDescription.class);
			FrontView.getInstance().outputChooseAdventurer(adventurerList);
			ConfigurationReader.getInstance().setAdventurerClass(FrontView.getInstance().inputChooseAdventurer());
		}
		catch(Exception e){
			FrontView.getInstance().outputError("l'operazione non è andata a buon fine!!!");
			if(FrontView.getInstance().inputError()) this.chooseAdventurer();
			else this.restartGame();
			exit(0);
		}
	}

	public void playGame() {
		try{
			this.setEndGame(0);
			while( this.getEndGame() == 0){
				this.chooseRoom();
			}
		}
		catch(Exception e){
			FrontView.getInstance().outputError("l'operazione non è andata a buon fine!!!");
			if(FrontView.getInstance().inputError()) this.playGame();
			else this.restartGame();
			exit(0);
		}
	}

	/**
	 * set new room chosen
	 */
	public void chooseRoom() {
		try{
			List<Room> availableRoom = DungeonMap.getInstance().giveMeAvailableRooms();
			FrontView.getInstance().outputChooseRoom(availableRoom);
			Room room = FrontView.getInstance().inputChooseRoom();
			DungeonMap.getInstance().setCurrentRoom(room);
			room.enterRoom();
		}
		catch(Exception e){
			e.printStackTrace();
			FrontView.getInstance().outputError("l'avvio della stanza non è andato a buon fine!!!");
			if(FrontView.getInstance().inputError()) this.chooseRoom();
			else this.restartGame();
			exit(0);
		}
	}

	public void restartGame() {
		try{
			if( this.getEndGame() == 1 ) {
				Adventurer.getInstance().getHp().resetCurrentHp();
				PersistenceInterface.getInstance().update( Adventurer.getInstance() );
			}
			Adventurer.resetAdventurer();
			DungeonMap.resetDungeonMap();
			this.chooseOperation();
		}
		catch ( Exception e){
			FrontView.getInstance().outputError("l'avvio della stanza non è andato a buon fine!!!");
			if(FrontView.getInstance().inputError()) this.restartGame();
			exit(0);
		}
	}

}