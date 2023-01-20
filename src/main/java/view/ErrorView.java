package view;

import java.util.Scanner;
import java.io.*;

public class ErrorView {

    private static ErrorView instance;

    private ErrorView(){

    }

    public static ErrorView getInstance(){
        if(ErrorView.instance==null){
            ErrorView.instance=new ErrorView();
        }
        return ErrorView.instance;
    }

    public void output(String error) {
        System.out.println("\u001B[33m" + "\n" + error + "\n" + "\u001B[0m");
    }

}
