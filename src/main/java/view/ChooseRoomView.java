package view;

import model.Room;

import java.io.Console;
import java.util.List;
import java.util.Scanner;

public class ChooseRoomView {

    private Room inputValue;

    private static ChooseRoomView instance;

    private ChooseRoomView(){

    }

    public static ChooseRoomView getInstance(){
        if(ChooseRoomView.instance==null){
            ChooseRoomView.instance=new ChooseRoomView();
        }
        return ChooseRoomView.instance;
    }

    public void output(String nickname, List<Room> rooms){
        Scanner prompt= new Scanner(System.in);
        System.out.println(nickname+" scegli una stanza dove entrare :\n");
        for (int i = 0; i < rooms.size(); i++) {
            System.out.println(rooms.get(i)+"\u001B[32m ("+i+") \u001B[0m");
        }
        System.out.print("DAPP\\chooseRoom>");
        this.inputValue=rooms.get(Integer.parseInt(prompt.next()));
        System.out.println("...\n...\n...\n");
    }

    public Room input(){
        return this.inputValue;
    }
}
