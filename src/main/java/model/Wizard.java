package model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

import java.io.Serializable;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("Wizard")
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
        AdventurerState battleState = new BattleState();
        battleState.setDeck(this.deck.clone());
        DecoratorState extendedTomeAbility = new ExtendedTomeAbility();
        extendedTomeAbility.setComponent(battleState);
        this.currentState = extendedTomeAbility;
    }

    @Override
    public void setNormalState() {this.currentState = new NormalState();}

    public String toString(){
        return this.getClass().getSimpleName()+" ( HP="+this.hp+", "+this.currentState+")";
    }
}