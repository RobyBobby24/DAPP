package view;

import java.io.Console;
import java.util.Scanner;

class SetNicknameView {

    private String inputValue;

    private static SetNicknameView instance;

    private SetNicknameView(){

    }

    public static SetNicknameView getInstance(){
        if(SetNicknameView.instance==null){
            SetNicknameView.instance=new SetNicknameView();
        }
        return SetNicknameView.instance;
    }

    public void output(String nickname){
        Scanner prompt= new Scanner(System.in);
        if(nickname!=null)System.out.println(nickname+" inseisci il tuo nuovo nickname:");
        else System.out.println(" inseisci il tuo nuovo nickname:");
        System.out.print("DAPP\\setNickname>");
        this.inputValue=prompt.next();
    }

    public String input(){
        return this.inputValue;
    }
}
