package view;

import java.util.List;
import java.util.Scanner;

class ChooseDifficultyView {

    private model.BuildMapDifficultyStrategy inputValue;

    private static ChooseDifficultyView instance;

    private ChooseDifficultyView(){

    }

    public static ChooseDifficultyView getInstance(){
        if(ChooseDifficultyView.instance == null){
            ChooseDifficultyView.instance = new ChooseDifficultyView();
        }
        return ChooseDifficultyView.instance;
    }

    public void output(String nickname, List<String> difficultys){
        Scanner prompt = new Scanner(System.in);
        //Todo choose questions and answers
        System.out.println(nickname +" domanda... :");
        for (int i = 0; i < difficultys.size(); i++) {
            System.out.println(difficultys.get(i) + "\u001B[32m ("+i+") \u001B[0m");
        }
        System.out.print("DAPP\\chooseDifficulty>");
        //Todo set inputValue
        //this.inputValue = prompt.next();
        System.out.println("...\n...\n...\n");
    }

    public model.BuildMapDifficultyStrategy input(){
        return this.inputValue;
    }
}
