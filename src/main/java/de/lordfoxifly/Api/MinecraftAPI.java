package de.lordfoxifly.Api;

import com.google.gson.Gson;
import com.mojang.authlib.minecraft.client.ObjectMapper;
import de.lordfoxifly.Api.MojangAPI.MinecraftProfileData;
import de.lordfoxifly.Api.PlayerAPI.Player;
import de.lordfoxifly.WynnMiata;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MinecraftAPI {

    private static final Gson gson = new Gson();
    private static final ObjectMapper mapper = new ObjectMapper(gson);

    /**
     * Gets the UUID by a Username.
     * @param username The Username.
     * @return UUID
     */
    public static String getPlayerUUID(String username){
        MinecraftProfileData data;
        try {
           String src = RequestHelper.getAPIData("https://api.mojang.com/users/profiles/minecraft/" + username);
           data = mapper.readValue(src , MinecraftProfileData.class);
           WynnMiata.LOGGER.info(src);
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return fromTrimmedUUID(data.getId());
    }

    /**
     * Converts a trimmed UUID into a normal UUID.
     * @param trimmedUUID The trimmed UUID.
     * @return
     */
    public static String fromTrimmedUUID(String trimmedUUID){
        if(trimmedUUID == null) throw new IllegalArgumentException();
        StringBuilder builder = new StringBuilder(trimmedUUID.trim());
        /* Backwards adding to avoid index adjustments */
        try {
            builder.insert(20, "-");
            builder.insert(16, "-");
            builder.insert(12, "-");
            builder.insert(8, "-");
        } catch (StringIndexOutOfBoundsException e){
            throw new IllegalArgumentException();
        }

        return builder.toString();
    }


}
