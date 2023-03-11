package view;

import java.util.Scanner;

class NextBattleOpView {

    private String inputValue;

    private int inputCardId;

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
        System.out.println(nickname+" quale operazione di battaglia vuoi eseguire ? \u001B[32m (play-card,pass-turn)\u001B[0m \n");
        System.out.print("DAPP\\chooseBattleOp>");
        this.inputValue = prompt.next();
        System.out.println("...\n...\n...\n");
    }

    public String inputChooseBattleOp(){
        return this.inputValue;
    }

    public void outputChooseCardToPlay(String nickname){
        Scanner prompt = new Scanner(System.in);
        System.out.println(nickname+" quale operazione di battaglia vuoi eseguire ? (play-card,pass-turn)\n");
        System.out.print("DAPP\\chooseBattleOp>");
        this.inputCardId = Integer.parseInt(prompt.next());
    }

    public int inputChooseCardToPlay(){
        return this.inputCardId;
    }
}
