package view;

import model.Adventurer;

import java.io.Console;
import java.util.List;
import java.util.Scanner;

class MakeNewGameView {

    private Class inputValue;

    private static MakeNewGameView instance;

    private MakeNewGameView(){


    }

    public static MakeNewGameView getInstance(){
        if(MakeNewGameView.instance == null){
            MakeNewGameView.instance = new MakeNewGameView();
        }
        return MakeNewGameView.instance;
    }

    public void output(String nickname, List<Adventurer> adventurers) throws ClassNotFoundException {
        Scanner prompt = new Scanner(System.in);
        System.out.println(nickname + " scegli un avventuriero tra i seguenti : \n");
        for(Adventurer adv: adventurers){
            System.out.println(adv+" \u001B[32m("+adv.getClass().getSimpleName()+")\u001B[0m \n");
        }
        System.out.print("DAPP\\chooseAdventurer>");
        this.inputValue = Class.forName(Adventurer.class.getPackageName() + "."+prompt.next());
        System.out.println("...\n...\n...\n");
    }

    public Class input(){
        return this.inputValue;
    }
}
