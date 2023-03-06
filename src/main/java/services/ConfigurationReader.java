package services;

import model.StandardRoomFactory;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConfigurationReader {
    static private ConfigurationReader instance;
    private Class roomFactoryClass= StandardRoomFactory.class;


    private ConfigurationReader(){

    }

    public static ConfigurationReader getInstance() {
        if(ConfigurationReader.instance==null){
            ConfigurationReader.instance=new ConfigurationReader();
        }
        return ConfigurationReader.instance;
    }

    public Class getRoomFactoryClass() throws IOException, ClassNotFoundException {
        String data = new String(Files.readAllBytes(Paths.get("../utility/configurationFile.json")));
        JSONObject jsonObject = new JSONObject(data);
        String className = jsonObject.getString("roomFactoryClass");
        return Class.forName( className );
    }
}
