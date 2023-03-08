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
        String[] difficultyArray = (String[]) difficultys.toArray();
        for (int i = 0; i < difficultyArray.length; i++) {
            System.out.println(difficultyArray[i] + "\u001B[32m ("+i+") \u001B[0m");
        }
        System.out.print("DAPP\\chooseDifficulty>");
        //Todo set inputValue
        //this.inputValue = prompt.next();
        System.out.println("...\n...\n...\n");
    }

    public String input(){
        return this.inputValue;
    }
}
