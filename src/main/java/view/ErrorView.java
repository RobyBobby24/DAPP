package view;

import java.util.Scanner;
import java.io.*;

public class ErrorView {

    private static ErrorView instance;

    private final static String[] results = {"Si","No"};
    private boolean inputValue;

    private ErrorView(){

    }

    public static ErrorView getInstance(){
        if(ErrorView.instance == null){
            ErrorView.instance = new ErrorView();
        }
        return ErrorView.instance;
    }

    public void output(String error, String nickname) {
        System.out.println("\u001B[33m" + "\n" + error + "\n" + "\u001B[0m");
        Scanner prompt = new Scanner(System.in);
        int input = -1;
       try{
            System.out.println(nickname +" vuoi eseguire nuovamente l'operazione ?");
           for (int i = 0; i < ErrorView.results.length ; i++) {
               System.out.println(" \u001B[32m("+String.valueOf(i+1)+")\u001B[0m "+ErrorView.results[i]);
           }
            System.out.print("DAPP\\chooseExecuteAgain>");
            input = Integer.parseInt( prompt.next() ) - 1;
            if(input == 1) this.inputValue = false;
            else if (input == 0) this.inputValue = true;
        }
       catch(Exception e){
           output(error,nickname);
       }
        System.out.println("...\n...\n...\n");
    }

    public boolean input(){
        return this.inputValue;
    }

}
