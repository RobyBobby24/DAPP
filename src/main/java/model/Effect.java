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
@Table(name="Effect")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Discriminator", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("Effect")
public abstract class Effect implements Serializable {
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="MODEL_EFFECT_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="MODEL_EFFECT_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@ManyToOne(targetEntity= Effect.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="EffectID", referencedColumnName="ID") }, foreignKey=@ForeignKey(name="FKEffect31173"))	
	private Effect nextEffect;
	
	@Column(name="Target", nullable=false, length=1)	
	private boolean target;



	public Effect() {
	}

	/**
	 * set new ID (identifier of object used also in DB)
	 * @param value new ID
	 */
	private void setID(int value) {
		this.ID = value;
	}

	/**
	 * @return actual ID of the object
	 */
	public int getID() {
		return ID;
	}


	/**
	 * set new Target (is true if the effect have to have a target)
	 * @param value new Target
	 */
	public void setTarget(boolean value) {
		this.target = value;
	}

	/**
	 * @return actual Target (is true if the effect have to have a target)
	 */
	public boolean getTarget() {
		return target;
	}

	/**
	 * set the effect that have to be performed after this
	 * @param value new next Effect
	 */
	public void setNextEffect(Effect value) {
		this.nextEffect = value;
	}

	/**
	 * @return next Effect (the effect that have to be performed after this)
	 */
	public Effect getNextEffect() {
		return nextEffect;
	}

	/**
	 * exec what the effect provide
	 * @param battleField field that contain all the variable that an effect could change
	 * @param target id of the target who will be changed in this effect or in the next
	 */
	public abstract void activeEffect(BattleRoom battleField, ArrayList<Integer> target);

	/**
	 * @param actualNumber number of target that need the previous effect
	 * @return if the effect need a target, one plus of the number passed as parameter
	 */
	public int numberOfTarget(int actualNumber){
		if(this.target){
			actualNumber=actualNumber+1;
		}
		return actualNumber;
	}

	public String toString() {
		return String.valueOf(getID());
	}

	public String var_dump(){
		return "ID: "+this.getID()+" target:"+getTarget()+" nextEffect:"+getNextEffect()+" target:"+getTarget();
	}
	
}
