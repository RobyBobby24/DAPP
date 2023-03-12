package view;

import model.Monster;

import java.io.Console;
import java.util.List;
import java.util.Scanner;

public class ChooseTargetView {

    private Monster inputValue;

    private static ChooseTargetView instance;

    private ChooseTargetView(){

    }

    public static ChooseTargetView getInstance(){
        if(ChooseTargetView.instance == null){
            ChooseTargetView.instance = new ChooseTargetView();
        }
        return ChooseTargetView.instance;
    }

    public void output(String nickname, List<Monster> monsters){
        Scanner prompt = new Scanner(System.in);
        System.out.println(nickname+" scegli il mostro da attaccare: \n");
        for (int i = 0; i < monsters.size(); i++) {
            System.out.println("\u001B[32m("+String.valueOf(i+1) + ")\u001B[0m " + monsters.get(i));
        }
        System.out.print("DAPP\\chooseTarget>");
        this.inputValue = monsters.get(Integer.parseInt(prompt.next())-1);
        System.out.println("...\n...\n...\n");
    }

    public Monster input(){
        return this.inputValue;
    }
}
