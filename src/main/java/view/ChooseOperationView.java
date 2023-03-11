package view;

import java.io.Console;
import java.util.Scanner;

class ChooseOperationView {

    private String inputValue;
    private final String[] inputMapping = {"set-nickname","make-new-game","exit"};

    private static ChooseOperationView instance;

    private ChooseOperationView(){

    }

    public static ChooseOperationView getInstance(){
        if(ChooseOperationView.instance == null){
            ChooseOperationView.instance = new ChooseOperationView();
        }
        return ChooseOperationView.instance;
    }

    public void output(String nickname){
        Scanner prompt = new Scanner(System.in);
        System.out.println(nickname +" quale operazione vuoi eseguire ? \n");
        for (int i = 1; i < this.inputMapping.length+1; i++) {
            System.out.println(" \u001B[32m ("+i+") \u001B[0m "+this.inputMapping[i-1]);
        }
        System.out.print("\nDAPP\\chooseOperation>");
        this.inputValue = this.inputMapping[Integer.parseInt(prompt.next())-1];

        System.out.println("...\n...\n...\n");
    }

    public String input(){
        return this.inputValue;
    }
}
