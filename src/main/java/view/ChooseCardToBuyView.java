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
        Scanner prompt = new Scanner(System.in);
        //Todo choose questions and answers
        System.out.println(nickname +" domanda... :");
        for (int i = 0; i < cards.size(); i++) {
            System.out.println(cards.get(i) + "\u001B[32m ("+i+") \u001B[0m");
        }
        System.out.print("DAPP\\chooseCardToBuy>");
        //Todo set inputValue
        //this.inputValue = prompt.next();
        System.out.println("...\n...\n...\n");
    }

    public Card input(){
        return this.inputValue;
    }
}
