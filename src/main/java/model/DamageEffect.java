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
import java.util.ArrayList;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("DamageEffect")
public class DamageEffect extends Effect implements Serializable {

	
	@Column(name="Damage", nullable=true, length=10)	
	private int damage;


	public DamageEffect() {
		this.target=true;
	}

	/**
	 * set new damage (hp that the effect take away by the monster)
	 * @param value new damage
	 */
	public void setDamage(int value) {
		this.damage = value;
	}

	/**
	 * @return damage (hp that the effect take away by the monster)
	 */
	public int getDamage() {
		return damage;
	}

	/**
	 * take away the hp to the target monster
	 * @param battleField field that contain all the variable that an effect could change
	 * @param target id of the target who will be changed in this effect or in the next
	 */
	public void activeEffect(BattleRoom battleField, ArrayList<Integer> target) {
		int monsterId=target.remove(0);
		Monster monster=battleField.getMonster(monsterId);
		monster.takeDamage(this.damage);
		if(this.nextEffect!=null)this.nextEffect.activeEffect(battleField,target);
	}
	
	public String toString() {
		if(this.nextEffect!=null)return "damage:"+this.damage+","+this.nextEffect;
		else return "damage:"+this.damage;
	}

	public String var_dump(){
		return super.var_dump()+" protection:"+this.damage;
	}
	
}
