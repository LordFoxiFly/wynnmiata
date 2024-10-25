package de.lordfoxifly.Api.CharacterListAPI;

import java.util.List;

public class CharacterListData {
    private String type;
    private String characterUuid;
    private String nickname;
    private int level;
    private int xp;
    private int xpPercent;
    private int totalLevel;
    private List<String> gamemode;

    public String getCharacterUuid() {
        return characterUuid;
    }

    public void setCharacterUuid(String characterUuid) {
        this.characterUuid = characterUuid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getXpPercent() {
        return xpPercent;
    }

    public void setXpPercent(int xpPercent) {
        this.xpPercent = xpPercent;
    }

    public int getTotalLevel() {
        return totalLevel;
    }

    public void setTotalLevel(int totalLevel) {
        this.totalLevel = totalLevel;
    }

    public List<String> getGamemode() {
        return gamemode;
    }

    public void setGamemode(List<String> gamemode) {
        this.gamemode = gamemode;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    private Meta meta;
}
