package view;

import java.util.Scanner;
import java.io.*;

public class ErrorView {

    private static ErrorView instance;

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
        String input = "";
        while(input.equals("no")==false && input.equals("si")==false){
            System.out.println(nickname +" vuoi eseguire nuovamente l'operazione ? \u001B[32m (si,no) \u001B[0m");
            System.out.print("DAPP\\chooseOperation>");
            input = prompt.next();
            if(input.equals("no")) this.inputValue = false;
            else if (input.equals("si")) this.inputValue = true;
        }
        System.out.println("...\n...\n...\n");
    }

    public boolean input(){
        return this.inputValue;
    }

}
