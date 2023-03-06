package services;

import model.StandardRoomFactory;

public class Configuration {
    static private Configuration instance;
    private Class roomFactoryClass= StandardRoomFactory.class;


    private Configuration(){

    }

    public static Configuration getInstance() {
        if(Configuration.instance==null){
            Configuration.instance=new Configuration();
        }
        return Configuration.instance;
    }

    public Class getRoomFactoryClass() {
        return roomFactoryClass;
    }
}
