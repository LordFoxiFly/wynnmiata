package de.lordfoxifly.Api.CharacterListAPI;

import com.google.common.reflect.TypeToken;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public abstract class CharacterListUtils {


    /**
     * Gets a character
     * @param uuid The UUID of the char
     * @param source The Api Output
     * @return CharacterListData
     */
    public static CharacterListData getCharacter(String uuid, String source){

        Type type = new TypeToken<Map<String, CharacterListData>>(){}.getType();
        Map<String, CharacterListData> characterMap = new GsonBuilder()
                .registerTypeAdapter(type, new CharacterListJsonDeserializer())
                .create()
                .fromJson(source, type);

        return  characterMap.get(uuid);
    }

    /**
     * Gets all of the Characters of a Player
     * @param source The API Response.
     * @return
     */

    public static List<CharacterListData> getCharacterList(String source){
        Type type = new TypeToken<Map<String, CharacterListData>>(){}.getType();
        Map<String, CharacterListData> characterMap = new GsonBuilder()
                .registerTypeAdapter(type, new CharacterListJsonDeserializer())
                .create()
                .fromJson(source, type);

        return characterMap.values().stream().toList();
    }

    /**
     * Gets all of the Characters of a Player
     * @param characterMap The Map
     * @return List
     */
    public static List<CharacterListData> getCharacterList(Map<String,CharacterListData> characterMap){
        return characterMap.values().stream().toList();
    }

    /**
     * Gets all of the Character UUIDs of a Player
     * @param source The API Response.
     * @return List
     */
    public static List<String> getCharacterUUID(String source){
        Type type = new TypeToken<Map<String, CharacterListData>>(){}.getType();
        Map<String, CharacterListData> characterMap = new GsonBuilder()
                .registerTypeAdapter(type, new CharacterListJsonDeserializer())
                .create()
                .fromJson(source, type);

        return characterMap.keySet().stream().toList();
    }
    /**
     * Gets all of the Character UUIDs of a Player
     * @param charactermap The API Response.
     * @return List
     */
    public static List<String> getCharacterUUID(Map<String,CharacterListData> charactermap){
        return charactermap.keySet().stream().toList();
    }


    /**
     * Gets a Map with all of the Characters of a Player
     * @param source
     * @return
     */
    public static Map<String, CharacterListData> getCharacterMap(String source){
        Type type = new TypeToken<Map<String, CharacterListData>>(){}.getType();
        Map<String, CharacterListData> characterMap = new GsonBuilder()
                .registerTypeAdapter(type, new CharacterListJsonDeserializer())
                .create()
                .fromJson(source, type);
        return characterMap;
    }
}
