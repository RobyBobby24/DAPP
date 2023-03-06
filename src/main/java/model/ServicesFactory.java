package model;

import services.Configuration;

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
                Class roomFactoryClass= Configuration.getInstance().getRoomFactoryClass();
                Method getInstance=roomFactoryClass.getDeclaredMethod("getInstance");
                this.roomFactoryInstance=(RoomFactory) getInstance.invoke(roomFactoryClass);
            }
            return this.roomFactoryInstance;
        }
        catch(Exception e){
            return null;
        }
    }
}
