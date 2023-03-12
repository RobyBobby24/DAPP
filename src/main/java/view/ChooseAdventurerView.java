package view;

import model.Adventurer;
import model.AdventurerDescription;

import java.util.List;
import java.util.Scanner;

class ChooseAdventurerView {

    private Class inputValue;

    private static ChooseAdventurerView instance;

    private ChooseAdventurerView(){


    }

    public static ChooseAdventurerView getInstance(){
        if(ChooseAdventurerView.instance == null){
            ChooseAdventurerView.instance = new ChooseAdventurerView();
        }
        return ChooseAdventurerView.instance;
    }

    public void output(String nickname, List<AdventurerDescription> adventurers) throws ClassNotFoundException {
        Scanner prompt = new Scanner(System.in);
        System.out.println(nickname + " scegli un avventuriero tra i seguenti : \n");
        for (int i = 0; i < adventurers.size() ; i++) {
            System.out.println(" \u001B[32m("+String.valueOf(i+1)+")\u001B[0m "+adventurers.get(i));
        }
        System.out.print("\nDAPP\\chooseAdventurer>");
        int input = Integer.parseInt(prompt.next());
        this.inputValue = Class.forName(Adventurer.class.getPackageName() + "."+adventurers.get(input-1).getType());
        System.out.println("...\n...\n...\n");
    }

    public Class input(){
        return this.inputValue;
    }
}
