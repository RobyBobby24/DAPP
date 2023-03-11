package view;

import model.Card;

import java.util.List;
import java.util.Scanner;

class SkipRestView {

    private boolean inputValue;
    private String[] result = {"Si","No"};

    private static SkipRestView instance;

    private SkipRestView(){

    }

    public static SkipRestView getInstance(){
        if(SkipRestView.instance == null){
            SkipRestView.instance = new SkipRestView();
        }
        return SkipRestView.instance;
    }

    public void output(String nickname, int restPercentage) throws Exception {
        Scanner prompt = new Scanner(System.in);
        System.out.println(nickname +" sei nella bonfireRoom, vuoi riposare ? Recupererai il "+restPercentage+"% dei tuoi Hp massimi");
        for (int i = 0; i < this.result.length ; i++) {
            System.out.println(this.result[i] +" \u001B[32m("+String.valueOf(i+1)+")\u001B[0m ");
        }
        System.out.print("DAPP\\restHp>");
        int input = Integer.parseInt( prompt.next() );

        if( this.result[input-1].equals( this.result[0] ) ) this.inputValue = true;
        else if ( this.result[input-1].equals( this.result[1] )) this.inputValue = false;
        else throw new Exception( " input skip rest non valido");

        System.out.println("...\n...\n...\n");
    }

    public boolean input(){
        return this.inputValue;
    }
}
