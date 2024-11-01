package de.lordfoxifly.Features.Raids;

import de.lordfoxifly.Api.PlayerAPI.Player;
import de.lordfoxifly.Api.PlayerAPIHelper;
import de.lordfoxifly.Api.RequestHelper;
import net.minecraft.client.MinecraftClient;

import java.io.IOException;
import java.net.URISyntaxException;

public class RaidPlayer {

    private final String uuid;
    private String name;


    private Player player;


    public RaidPlayer(String uuid, String name){
       this.uuid = uuid;
       this.name = name;
        RequestHelper.getAPIDataAsync("https://api.wynncraft.com/v3/player/" + uuid).thenAccept(
                string -> {
                    this.player =  PlayerAPIHelper.getPlayer(string);
                }
        );

    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}
