package model;

import services.ConfigurationReader;

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
}
