package view;

import java.io.Console;
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



    public void outputPlayCard(String nickname){
        Scanner prompt= new Scanner(System.in);
        System.out.println(nickname+" quale operazione di battaglia vuoi eseguire ? (play-card,pass-turn)\n");
        System.out.print("DAPP\\chooseBattleOp>");
        this.inputValue=Integer.parseInt(prompt.next());
    }

    public int inputPlayCard(){
        return this.inputValue;
    }
}
