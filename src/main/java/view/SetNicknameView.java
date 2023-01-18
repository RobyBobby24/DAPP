package view;

import java.io.Console;

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
        Console prompt=System.console();
        System.out.println(nickname+" inseisci il tuo nuovo nickname:\n");
        this.inputValue=prompt.readLine("DAPP\\setNickname>");
    }

    public String input(){
        return this.inputValue;
    }
}
