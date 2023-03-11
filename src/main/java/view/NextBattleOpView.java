package view;

import java.util.Scanner;

class NextBattleOpView {

    private String inputValue;

    private int inputCardId;
    private final String[] results = { "play-card" , "pass-turn" };

    private static NextBattleOpView instance;

    private NextBattleOpView(){

    }

    public static NextBattleOpView getInstance(){
        if(NextBattleOpView.instance == null){
            NextBattleOpView.instance = new NextBattleOpView();
        }
        return NextBattleOpView.instance;
    }

    public void outputChooseBattleOp(String nickname){
        Scanner prompt = new Scanner(System.in);
        System.out.println(nickname+" quale operazione di battaglia vuoi eseguire ? \n");
        for (int i = 0; i < this.results.length ; i++) {
            System.out.println(this.results[i] +" \u001B[32m("+String.valueOf(i+1)+")\u001B[0m ");
        }
        System.out.print("DAPP\\chooseBattleOp>");
        int input = Integer.parseInt( prompt.next() );
        this.inputValue = this.results[input-1];
        System.out.println("...\n...\n...\n");
    }

    public String inputChooseBattleOp(){
        return this.inputValue;
    }

    public void outputYouWon(String nickname, int coinsReward){
        System.out.println("Complimenti "+nickname+", hai vinto!!! Hai guadagnato "+coinsReward+" monete.");
        System.out.println("...\n...\n...\n");
    }

    public void outputYouLost(String nickname){
        System.out.println(nickname+" hai perso.");
        System.out.println("...\n...\n...\n");
    }

    public void outputLastBattle(String nickname){
        System.out.println("Complimenti "+nickname+", sei arrivato alla battaglia finale");
        System.out.println("...\n...\n...\n");
    }
}
