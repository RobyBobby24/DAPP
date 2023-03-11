package view;

import model.Adventurer;
import model.BattleRoom;
import model.Card;
import model.Monster;

import java.io.Console;
import java.util.List;
import java.util.Scanner;

public class PlayCardView {

    private Card inputValue;

    private static PlayCardView instance;

    private PlayCardView(){

    }

    public static PlayCardView getInstance(){
        if(PlayCardView.instance == null){
            PlayCardView.instance = new PlayCardView();
        }
        return PlayCardView.instance;
    }



    public void outputPlayCard(String nickname, List<Card> handCards){
        Scanner prompt = new Scanner(System.in);
        System.out.println(nickname+" quale carta vuoi giocare :");
        for (int i = 0; i < handCards.size() ; i++) {
            System.out.println("Card: ("+handCards.get(i)+") \u001B[32m ("+String.valueOf(i+1)+")\u001B[0m");
        }
        System.out.print("DAPP\\PlayCard>");
        this.inputValue = handCards.get( Integer.parseInt(prompt.next())-1 );
        System.out.println("...\n...\n...\n");
    }

    public Card inputPlayCard(){
        return this.inputValue;
    }
}
