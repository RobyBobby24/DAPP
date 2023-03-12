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
import org.glassfish.jaxb.core.v2.TODO;
import org.hibernate.annotations.LazyCollectionOption;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="monster")
public class Monster implements Serializable {
	public Monster() {
	}
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="MODEL_MONSTER_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="MODEL_MONSTER_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@ManyToOne(targetEntity= Hp.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK, org.hibernate.annotations.CascadeType.DELETE})	
	@JoinColumns(value={ @JoinColumn(name="HpID", referencedColumnName="ID", nullable=false) }, foreignKey=@ForeignKey(name="FKMonster438639"))	
	private Hp hp;
	
	@Column(name="Name", nullable=false, length=255)
	private String name;
	
	@Column(name="Type", nullable=false, length=255)
	private String type;
	
	@Column(name="ChallengeRating", nullable=false)
	private Double challengeRating;
	
	@Column(name="Protection", nullable=false, length=10)	
	private int protection;

	@ManyToMany(targetEntity=model.Action.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
	@JoinTable(name="monster_action", joinColumns={ @JoinColumn(name="MonsterID", referencedColumnName="ID", nullable=false) }, inverseJoinColumns={ @JoinColumn(name="ActionID",referencedColumnName="ID", nullable=false) })
	@org.hibernate.annotations.IndexColumn(name="ActionIndex")
	@org.hibernate.annotations.LazyCollection(LazyCollectionOption.FALSE)
	private List<Action> availableActions = new ArrayList<Action>();

	@Column(name="RewardCoins", nullable=false, length=10)
	private int rewardCoins;
	@Transient
	private Action nextAction;

	public Monster( Hp hp, String name, String type, Double challengeRating, int protection, List<Action> availableActions, int rewardCoins, Action nextAction) {
		this.hp = hp;
		this.name = name;
		this.type = type;
		this.challengeRating = challengeRating;
		this.protection = protection;
		this.availableActions = availableActions;
		this.rewardCoins = rewardCoins;
		this.nextAction = nextAction;
	}

	/**
	 * set new ID (identifier of the instance also in DB)
	 * @param value new ID
	 */
	private void setID(int value) {
		this.ID = value;
	}

	/**
	 * @return ID (identifier of the instance also in DB)
	 */
	public int getID() {
		return this.ID;
	}

	/**
	 * set new name (name of the monster)
	 * @param value new name
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * @return name (name of the monster)
	 */
	public String getName() {
		return name;
	}

	/**
	 * set new monster type (String that represent the strength of the monster)
	 * @param value new monster type
	 */
	public void setType(String value) {
		this.type = value;
	}

	/**
	 * @return monster type (String that represent the strength of the monster)
	 */
	public String getType() {
		return type;
	}

	/**
	 * set new challengeRating (numeric value that represent the strength of the monster)
	 * @param value new challengeRating
	 */
	public void setChallengeRating(double value) {
		this.challengeRating=Double.valueOf(value);
	}

	/**
	 * @return challengeRating (numeric value that represent the strength of the monster)
	 */
	public double getChallengeRating() {
		return challengeRating;
	}

	/**
	 * set new protection (number of damage that can take without lose hp)
	 * @param value new protection
	 */
	public void setProtection(int value) {
		this.protection = value;
	}

	/**
	 * @return protection (number of damage that can take without lose hp)
	 */
	public int getProtection() {
		return protection;
	}

	/**
	 * set new availableAction (action that monster can play)
	 * @param value new availableAction
	 */
	public void setAvailableActions(ArrayList<Action> value) {
		this.availableActions = value;
	}

	/**
	 * @return availableAction (action that monster can play)
	 */
	private ArrayList<Action> getAvailableActions() {
		try{
			return (ArrayList<Action>)availableActions;
		}
		catch (Exception e){
			this.availableActions = new ArrayList<Action>(this.availableActions);
			return (ArrayList<Action>) this.availableActions;
		}
	}

	/**
	 * set new Hp (number of damage that can take without die)
	 * @param value new Hp
	 */
	public void setHp(Hp value) {
		this.hp = value;
	}

	/**
	 * @return Hp (number of damage that can take without die)
	 */
	public Hp getHp() {
		return hp;
	}

	/**
	 * @return nextAction (action that he will play at the next turn)
	 */
	public Action getNextAction() {
		return this.nextAction;
	}

	/**
	 * set new nextAction (action that he will play at the next turn)
	 * @param nextAction new nextAction
	 */
	public void setNextAction(Action nextAction) {
		this.nextAction=nextAction;
	}

	/**
	 * @return random action from available
	 */
	public Action getRandomAction() {	// TODO verificare se è possibile stabilire una % per ogni azione
		Random random =new Random();
		return this.availableActions.get(random.nextInt(this.availableActions.size()));
	}


	/**
	 * @return RewardCoins (the coins that the adventurer acquire
	 */
	public int getRewardCoins() {
		return rewardCoins;
	}

	public void setRewardCoins(int rewardCoins) {
		this.rewardCoins = rewardCoins;
	}

	/**
	 * decrease hp and/or protection of "damage" point
	 * @param damage number of point to decrease hp and/or protection
	 */
	public void takeDamage(int damage) {
		if(damage > this.protection){
			this.hp.addCurrentHp(this.protection - damage);
			this.protection = 0;
		}
		else
			this.protection = this.protection - damage;
		if(this.hp.getCurrentHp() == 0){
			BattleRoom battleRoom = (BattleRoom) DungeonMap.getInstance().getCurrentRoom();
			battleRoom.notifyDeath(this);
		}
	}

	/**
	 * increase protection of "protection"
	 * @param protection number of point to increase protection
	 */
	public void addProtection(int protection) {
		this.protection=this.protection+protection;
	}


	public Monster clone(){
		return new Monster( this.getHp().clone() , this.getName() , this.getType() , this.getChallengeRating() , this.getProtection() , (List<Action>) this.getAvailableActions().clone() , this.getRewardCoins() , this.getNextAction() );
	}
	/**
	 * add an action to the available
	 * @param action action to add
	 */
	public void addActionToAvailable(Action action){
		this.availableActions.add(action);
	}
	
	public String toString() {
		return this.name+" ("+"HP="+this.hp+", Protection="+this.protection+", NextAction="+this.nextAction+", Type="+this.type+", ChallengeRating="+this.challengeRating+")";
	}

	public String var_dump(){
		return "ID:"+this.ID+" protection:"+this.protection+" type:"+this.type+" availableActions:"+this.availableActions+" name:"+this.name+" nextAction:"+this.nextAction+" challengeRating"+this.challengeRating+" hp"+this.hp;
	}
	
}
