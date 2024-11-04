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
    public void setDebugRaidsBoolean(boolean debugRaidsBoolean) { this.debugRaidsBoolean = debugRaidsBoolean;
    }

    public boolean isDebugEventsBoolean() {
        return debugEventsBoolean;
    }

    public void setDebugEventsBoolean(boolean debugEventsBoolean) {
        this.debugEventsBoolean = debugEventsBoolean;
    }
    public int getShowPlayerRaidy() {
        return showPlayerRaidy;
    }

    public void setShowPlayerRaidy(int showPlayerRaidy) {
        this.showPlayerRaidy = showPlayerRaidy;
    }

    public int getShowPlayerRaidx() {
        return showPlayerRaidx;
    }

    public void setShowPlayerRaidx(int showPlayerRaidx) {
        this.showPlayerRaidx = showPlayerRaidx;
    }
    public String getShowPlayerRaidColor() {return showPlayerRaidColor;}

    public void setShowPlayerRaidColor(String showPlayerRaidColor) {this.showPlayerRaidColor = showPlayerRaidColor;}

    public String getHighLightLavaColor() {return HighLightLavaColor;}
    public void setHighLightLavaColor(String highLightLavaColor) {HighLightLavaColor = highLightLavaColor;}
    public boolean isArmorDurabilityBoolean() {
        return ArmorDurabilityBoolean;
    }

    public void setArmorDurabilityBoolean(boolean armorDurabilityBoolean) {
        ArmorDurabilityBoolean = armorDurabilityBoolean;
    }

    public int getArmorDurabilityY() {
        return ArmorDurabilityY;
    }

    public void setArmorDurabilityY(int armorDurabilityY) {
        ArmorDurabilityY = armorDurabilityY;
    }

    public int getArmorDurabilityX() {
        return ArmorDurabilityX;
    }

    public void setArmorDurabilityX(int armorDurabilityX) {
        ArmorDurabilityX = armorDurabilityX;
    }

    public String getArmorDurabilityTextColor() {
        return ArmorDurabilityTextColor;
    }

    public void setArmorDurabilityTextColor(String armorDurabilityTextColor) {
        ArmorDurabilityTextColor = armorDurabilityTextColor;
    }

    public boolean isRenderHudElements() {
        return renderHudElements;
    }

    public void setRenderHudElements(boolean renderHudElements) {
        this.renderHudElements = renderHudElements;
    }
    public int getArmorDurabilityTextY() {
        return ArmorDurabilityTextY;
    }

    public void setArmorDurabilityTextY(int armorDurabilityTextY) {
        ArmorDurabilityTextY = armorDurabilityTextY;
    }

    public int getArmorDurabilityTextX() {
        return ArmorDurabilityTextX;
    }

    public void setArmorDurabilityTextX(int armorDurabilityTextX) {
        ArmorDurabilityTextX = armorDurabilityTextX;
    }
    private boolean renderHudElements = true;
    private  boolean HeadRenderingBoolean = false;
    private  boolean HighLightLavaBoolean = false;
    private String HighLightLavaColor = "00FF00";
    private  boolean FireHudRenderingBoolean = false;
    private  boolean FireEntityRenderingBoolean = false;
    private  boolean ArmorRenderingBoolean = false;
    private  boolean showPlayerRaidsBoolean = false;
    private int showPlayerRaidy = 150;
    private int showPlayerRaidx = 10;
    private String showPlayerRaidColor = "00FF00";
    private  boolean ArmorDurabilityBoolean = false;
    private int ArmorDurabilityY = 0;
    private int ArmorDurabilityX = 20;
    private int ArmorDurabilityTextY = 13;
    private int ArmorDurabilityTextX = 10;
    private String ArmorDurabilityTextColor = "FFFFFF";
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
