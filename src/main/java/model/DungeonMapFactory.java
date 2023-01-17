package model;

import jakarta.persistence.Query;
import services.PersistenceInterface;

public class DungeonMapFactory {

    private int dungeonMapID=0;

    static DungeonMapFactory instance;

    private DungeonMapFactory(){

    }

    static DungeonMapFactory getInstance(){
        if(DungeonMapFactory.instance==null){
            return new DungeonMapFactory();
        }
        else return DungeonMapFactory.instance;
    }

    public void setDungeonMapID(int dungeonMapID) {
        this.dungeonMapID = dungeonMapID;
    }

    public DungeonMap loadDungeonMap(){
        if(PersistenceInterface.getIstance().exist("DungeonMap dm","count(dm)","dm.ID="+this.dungeonMapID)){
            return (DungeonMap) PersistenceInterface.getIstance().loadOne(this.dungeonMapID,DungeonMap.class);
        }
        else return null;
    }
}
