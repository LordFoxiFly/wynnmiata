package de.lordfoxifly.Client.Config;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class WynnMiataConfigData {
    public boolean isHeadRenderingBoolean() {
        return HeadRenderingBoolean;
    }

    public void setHeadRenderingBoolean(boolean headRenderingBoolean) {
        HeadRenderingBoolean = headRenderingBoolean;
    }

    public boolean isHighLightLavaBoolean() {
        return HighLightLavaBoolean;
    }

    public void setHighLightLavaBoolean(boolean highLightLavaBoolean) {
        HighLightLavaBoolean = highLightLavaBoolean;
    }

    public boolean isFireHudRenderingBoolean() {
        return FireHudRenderingBoolean;
    }

    public void setFireHudRenderingBoolean(boolean fireHudRenderingBoolean) {
        FireHudRenderingBoolean = fireHudRenderingBoolean;
    }

    public boolean isFireEntityRenderingBoolean() {
        return FireEntityRenderingBoolean;
    }

    public void setFireEntityRenderingBoolean(boolean fireEntityRenderingBoolean) {
        FireEntityRenderingBoolean = fireEntityRenderingBoolean;
    }

    public boolean isArmorRenderingBoolean() {
        return ArmorRenderingBoolean;
    }

    public void setArmorRenderingBoolean(boolean armorRenderingBoolean) {
        ArmorRenderingBoolean = armorRenderingBoolean;
    }

    public boolean isShowPlayerRaidsBoolean() {
        return showPlayerRaidsBoolean;
    }

    public void setShowPlayerRaidsBoolean(boolean showPlayerRaidsBoolean) {
        this.showPlayerRaidsBoolean = showPlayerRaidsBoolean;
    }
    public boolean isCopyPlayerStatsBoolean() {
        return copyPlayerStatsBoolean;
    }

    public void setCopyPlayerStatsBoolean(boolean copyPlayerStatsBoolean) {
        this.copyPlayerStatsBoolean = copyPlayerStatsBoolean;
    }
    public boolean isDebugRaidsBoolean() {
        return debugRaidsBoolean;
    }
    public boolean isDebugHudBoolean() {
        return debugHudBoolean;
    }

    public void setDebugHudBoolean(boolean debugHudBoolean) {
        this.debugHudBoolean = debugHudBoolean;
    }
    public void setDebugRaidsBoolean(boolean debugRaidsBoolean) { debugRaidsBoolean = debugRaidsBoolean;
    }

    public boolean isDebugEventsBoolean() {
        return debugEventsBoolean;
    }

    public void setDebugEventsBoolean(boolean debugEventsBoolean) {
        this.debugEventsBoolean = debugEventsBoolean;
    }
    private  boolean HeadRenderingBoolean = false;
    private  boolean HighLightLavaBoolean = false;
    private  boolean FireHudRenderingBoolean = false;
    private  boolean FireEntityRenderingBoolean = false;
    private  boolean ArmorRenderingBoolean = false;
    private  boolean showPlayerRaidsBoolean = false;

    private boolean copyPlayerStatsBoolean= false;

    private  boolean debugHudBoolean = false;
    private boolean debugRaidsBoolean = false;

    private boolean debugEventsBoolean = false;


    public static WynnMiataConfigData getDefault() {
        return new WynnMiataConfigData();
    }

    public void save() {
        try {
            Gson gson = new Gson();
            FileWriter writer = new FileWriter(WynnMiataConfig.config_file.toFile());
            gson.toJson(this, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
