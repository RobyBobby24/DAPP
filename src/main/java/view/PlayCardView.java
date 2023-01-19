package view;

import model.Adventurer;
import model.BattleRoom;
import model.Card;
import model.Monster;

import java.io.Console;
import java.util.List;
import java.util.Scanner;

public class PlayCardView {

    private int inputValue;

    private static PlayCardView instance;

    private PlayCardView(){

    }

    public static PlayCardView getInstance(){
        if(PlayCardView.instance==null){
            PlayCardView.instance=new PlayCardView();
        }
        return PlayCardView.instance;
    }



    public void outputPlayCard(String nickname, List<Card> handCards, Adventurer adventurer, BattleRoom room){
        Scanner prompt= new Scanner(System.in);
        System.out.println("Adventurer: hp="+adventurer.getHp().getCurrentHp()+"/"+adventurer.getHp().getMaxHp()+" energyPoint:"+adventurer.getEnergyPoint());
        for(Monster monster: room.getMonsters()){
            System.out.println(monster.getName()+": hp="+monster.getHp().getCurrentHp()+"/"+monster.getHp().getMaxHp());
        }
        System.out.println(nickname+" quale carta vuoi giocare :");
        for(Card card: handCards){
            System.out.println(card.var_dump()+" ("+card.getID()+")");
        }
        System.out.print("DAPP\\PlayCard>");
        this.inputValue=Integer.parseInt(prompt.next());
    }

    public int inputPlayCard(){
        return this.inputValue;
    }
}
