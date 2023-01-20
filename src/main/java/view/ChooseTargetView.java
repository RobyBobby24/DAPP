package view;

import model.Monster;

import java.io.Console;
import java.util.List;
import java.util.Scanner;

public class ChooseTargetView {

    private int inputValue;

    private static ChooseTargetView instance;

    private ChooseTargetView(){

    }

    public static ChooseTargetView getInstance(){
        if(ChooseTargetView.instance==null){
            ChooseTargetView.instance=new ChooseTargetView();
        }
        return ChooseTargetView.instance;
    }

    public void output(String nickname, List<Monster> monsters){
        Scanner prompt= new Scanner(System.in);
        System.out.println(nickname+" scegli il mostro da attaccare: \n");
        for (int i = 0; i < monsters.size(); i++) {
            System.out.println(monsters.get(i)+"\u001B[32m("+monsters.get(i).getId()+")\u001B[0m");
        }
        System.out.print("DAPP\\chooseTarget>");
        this.inputValue=Integer.parseInt(prompt.next());
        System.out.println("...\n...\n...\n");
    }

    public int input(){
        return this.inputValue;
    }
}
