package view;

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
        System.out.println(nickname +" scegli un baule tra quelli a disposizione");
        for (int i = 0; i < treasures.size(); i++) {
            System.out.println(treasures.get(i).toStringContainHide() + " \u001B[32m ("+String.valueOf(i+1)+") \u001B[0m");
        }
        System.out.print("DAPP\\chooseTreasure>");
        this.inputValue = treasures.get( Integer.parseInt(prompt.next()) -1);
        System.out.println("...\n...\n...\n");
    }
    public void outputChoosenTreasure(Treasure treasure){
        System.out.println(" Il baule contiene : "+treasure);

    }

    public Treasure input(){
        return this.inputValue;
    }
}
