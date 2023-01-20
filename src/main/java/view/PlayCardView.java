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



    public void outputPlayCard(String nickname, List<Card> handCards){
        Scanner prompt= new Scanner(System.in);
        System.out.println(nickname+" quale carta vuoi giocare :");
        for(Card card: handCards){
            System.out.println("Card: ("+card+") \u001B[32m ("+card.getID()+")\u001B[0m");
        }
        System.out.print("DAPP\\PlayCard>");
        this.inputValue=Integer.parseInt(prompt.next());
        System.out.println("...\n...\n...\n");
    }

    public int inputPlayCard(){
        return this.inputValue;
    }
}
