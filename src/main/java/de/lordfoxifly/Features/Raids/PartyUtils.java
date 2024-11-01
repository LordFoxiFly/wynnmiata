package de.lordfoxifly.Features.Raids;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import de.lordfoxifly.Api.LocationData.LocationResponse;
import de.lordfoxifly.Api.LocationData.PartyItem;
import de.lordfoxifly.Api.PlayerAPIHelper;
import de.lordfoxifly.Api.RequestHelper;
import net.minecraft.client.MinecraftClient;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PartyUtils {


    public static List<RaidPlayer> getParty(){
        List<RaidPlayer> output = new ArrayList<>();
        RequestHelper.getAPIDataAsync("https://api.wynncraft.com/v3/map/locations/player").thenAccept( string -> {
            try {

                List<LocationResponse> locationData = getLocation(string);

                // If successful, add players to the output list
                if (locationData != null && locationData.getFirst().getParty() != null) {
                    for (PartyItem partyItem : locationData.getFirst().getParty()) {
                        output.add(new RaidPlayer(partyItem.getUuid(), partyItem.getName()));
                    }
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        });
        return output;
    }


    private static final Gson gson = new Gson();


    /**
     * Get the CharacterData from API Response String
     * @param src The Api Response String
     * @return
     */
    public static List<LocationResponse> getLocation(String src){
        Type LocationResponseType = new TypeToken<ArrayList<LocationResponse>>(){}.getType();
        ArrayList<LocationResponse> userArray = gson.fromJson(src, LocationResponseType);
       return userArray;
    }

}
