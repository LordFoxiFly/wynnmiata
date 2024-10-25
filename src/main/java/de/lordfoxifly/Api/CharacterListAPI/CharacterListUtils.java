package de.lordfoxifly.Api.CharacterListAPI;

import com.google.common.reflect.TypeToken;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;
import java.util.ArrayList;
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
     * @param source
     * @return a Map of all characters
     */

    public static List<CharacterListData> getCharacterMap(String source){
        Type type = new TypeToken<Map<String, CharacterListData>>(){}.getType();
        Map<String, CharacterListData> characterMap = new GsonBuilder()
                .registerTypeAdapter(type, new CharacterListJsonDeserializer())
                .create()
                .fromJson(source, type);

        return characterMap.values().stream().toList();
    }

}
