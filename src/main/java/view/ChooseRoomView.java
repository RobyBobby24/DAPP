package view;

import model.Room;

import java.io.Console;
import java.util.List;

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
        Console prompt=System.console();
        System.out.println(nickname+" scegli una stanza dove entrare :\n");
        for (int i = 0; i < rooms.size(); i++) {
            System.out.println(rooms.get(i).getClass().getSimpleName()+"("+i+")");
        }
        this.inputValue=rooms.get(Integer.parseInt(prompt.readLine("DAPP\\chooseOperation>")));
    }

    public Room input(){
        return this.inputValue;
    }
}
