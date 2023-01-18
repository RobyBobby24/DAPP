package view;

import java.io.Console;

class ChooseOperationView {

    private String inputValue;

    private static ChooseOperationView instance;

    private ChooseOperationView(){

    }

    public static ChooseOperationView getInstance(){
        if(ChooseOperationView.instance==null){
            ChooseOperationView.instance=new ChooseOperationView();
        }
        return ChooseOperationView.instance;
    }

    public void output(String nickname){
        Console prompt=System.console();
        System.out.println(nickname+" quale operazione vuoi eseguire ? (set-nickname,make-new-game)\n");
        this.inputValue=prompt.readLine("DAPP\\chooseOperation>");
    }

    public String input(){
        return this.inputValue;
    }
}
