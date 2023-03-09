package view;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

class ChooseDifficultyView {

    private String inputValue;

    private static ChooseDifficultyView instance;

    private ChooseDifficultyView(){

    }

    public static ChooseDifficultyView getInstance(){
        if(ChooseDifficultyView.instance == null){
            ChooseDifficultyView.instance = new ChooseDifficultyView();
        }
        return ChooseDifficultyView.instance;
    }

    public void output(String nickname, Set<String> difficultys){
        Scanner prompt = new Scanner(System.in);
        //Todo choose questions and answers
        System.out.println(nickname +" domanda... :");
        Object[] difficultyArray = difficultys.toArray();
        for (int i = 1; i < difficultyArray.length+1; i++) {
            System.out.println( "\u001B[32m ("+i+") \u001B[0m"+ difficultyArray[i-1]);
        }
        System.out.print("DAPP\\chooseDifficulty>");
        this.inputValue = difficultyArray[Integer.parseInt(prompt.next())-1].toString();
        System.out.println("...\n...\n...\n");
    }

    public String input(){
        return this.inputValue;
    }
}
