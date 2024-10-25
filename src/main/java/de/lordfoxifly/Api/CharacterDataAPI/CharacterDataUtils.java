package de.lordfoxifly.Api.CharacterDataAPI;

import com.google.gson.Gson;
import com.mojang.authlib.minecraft.client.ObjectMapper;
import de.lordfoxifly.Api.CharacterDataAPI.CharacterData.CharacterData;
import de.lordfoxifly.Api.CharacterListAPI.CharacterListData;
import de.lordfoxifly.Api.CharacterListAPI.CharacterListUtils;
import de.lordfoxifly.Api.PlayerAPI.Player;
import de.lordfoxifly.Api.RequestHelper;
import de.lordfoxifly.WynnMiata;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public abstract class CharacterDataUtils {


    /**
     * Get the CharacterData From a List of Characters
     * @param keys The Player you want the Character Data from
     * @return
     */
    public static List<CharacterData> getCharacterDataFromCharacterUUIDList(List<String> keys, String username) {
        List<CharacterData> characterDataList = new ArrayList<>();
        for (String uuid: keys){
           try{
               String apisrc = RequestHelper.getAPIData("https://api.wynncraft.com/v3/player/" + username + "/characters/" + uuid);
               WynnMiata.LOGGER.info("https://api.wynncraft.com/v3/player/" + username + "/characters/" + uuid);
               WynnMiata.LOGGER.info(apisrc);
               if (apisrc == null){
                   continue;
               }
               characterDataList.add(getCharData(apisrc));
           }catch (URISyntaxException | IOException| InterruptedException e){
               WynnMiata.LOGGER.error(e.toString());
           }
        }
        return characterDataList;
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
