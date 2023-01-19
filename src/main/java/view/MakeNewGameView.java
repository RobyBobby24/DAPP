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
        if(MakeNewGameView.instance==null){
            MakeNewGameView.instance=new MakeNewGameView();
        }
        return MakeNewGameView.instance;
    }

    public void output(String nickname, List<Adventurer> adventurers) throws ClassNotFoundException {
        Scanner prompt= new Scanner(System.in);
        System.out.println(nickname+" scegli un avventuriero tra i seguenti : \n");
        for(Adventurer adv: adventurers){
            System.out.println(adv.var_dump()+" ("+adv.getClass().getSimpleName()+")\n");
        }
        System.out.print("DAPP\\chooseAdventurer>");
        this.inputValue=Class.forName(prompt.next());
    }

    public Class input(){
        return this.inputValue;
    }
}
