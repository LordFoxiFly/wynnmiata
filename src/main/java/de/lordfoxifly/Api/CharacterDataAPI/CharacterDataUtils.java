package de.lordfoxifly.Api.CharacterDataAPI;

import com.google.gson.Gson;
import com.mojang.authlib.minecraft.client.ObjectMapper;
import de.lordfoxifly.Api.CharacterDataAPI.CharacterData.CharacterData;
import de.lordfoxifly.Api.PlayerAPI.Player;
import de.lordfoxifly.Api.RequestHelper;
import de.lordfoxifly.WynnMiata;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public abstract class CharacterDataUtils {


    /**
     * Get the CharacterData From a List of Characters
     * @param keys The Player you want the Character Data from
     * @return
     */
    public static Map<String,CharacterData> getCharacterDataFromCharacterUUIDList(List<String> keys, String username, boolean isDataPublic) {
        Map<String,CharacterData> characterDataList = new HashMap<>();
        for (String uuid: keys){
           try{
               String apisrc = RequestHelper.getAPIData("https://api.wynncraft.com/v3/player/" + username + "/characters/" + uuid);
               //WynnMiata.LOGGER.info("https://api.wynncraft.com/v3/player/" + username + "/characters/" + uuid);
               //WynnMiata.LOGGER.info(apisrc);
               if (apisrc == null || apisrc.isEmpty()){
                   continue;
               }
               CharacterData tempdate = getCharData(apisrc);
               characterDataList.put(uuid, tempdate);
           }catch (URISyntaxException | IOException| InterruptedException e){
               WynnMiata.LOGGER.error(e.toString());
           }
        }
        return characterDataList;
    }



    /**
     * Gets the active Character of a Player
     * @param player The Player
     * @return
     */
    public static CharacterData getActiveCharacter(Player player){
        CharacterData output = null;
        for (String uuid: player.getCharacters().keySet()){
            if (Objects.equals(uuid, player.getActiveCharacter())){
                output = player.getCharacterData().get(uuid);
            }
        }
        return output;
    }

    /**
     * Gets a Character Data
     * @param player
     * @param characteruuid The UUID of the Character.
     * @return
     */
    public static CharacterData getCharacterData(Player player, String characteruuid){
        CharacterData output = null;
        for (String uuid: player.getCharacterData().keySet()){
            if (Objects.equals(uuid, characteruuid)){
                output = player.getCharacterData().get(uuid);
            }
        }
        return output;
    }

    /**
     * Gets the UUID of a Character
     * @param player
     * @param characterData
     * @return
     */
    public static String getCharacterUUID(Player player,  CharacterData characterData){
        String output = null;
        for (Map.Entry<String,CharacterData> entry: player.getCharacterData().entrySet()){
            if (entry.getValue() == characterData){
                output = entry.getKey();
            }
        }
        return output;
    }


    private static final Gson gson = new Gson();
    private static final ObjectMapper mapper = new ObjectMapper(gson);


    /**
     * Get the CharacterData from API Response String
     * @param src The Api Response String
     * @return
     */
    public static CharacterData getCharData(String src){
        return mapper.readValue(src, CharacterData.class);
    }

}
