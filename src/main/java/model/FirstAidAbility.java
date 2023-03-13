package model;

public class FirstAidAbility extends DecoratorState {

    private final String description = "recupera 6hp alla fine di ogni battaglia";
    public void restoreHp() {
        Adventurer.getInstance().addCurrentHp(6);
    }

    public void catchBattleReward(){
        super.catchBattleReward();
        restoreHp();
    }

    public String toString(){
        return this.description+this.getComponent();
    }
}