package view;

import java.io.Console;
import java.util.Scanner;

class ChooseOperationView {

    private String inputValue;

    private static ChooseOperationView instance;

    private ChooseOperationView(){

    }

    public static ChooseOperationView getInstance(){
        if(ChooseOperationView.instance==null){
            ChooseOperationView.instance=new ChooseOperationView();
        }
        return ChooseOperationView.instance;
    }

    public void output(String nickname){
        Scanner prompt= new Scanner(System.in);
        System.out.println(nickname+" quale operazione vuoi eseguire ? (set-nickname,make-new-game)");
        System.out.print("DAPP\\chooseOperation>");
        this.inputValue=prompt.next();
    }

    public String input(){
        return this.inputValue;
    }
}
