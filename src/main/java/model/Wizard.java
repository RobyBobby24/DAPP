package model;

import java.io.Serializable;

public class Wizard extends Adventurer implements Serializable {

    public Wizard() {
        this.currentState = new NormalState();
    }


    public static Adventurer getInstance() {
        if(Wizard.instance == null){
            Wizard.instance = new Wizard();
        }
        return instance;
    }

    @Override
    public void setBattleState() {
        this.currentState = new BattleState();
        this.currentState.setDeck(this.deck.clone());
    }

    @Override
    public void setNormalState() {this.currentState = new NormalState();}

    public String toString(){
        return this.getClass().getSimpleName()+" ( HP="+this.hp+", "+this.currentState+")";
    }
}