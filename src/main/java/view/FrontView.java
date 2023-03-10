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
        ChooseAdventurerView.getInstance().output(this.nickname, adventurers);
    }

    public  Class inputChooseAdventurer(){
        return ChooseAdventurerView.getInstance().input();
    }

    public void outputChooseRoom(List<Room> rooms){
        ChooseRoomView.getInstance().output(this.nickname,rooms);
    }

    public Room inputChooseRoom(){
        return ChooseRoomView.getInstance().input();
    }

    public void outputChooseBattleOp(Adventurer adventurer,BattleRoom room){
        this.outputBattle(room);
        NextBattleOpView.getInstance().outputChooseBattleOp(this.nickname);
    }

    public String inputChooseBattleOp(){
        return NextBattleOpView.getInstance().inputChooseBattleOp();
    }

    public void outputPlayCard(List<Card> cards,Adventurer adventurer,BattleRoom room){
        this.outputBattle(room);
        PlayCardView.getInstance().outputPlayCard(this.nickname,cards);
    }

    public Card inputPlayCard(){
        return PlayCardView.getInstance().inputPlayCard();
    }

    public void outputChooseTarget(List<Monster> monsters){
        ChooseTargetView.getInstance().output(this.nickname,monsters);
    }

    public Monster inputChooseTarget(){
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

    public void outputSkipRest(int restPercentage) throws Exception {
        SkipRestView.getInstance().output(this.nickname,restPercentage);
    }

    public boolean inputSkipRest(){
        return SkipRestView.getInstance().input();
    }

    public void outputDidNotBuy(){
        ChooseCardToBuyView.getInstance().outputDidNotBuy( this.nickname );
    }

    public void outputChooseTreasure(List<Treasure> treasures){
        ChooseTreasureView.getInstance().output(this.nickname,treasures);
    }

    public void outputChoosenTreasure(Treasure treasure){
        ChooseTreasureView.getInstance().outputChoosenTreasure(treasure);
    }

    public Treasure inputChooseTreasure(){
        return ChooseTreasureView.getInstance().input();
    }


    public void outputYouWon( int coinsReward){
        NextBattleOpView.getInstance().outputYouWon( this.nickname , coinsReward );
    }

    public void outputYouLost(){
        NextBattleOpView.getInstance().outputYouLost( this.nickname );
    }

    public void outputLastBattle(){
        NextBattleOpView.getInstance().outputLastBattle( this.nickname );
    }




    public void outputError(String error){ErrorView.getInstance().output(error,this.nickname);}

    public boolean inputError(){
        return ErrorView.getInstance().input();
    }

    public void outputBattle(BattleRoom room){
        System.out.println("\n \u001B[34m");
        System.out.println(Adventurer.getInstance());
        for(Monster monster: room.getMonsters()){
            System.out.println(monster);
        }
        System.out.println("\u001B[0m \n");
    }

    public void outputAdventurerState(){
        System.out.println("\n \u001B[34m");
        System.out.println( Adventurer.getInstance().toStringWithCoins() );
        System.out.println("\u001B[0m \n");
    }
}
