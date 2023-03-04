package model;

import services.PersistenceInterface;

import java.lang.reflect.Method;

public class AdventurerFactory {
    public String adventurerClass;

    private static AdventurerFactory instance;





    private AdventurerFactory(){

    }

    /**
     * @return the unique instance of AdventurerFactory
     */
    public static AdventurerFactory getInstance(){
        if(AdventurerFactory.instance == null)
            AdventurerFactory.instance = new AdventurerFactory();
        return AdventurerFactory.instance;
    }

    /**
     * set Target class
     * @param AdvClass TargetClass (class which has the static method to execute)
     * @throws Exception
     */
    public void setAdventurerClass( Class AdvClass ) throws Exception {
        if( AdvClass.getSuperclass().getName().equals( Adventurer.class.getName()) )
            this.adventurerClass = AdvClass.getName();
        else
        {
            throw new Exception("The class passed as parameter must be a subclass of Adventurer");
        }
    }

    /**
     * @return the Adventurer Instance
     */
    public Adventurer getAdventurerInstance() {
        try{
            if( PersistenceInterface.getInstance().existAdventurerByClass(Class.forName(this.adventurerClass)) ){
                return PersistenceInterface.getInstance().loadAdventurerByClass(Class.forName(this.adventurerClass));
            }
            else{
                Method getInstance=Class.forName(this.adventurerClass).getDeclaredMethod("getInstance");
                return (Adventurer)getInstance.invoke(this.adventurerClass);
            }
        }
        catch (Exception e){
           return null;
        }

    }
}
