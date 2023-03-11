package view;

import model.Card;

import java.util.List;
import java.util.Scanner;

class ChooseCardToBuyView {

    private model.Card inputValue;

    private static ChooseCardToBuyView instance;

    private ChooseCardToBuyView(){

    }

    public static ChooseCardToBuyView getInstance(){
        if(ChooseCardToBuyView.instance == null){
            ChooseCardToBuyView.instance = new ChooseCardToBuyView();
        }
        return ChooseCardToBuyView.instance;
    }

    public void output(String nickname, List<Card> cards){
        this.inputValue = null;
        Scanner prompt = new Scanner(System.in);
        System.out.println(nickname +" scegli una carta da comprare, puoi anche non comprare nulla");
        System.out.println("exit" + "\u001B[32m ("+1+") \u001B[0m");
        for (int i = 0; i < cards.size(); i++) {
            System.out.println("Card : (" + cards.get(i) + " )" + "\u001B[32m ("+String.valueOf(i+2)+") \u001B[0m");
        }
        System.out.print("DAPP\\chooseCardToBuy>");
        int input = Integer.parseInt( prompt.next() );
        if( input > 1) this.inputValue = cards.get( input - 2 ) ;
        System.out.println("...\n...\n...\n");
    }

    public void outputDidNotBuy(String nickname){
        System.out.println(nickname+" non hai abbastanza soldi per comprare la carta");
        System.out.println("...\n...\n...\n");
    }

    public Card input(){
        return this.inputValue;
    }
}
