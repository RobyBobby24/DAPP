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
        for (int i = 0; i < adventurers.size() ; i++) {
            System.out.println(adventurers.get(i)+" \u001B[32m("+String.valueOf(i+1)+")\u001B[0m ");
        }
        System.out.print("\nDAPP\\chooseAdventurer>");
        int input = Integer.parseInt(prompt.next());
        this.inputValue = Class.forName(Adventurer.class.getPackageName() + "."+adventurers.get(input).getType());
        System.out.println("...\n...\n...\n");
    }

    public Class input(){
        return this.inputValue;
    }
}
