package de.lordfoxifly.Screens.Widgets;

import de.lordfoxifly.Client.Config.WynnMiataConfig;
import de.lordfoxifly.Client.Config.WynnMiataConfigData;
import de.lordfoxifly.Debug.DebugCommands;
import de.lordfoxifly.Debug.Devutils;
import de.lordfoxifly.WynnMiata;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.CheckboxWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.widget.TextWidget;
import net.minecraft.text.Text;

import java.awt.*;
import java.awt.datatransfer.Clipboard;

public class CheckBoxs {

    private  static final int leftBackGroundX = 6;
    private static final int topBackGroundY = 22;




    public static boolean isHighLightLavaBoolean() {
        return HighLightLavaBoolean;
    }

    public static boolean isHeadRenderingBoolean() {
        return HeadRenderingBoolean;
    }
    public static boolean isArmorRenderingBoolean() {
        return ArmorRenderingBoolean;
    }



    public static boolean isFireEntityRenderingBoolean() {
        return FireEntityRenderingBoolean;
    }

    public static boolean isFireHudRenderingBoolean() {
        return FireHudRenderingBoolean;
    }
    public static boolean isShowPlayerRaidsBoolean() {return showPlayerRaidsBoolean;}
    private static boolean HeadRenderingBoolean = false;
    private static boolean HighLightLavaBoolean = false;
    private static boolean FireHudRenderingBoolean = false;
    private static boolean FireEntityRenderingBoolean = false;
    private static boolean ArmorRenderingBoolean = false;

    private static boolean showPlayerRaidsBoolean = false;



    public static CheckboxWidget HighlightLava(int leftpos, int toppos){
        return CheckboxWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.TCC.Checkbox.HighlightLava"), MinecraftClient.getInstance().textRenderer)
                .pos(leftpos + leftBackGroundX + 66,toppos + topBackGroundY)
                .checked(WynnMiata.CONFIG.isHighLightLavaBoolean())
                .callback((checkbox, checked) -> {
                    WynnMiata.CONFIG.setHighLightLavaBoolean(checkbox.isChecked());
                    WynnMiata.CONFIG.save();
                    WynnMiata.CONFIG = WynnMiataConfig.loadConfigData();
                })
                .tooltip(Tooltip.of(Text.literal("!Experimental could crash the game! Highlights Lava")))
                .build();
    }

    public static CheckboxWidget HeadRendering(int leftpos, int toppos){
        return CheckboxWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.Misc.Checkbox.HeadRendering"), MinecraftClient.getInstance().textRenderer)
                .pos(leftpos + leftBackGroundX  +66,toppos + topBackGroundY)
                .checked(WynnMiata.CONFIG.isHeadRenderingBoolean())
                .callback((checkbox, checked) ->  {
                    WynnMiata.CONFIG.setHeadRenderingBoolean(checkbox.isChecked());
                    WynnMiata.CONFIG.save();
                    WynnMiata.CONFIG = WynnMiataConfig.loadConfigData();
                })
                .build();
    }

    public static CheckboxWidget FireEntityRendering(int leftpos, int toppos){
        return CheckboxWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.Misc.Checkbox.FireEntityRendering"), MinecraftClient.getInstance().textRenderer)
                .pos(leftpos + leftBackGroundX + 66,toppos + topBackGroundY +  16)
                .checked(WynnMiata.CONFIG.isFireEntityRenderingBoolean())
                .callback((checkbox, checked) ->  {
                    WynnMiata.CONFIG.setFireEntityRenderingBoolean(checkbox.isChecked());
                    WynnMiata.CONFIG.save();
                    WynnMiata.CONFIG = WynnMiataConfig.loadConfigData();
                })
                .build();
    }

    public static CheckboxWidget FireHudRendering(int leftpos, int toppos){
        return CheckboxWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.Misc.Checkbox.FireHudRendering"), MinecraftClient.getInstance().textRenderer)
                .pos(leftpos + leftBackGroundX + 66,toppos + topBackGroundY + 32)
                .checked(WynnMiata.CONFIG.isFireHudRenderingBoolean())
                .callback((checkbox, checked) ->  {
                    WynnMiata.CONFIG.setFireHudRenderingBoolean(checkbox.isChecked());
                    WynnMiata.CONFIG.save();
                    WynnMiata.CONFIG = WynnMiataConfig.loadConfigData();
                })
                .build();
    }

    public static CheckboxWidget ArmorRendering(int leftpos, int toppos){
        return CheckboxWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.Misc.Checkbox.ArmorHudRendering"), MinecraftClient.getInstance().textRenderer)
                .pos(leftpos +leftBackGroundX +66,toppos + topBackGroundY + 48)
                .checked(WynnMiata.CONFIG.isArmorRenderingBoolean())
                .callback((checkbox, checked) ->{
                    WynnMiata.CONFIG.setArmorRenderingBoolean(checkbox.isChecked());
                    WynnMiata.CONFIG.save();
                    WynnMiata.CONFIG = WynnMiataConfig.loadConfigData();})
                .build();
    }


    public static CheckboxWidget  showPlayerRaids(int leftpos, int toppos){
        return  CheckboxWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.Raids.Checkbox.showPlayerRaids"), MinecraftClient.getInstance().textRenderer)
                .pos(leftpos + leftBackGroundX +66,toppos + topBackGroundY)
                .checked(WynnMiata.CONFIG.isShowPlayerRaidsBoolean())
                .callback((checkbox, checked) -> {
                        WynnMiata.CONFIG.setShowPlayerRaidsBoolean(checkbox.isChecked());
                        WynnMiata.CONFIG.save();
                        WynnMiata.CONFIG = WynnMiataConfig.loadConfigData();})
                .build();
    }

    public static CheckboxWidget  copyPlayerStatsCommand(int leftpos, int toppos){
        return  CheckboxWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.Raids.Checkbox.copyPlayerStats"), MinecraftClient.getInstance().textRenderer)
                .pos(leftpos + leftBackGroundX +66,toppos + topBackGroundY + 16)
                .checked(WynnMiata.CONFIG.isCopyPlayerStatsBoolean())
                .callback((checkbox, checked) -> {
                    WynnMiata.CONFIG.setCopyPlayerStatsBoolean(checkbox.isChecked());
                    WynnMiata.CONFIG.save();
                    WynnMiata.CONFIG = WynnMiataConfig.loadConfigData();})
                .build();
    }



}
