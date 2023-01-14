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
@Table(name="Effect")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Discriminator", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("Effect")
public abstract class Effect implements Serializable {
	public Effect() {
	}
	
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
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setTarget(boolean value) {
		this.target = value;
	}
	
	public boolean getTarget() {
		return target;
	}
	
	public void setNextEffect(Effect value) {
		this.nextEffect = value;
	}
	
	public Effect getNextEffect() {
		return nextEffect;
	}
	
	public abstract void activeEffect(BattleRoom battleField, int[] target);
	
	public abstract int numberOfTarget(int actualNumber);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
