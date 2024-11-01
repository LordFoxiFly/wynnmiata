package de.lordfoxifly.Api.CharacterListAPI;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class CharacterListJsonDeserializer implements JsonDeserializer<Map<String,CharacterListData>> {


    @Override
    public Map<String, CharacterListData> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        Map<String, CharacterListData> characterMap = new HashMap<>();

        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            CharacterListData characterData = context.deserialize(entry.getValue(), CharacterListData.class);
            characterMap.put(entry.getKey(), characterData);
        }

        return characterMap;
    }


}
