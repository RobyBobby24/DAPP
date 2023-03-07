package model;

import services.ConfigurationReader;
import services.PersistenceInterface;

import java.lang.reflect.Method;

public class ServicesFactory {

    private static ServicesFactory instance;
    private RoomFactory roomFactoryInstance;


    private ServicesFactory(){

    }
    public static ServicesFactory getInstance() {
        if(ServicesFactory.instance==null){
            ServicesFactory.instance=new ServicesFactory();
        }
        return ServicesFactory.instance;
    }

    public RoomFactory getRoomFactoryInstance(){
        try{
            if(this.roomFactoryInstance==null){
                Class roomFactoryClass= ConfigurationReader.getInstance().getRoomFactoryClass();
                this.roomFactoryInstance=(RoomFactory) roomFactoryClass.newInstance();
            }
            return this.roomFactoryInstance;
        }
        catch(Exception e){
            return null;
        }
    }

    public BuildMapDifficultyStrategy getDifficultyStrategyInstance(String difficultyStrategyName){
        try{
            Class difficultyStrategyClass= ConfigurationReader.getInstance().getDifficultyStrategyClass(difficultyStrategyName);
            return (BuildMapDifficultyStrategy) difficultyStrategyClass.newInstance();
        }
        catch(Exception e){
            return null;
        }
    }

    /**
     * @return the Adventurer Instance
     */
    public Adventurer getAdventurerInstance() {
        try{
            Class adventurerClass = ConfigurationReader.getInstance().getAdventurerClass();
            if( PersistenceInterface.getInstance().existAdventurerByClass( adventurerClass ) ){
                return PersistenceInterface.getInstance().loadAdventurerByClass( adventurerClass );
            }
            else{
                Method getInstance = adventurerClass.getDeclaredMethod("getInstance");
                return (Adventurer) getInstance.invoke( adventurerClass.getName() );
            }
        }
        catch (Exception e){
            return null;
        }

    }
}
