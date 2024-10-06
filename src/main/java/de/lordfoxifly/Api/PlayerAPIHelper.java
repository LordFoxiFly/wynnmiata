package de.lordfoxifly.Api;

import com.google.gson.Gson;
import com.mojang.authlib.minecraft.client.ObjectMapper;
import de.lordfoxifly.Api.PlayerAPI.Player;

public class PlayerAPIHelper {

    private static final Gson gson = new Gson();
    private static final ObjectMapper mapper = new ObjectMapper(gson);


    public static Player getPlayer(String src){
        return mapper.readValue(src, Player.class);
    }



}
