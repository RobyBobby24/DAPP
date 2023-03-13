/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: rober(Universita degli Studi dell'Aquila)
 * License Type: Academic
 */
package model;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("Warrior")
public class Warrior extends Adventurer implements Serializable {



	public Warrior() {
		this.currentState = new NormalState();
	}


	public static Adventurer getInstance() {
		if(Warrior.instance == null){
			Warrior.instance = new Warrior();
		}
		return instance;
	}

	@Override
	public void setBattleState() {
		AdventurerState battleState = new BattleState();
		battleState.setDeck(this.deck.clone());
		DecoratorState firstAidAbility = new FirstAidAbility();
		firstAidAbility.setComponent(battleState);
		this.currentState = firstAidAbility;
	}

	@Override
	public void setNormalState() {
		AdventurerState normalState = new NormalState();
		this.currentState = normalState;
	}

	public String toString(){
		return this.getClass().getSimpleName()+" ( HP="+this.hp+", coins = "+this.getCoins()+", "+this.currentState+")";
	}

	public String toStringWithCoins(){
		return this.getClass().getSimpleName()+" ( hp = "+this.hp+", coins = "+this.getCoins()+" )";
	}

}
