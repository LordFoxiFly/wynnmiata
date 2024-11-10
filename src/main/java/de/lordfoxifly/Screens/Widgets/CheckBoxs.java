package de.lordfoxifly.Screens.Widgets;

import de.lordfoxifly.Client.Config.WynnMiataConfig;
import de.lordfoxifly.Client.Config.WynnMiataConfigData;
import de.lordfoxifly.Debug.DebugCommands;
import de.lordfoxifly.Debug.Devutils;
import de.lordfoxifly.WynnMiata;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.Element;
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
                .tooltip(Tooltip.of(Text.literal("Replaces the Lava Color !Turn Wynntils Scoreboard Overlays off!")))
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
                .tooltip(Tooltip.of(Text.literal("Hides Head Cosmetics from Players")))
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
                .tooltip(Tooltip.of(Text.literal("Disbales Fire Entity Rendering")))
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
                .tooltip(Tooltip.of(Text.literal("Disables Fire Hud Rendering")))
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
                .tooltip(Tooltip.of(Text.literal("Hides Armor of Players ")))
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
                .tooltip(Tooltip.of(Text.literal("Shows you the Completions of every Partymember")))
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
                .tooltip(Tooltip.of(Text.literal("Copys the stats from /playerstats to the clipboard")))
                .build();
    }

    public static CheckboxWidget  debugEvents(int leftpos, int toppos){
        return  CheckboxWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.Debug.Checkbox.debugEvents"), MinecraftClient.getInstance().textRenderer)
                .pos(leftpos + leftBackGroundX +66,toppos + topBackGroundY)
                .checked(WynnMiata.CONFIG.isDebugEventsBoolean())
                .callback((checkbox, checked) -> {
                    WynnMiata.CONFIG.setDebugEventsBoolean(checkbox.isChecked());
                    WynnMiata.CONFIG.save();
                    WynnMiata.CONFIG = WynnMiataConfig.loadConfigData();})
                .tooltip(Tooltip.of(Text.literal("Logs EventTriggers & Values ")))
                .build();
    }
    public static CheckboxWidget  debugRaids(int leftpos, int toppos){
        return  CheckboxWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.Debug.Checkbox.debugRaids"), MinecraftClient.getInstance().textRenderer)
                .pos(leftpos + leftBackGroundX +66,toppos + topBackGroundY +16)
                .checked(WynnMiata.CONFIG.isDebugRaidsBoolean())
                .callback((checkbox, checked) -> {
                    WynnMiata.CONFIG.setDebugRaidsBoolean(checkbox.isChecked());
                    WynnMiata.CONFIG.save();
                    WynnMiata.CONFIG = WynnMiataConfig.loadConfigData();})
                .tooltip(Tooltip.of(Text.literal("Logs RaidEvents")))
                .build();
    }
    public static CheckboxWidget  debugHud(int leftpos, int toppos){
        return  CheckboxWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.Debug.Checkbox.debugHud"), MinecraftClient.getInstance().textRenderer)
                .pos(leftpos + leftBackGroundX +66,toppos + topBackGroundY +32)
                .checked(WynnMiata.CONFIG.isDebugHudBoolean())
                .callback((checkbox, checked) -> {
                    WynnMiata.CONFIG.setDebugHudBoolean(checkbox.isChecked());
                    WynnMiata.CONFIG.save();
                    WynnMiata.CONFIG = WynnMiataConfig.loadConfigData();})
                .tooltip(Tooltip.of(Text.literal("Shows a Debug Hud")))
                .build();
    }

    public static CheckboxWidget ArmorDurability(int leftpos, int toppos) {
        return CheckboxWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.Misc.Checkbox.ArmorDurabilityHudRendering"), MinecraftClient.getInstance().textRenderer)
                .pos(leftpos +leftBackGroundX +66,toppos + topBackGroundY + 64)
                .checked(WynnMiata.CONFIG.isArmorDurabilityBoolean())
                .callback((checkbox, checked) ->{
                    WynnMiata.CONFIG.setArmorDurabilityBoolean(checkbox.isChecked());
                    WynnMiata.CONFIG.save();
                    WynnMiata.CONFIG = WynnMiataConfig.loadConfigData();})
                .tooltip(Tooltip.of(Text.literal("Shows the Armor Durability of crafted Items on the Hud ")))
                .build();
    }

    public static CheckboxWidget AccessoryDurability(int leftpos, int toppos) {
        return CheckboxWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.Misc.Checkbox.AcessoryDurabilityHudRendering"), MinecraftClient.getInstance().textRenderer)
                .pos(leftpos +leftBackGroundX +66,toppos + topBackGroundY + 80)
                .checked(WynnMiata.CONFIG.isAccessoryDurabilityBoolean())
                .callback((checkbox, checked) ->{
                    WynnMiata.CONFIG.setAccessoryDurabilityBoolean(checkbox.isChecked());
                    WynnMiata.CONFIG.save();
                    WynnMiata.CONFIG = WynnMiataConfig.loadConfigData();})
                .tooltip(Tooltip.of(Text.literal("Shows the Acessory Durability of crafted Items on the Hud ")))
                .build();
    }
    public static CheckboxWidget ProfessionHud(int leftpos, int toppos) {
        return CheckboxWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.Misc.Checkbox.ProfessionTrackingHudRendering"), MinecraftClient.getInstance().textRenderer)
                .pos(leftpos +leftBackGroundX +66,toppos + topBackGroundY + 96)
                .checked(WynnMiata.CONFIG.isProfessionHudBoolean())
                .callback((checkbox, checked) ->{
                    WynnMiata.CONFIG.setProfessionHudBoolean(checkbox.isChecked());
                    WynnMiata.CONFIG.save();
                    WynnMiata.CONFIG = WynnMiataConfig.loadConfigData();})
                .tooltip(Tooltip.of(Text.literal("Keeps track of your Profession Grinding.")))
                .build();
    }

    public static CheckboxWidget ArmorDurabilityOnly(int leftpos, int toppos) {
        return CheckboxWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.Misc.Checkbox.ArmorDurabilityOnlyRendering"), MinecraftClient.getInstance().textRenderer)
                .pos(leftpos + 20,toppos + 110)
                .checked(WynnMiata.CONFIG.isArmorDurabilityOnlyBoolean())
                .callback((checkbox, checked) ->{
                    WynnMiata.CONFIG.setArmorDurabilityOnlyBoolean(checkbox.isChecked());
                    WynnMiata.CONFIG.save();
                    WynnMiata.CONFIG = WynnMiataConfig.loadConfigData();})
                .tooltip(Tooltip.of(Text.literal("Only shows the Durability and not the Max ")))
                .build();
    }

    public static CheckboxWidget AcessoryDurabilityOnly(int leftpos, int toppos) {
        return CheckboxWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.Misc.Checkbox.ArmorDurabilityOnlyRendering"), MinecraftClient.getInstance().textRenderer)
                .pos(leftpos + 20,toppos + 110)
                .checked(WynnMiata.CONFIG.isAccessoryDurabilityOnly())
                .callback((checkbox, checked) ->{
                    WynnMiata.CONFIG.setAccessoryDurabilityOnly(checkbox.isChecked());
                    WynnMiata.CONFIG.save();
                    WynnMiata.CONFIG = WynnMiataConfig.loadConfigData();})
                .tooltip(Tooltip.of(Text.literal("Only shows the Durability and not the Max ")))
                .build();
    }
}
