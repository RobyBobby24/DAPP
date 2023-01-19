package view;

import model.*;

import java.util.List;

public class FrontView {

    private String nickname;
    private static FrontView instance;

    private FrontView(){

    }

    public static FrontView getInstance() {
        if(FrontView.instance==null){
            FrontView.instance=new FrontView();
        }
        return instance;
    }

    public  void setPlayer(String nickname){
        this.nickname=nickname;
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

    public void outputMakeNewGame(List<Adventurer> adventurers) throws ClassNotFoundException {
        MakeNewGameView.getInstance().output(this.nickname, adventurers);
    }

    public Class inputMakeNewGame(){
        return MakeNewGameView.getInstance().input();
    }

    public void outputChooseRoom(List<Room> rooms){
        ChooseRoomView.getInstance().output(this.nickname,rooms);
    }

    public Room inputChooseRoom(){
        return ChooseRoomView.getInstance().input();
    }

    public void outputChooseBattleOp(){
        NextBattleOp.getInstance().outputChooseBattleOp(this.nickname);
    }

    public String inputChooseBattleOp(){
        return NextBattleOp.getInstance().inputChooseBattleOp();
    }

    public void outputPlayCard(List<Card> cards,Adventurer adventurer,BattleRoom room){
        PlayCardView.getInstance().outputPlayCard(this.nickname,cards,adventurer,room);
    }

    public int inputPlayCard(){
        return PlayCardView.getInstance().inputPlayCard();
    }

    public void outputChooseTarget(List<Monster> monsters){
        ChooseTargetView.getInstance().output(this.nickname,monsters);
    }

    public int inputChooseTarget(){
        return ChooseTargetView.getInstance().input();
    }
}
