package services;

import model.Adventurer;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ConfigurationReader {
    static private ConfigurationReader instance;
    public Class adventurerClass;
    private final String configurationFileUrl = "src/main/java/utility/configurationFile.json";


    private ConfigurationReader(){

    }

    public static ConfigurationReader getInstance() {
        if(ConfigurationReader.instance==null){
            ConfigurationReader.instance=new ConfigurationReader();
        }
        return ConfigurationReader.instance;
    }

    public Class getRoomFactoryClass() throws IOException, ClassNotFoundException {
        String data = new String(Files.readAllBytes(Paths.get(this.configurationFileUrl)));
        JSONObject jsonObject = new JSONObject(data);
        String className = jsonObject.getString("roomFactoryClass");
        return Class.forName( className );
    }

    public Class getDifficultyStrategyClass(String difficultyStrategyName) throws IOException, ClassNotFoundException {
        String data = new String(Files.readAllBytes(Paths.get(this.configurationFileUrl)));
        JSONObject jsonObject = new JSONObject(data);
        jsonObject = jsonObject.getJSONObject("difficulty");
        jsonObject = jsonObject.getJSONObject(difficultyStrategyName);
        String className = jsonObject.getString("ClassName");
        return Class.forName( className );
    }

    public Set<String> getDifficultyStrategyNameSet() throws IOException {
        java.lang.String data = new java.lang.String(Files.readAllBytes(Paths.get(this.configurationFileUrl)));
        JSONObject jsonObject = new JSONObject(data);
        jsonObject = jsonObject.getJSONObject("difficulty");
        return jsonObject.keySet();
    }

    public Integer getDifficultyStrategyParameter(String difficultyStrategyName, String parameterName) throws IOException, ClassNotFoundException {
        String data = new String(Files.readAllBytes(Paths.get(this.configurationFileUrl)));
        JSONObject jsonObject = new JSONObject(data);
        jsonObject = jsonObject.getJSONObject("difficulty");
        jsonObject = jsonObject.getJSONObject(difficultyStrategyName);
        return jsonObject.getInt(parameterName);
    }


    /**
     * set Target class
     * @param AdvClass TargetClass (class which has the static method to execute)
     * @throws Exception
     */
    public void setAdventurerClass( Class AdvClass ) throws Exception {
        if( AdvClass.getSuperclass().getName().equals( Adventurer.class.getName()) )
            this.adventurerClass = AdvClass;
        else
        {
            throw new Exception("The class passed as parameter must be a subclass of Adventurer");
        }
    }

    public Class getAdventurerClass() {
        return adventurerClass;
    }
    public int getBonfirePercentage() throws IOException{
        String data = new String(Files.readAllBytes(Paths.get(this.configurationFileUrl)));
        JSONObject jsonObject = new JSONObject(data);
        return jsonObject.getInt("percentageBonfire");


    }
}
