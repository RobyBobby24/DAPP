package view;

import model.Card;

import java.util.List;
import java.util.Scanner;

class SkipRestView {

    private boolean inputValue;

    private static SkipRestView instance;

    private SkipRestView(){

    }

    public static SkipRestView getInstance(){
        if(SkipRestView.instance == null){
            SkipRestView.instance = new SkipRestView();
        }
        return SkipRestView.instance;
    }

    public void output(String nickname, int restPercentage){
        Scanner prompt = new Scanner(System.in);
        //Todo choose questions and answers
        System.out.println(nickname +" domanda... ? \u001B[32m (risposta1,risposta2) \u001B[0m");
        System.out.print("DAPP\\skipRest>");
        //Todo set inputValue
        //this.inputValue = prompt.next();
        System.out.println("...\n...\n...\n");
    }

    public boolean input(){
        return this.inputValue;
    }
}
