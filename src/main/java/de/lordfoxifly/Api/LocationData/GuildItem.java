package de.lordfoxifly.Api.LocationData;

import com.google.gson.annotations.SerializedName;

public class GuildItem {
    @SerializedName("server")
    private String server;

    @SerializedName("character")
    private String character;

    @SerializedName("name")
    private String name;

    @SerializedName("nickname")
    private String nickname;
    @SerializedName("x")
    private int x;

    @SerializedName("y")
    private int y;

    @SerializedName("z")
    private int z;

    @SerializedName("uuid")
    private String uuid;

    public String getServer(){
        return server;
    }

    public String getCharacter(){
        return character;
    }

    public String getName(){
        return name;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getZ(){
        return z;
    }

    public String getUuid(){
        return uuid;
    }
    public String getNickname() {
        return nickname;
    }
}
