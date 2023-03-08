package view;

import model.Adventurer;
import model.AdventurerDescription;

import java.util.List;
import java.util.Scanner;

class ChooseAdventurer {

    private Class inputValue;

    private static ChooseAdventurer instance;

    private ChooseAdventurer(){


    }

    public static ChooseAdventurer getInstance(){
        if(ChooseAdventurer.instance == null){
            ChooseAdventurer.instance = new ChooseAdventurer();
        }
        return ChooseAdventurer.instance;
    }

    public void output(String nickname, List<AdventurerDescription> adventurers) throws ClassNotFoundException {
        Scanner prompt = new Scanner(System.in);
        System.out.println(nickname + " scegli un avventuriero tra i seguenti : \n");
        for(AdventurerDescription adv: adventurers){
            System.out.println(adv+" \u001B[32m("+adv.getType()+")\u001B[0m \n");
        }
        System.out.print("DAPP\\chooseAdventurer>");
        this.inputValue = Class.forName(Adventurer.class.getPackageName() + "."+prompt.next());
        System.out.println("...\n...\n...\n");
    }

    public Class input(){
        return this.inputValue;
    }
}