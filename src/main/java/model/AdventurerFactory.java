package model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AdventurerFactory {
    public enum AdventurerClass{Warrior}
    public String adventurerClass;

    private static AdventurerFactory instance;





    private AdventurerFactory(){

    }

    public static AdventurerFactory getInstance(){
        if(AdventurerFactory.instance==null) AdventurerFactory.instance=new AdventurerFactory();
        return AdventurerFactory.instance;
    }

    public void setAdventurerClass(AdventurerClass adventurerClass) {
        this.adventurerClass= "model."+adventurerClass.name();
    }

    public Adventurer getAdventurerInstance() {
        try{
            Method getInstance=Class.forName(this.adventurerClass).getDeclaredMethod("getInstance");
            return (Adventurer)getInstance.invoke(this.adventurerClass);
        }
        catch (Exception e){
           return Warrior.getInstance();
        }

    }
}
