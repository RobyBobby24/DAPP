package model;

public class FirstAidAbility extends DecoratorState {

    public void restoreHp() {

    }

    public void catchReward (){

        super.catchBattleReward();
        restoreHp();

    }
}