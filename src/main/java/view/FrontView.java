package view;

import model.*;

import java.util.List;
import java.util.Set;

public class FrontView {

    private String nickname;
    private static FrontView instance;

    private FrontView(){

    }

    public static FrontView getInstance() {
        if(FrontView.instance == null){
            FrontView.instance = new FrontView();
        }
        return instance;
    }

    public  void setPlayer(String nickname){
        this.nickname = nickname;
    }
    public void outputChooseOperation(){
        ChooseOperationView.getInstance().output(this.nickname);
    }

    public String inputChooseOperation(){
        return ChooseOperationView.getInstance().input();
    }

    public void outputSetNickname(){
        SetNicknameView.getInstance().output(this.nickname);
    }

    public String inputSetNickname(){
        return SetNicknameView.getInstance().input();
    }

    public void outputChooseAdventurer(List<AdventurerDescription> adventurers) throws ClassNotFoundException {
        ChooseAdventurer.getInstance().output(this.nickname, adventurers);
    }

    public  Class inputChooseAdventurer(){
        return ChooseAdventurer.getInstance().input();
    }

    public void outputChooseRoom(List<Room> rooms){
        ChooseRoomView.getInstance().output(this.nickname,rooms);
    }

    public Room inputChooseRoom(){
        return ChooseRoomView.getInstance().input();
    }

    public void outputChooseBattleOp(Adventurer adventurer,BattleRoom room){
        this.outputBattle(adventurer, room);
        NextBattleOp.getInstance().outputChooseBattleOp(this.nickname);
    }

    public String inputChooseBattleOp(){
        return NextBattleOp.getInstance().inputChooseBattleOp();
    }

    public void outputPlayCard(List<Card> cards,Adventurer adventurer,BattleRoom room){
        this.outputBattle(adventurer, room);
        PlayCardView.getInstance().outputPlayCard(this.nickname,cards);
    }

    public Card inputPlayCard(){
        return PlayCardView.getInstance().inputPlayCard();
    }

    public void outputChooseTarget(List<Monster> monsters){
        ChooseTargetView.getInstance().output(this.nickname,monsters);
    }

    public int inputChooseTarget(){
        return ChooseTargetView.getInstance().input();
    }

    public void outputChooseDifficulty(Set<String> difficultys){
        ChooseDifficultyView.getInstance().output(this.nickname,difficultys);
    }

    public String inputChooseDifficulty(){
        return ChooseDifficultyView.getInstance().input();
    }

    public void outputChooseCardToBuy(List<Card> cards){
        ChooseCardToBuyView.getInstance().output(this.nickname,cards);
    }

    public Card inputChooseCardToBuy(){
        return ChooseCardToBuyView.getInstance().input();
    }

    public void outputSkipRest(int restPercentage){
        SkipRestView.getInstance().output(this.nickname,restPercentage);
    }

    public boolean inputSkipRest(){
        return SkipRestView.getInstance().input();
    }

    public void outputChooseTreasure(List<Treasure> treasures){
        ChooseTreasureView.getInstance().output(this.nickname,treasures);
    }

    public void outputChoosenTreasure(String description){
        ChooseTreasureView.getInstance().outputChoosenTreasure(description);
    }

    public Treasure inputChooseTreasure(){
        return ChooseTreasureView.getInstance().input();
    }






    public void outputError(String error){ErrorView.getInstance().output(error,this.nickname);}

    public boolean inputError(){
        return ErrorView.getInstance().input();
    }

    public void outputBattle(Adventurer adventurer,BattleRoom room){
        System.out.println("\n \u001B[34m");
        System.out.println(adventurer);
        for(Monster monster: room.getMonsters()){
            System.out.println(monster);
        }
        System.out.println("\u001B[0m \n");
    }
}
