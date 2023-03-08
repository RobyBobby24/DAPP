package view;

import model.Card;
import model.Treasure;

import java.util.List;
import java.util.Scanner;

class ChooseTreasureView {

    private Treasure inputValue;

    private static ChooseTreasureView instance;

    private ChooseTreasureView(){

    }

    public static ChooseTreasureView getInstance(){
        if(ChooseTreasureView.instance == null){
            ChooseTreasureView.instance = new ChooseTreasureView();
        }
        return ChooseTreasureView.instance;
    }

    public void output(String nickname, List<Treasure> treasures){
        Scanner prompt = new Scanner(System.in);
        //Todo choose questions and answers
        System.out.println(nickname +" domanda... :");
        for (int i = 0; i < treasures.size(); i++) {
            System.out.println(treasures.get(i) + "\u001B[32m ("+i+") \u001B[0m");
        }
        System.out.print("DAPP\\chooseTreasure>");
        //Todo set inputValue
        //this.inputValue = prompt.next();
        System.out.println("...\n...\n...\n");
    }
    public void outputChoosenTreasure(String description){


    }

    public Treasure input(){
        return this.inputValue;
    }
}
