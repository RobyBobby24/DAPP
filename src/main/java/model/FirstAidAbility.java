package model;

public class FirstAidAbility extends DecoratorState {

    public void restoreHp() {
        Adventurer.getInstance().addCurrentHp(6);
    }

    public void catchReward (){

        super.catchBattleReward();
        restoreHp();

    }
}