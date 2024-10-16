package de.lordfoxifly.Screens.Widgets;

import de.lordfoxifly.Debug.DebugCommands;
import de.lordfoxifly.Debug.Devutils;
import de.lordfoxifly.WynnMiata;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.CheckboxWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.widget.TextWidget;
import net.minecraft.text.Text;

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
                .checked(isHighLightLavaBoolean())
                .callback((checkbox, checked) -> {
                    HighLightLavaBoolean = checkbox.isChecked();
                })
                .tooltip(Tooltip.of(Text.literal("!Experimental could crash the game! Highlights Lava")))
                .build();
    }

    public static CheckboxWidget HeadRendering(int leftpos, int toppos){
        return CheckboxWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.Misc.Checkbox.HeadRendering"), MinecraftClient.getInstance().textRenderer)
                .pos(leftpos + leftBackGroundX  +66,toppos + topBackGroundY)
                .checked(isHeadRenderingBoolean())
                .callback((checkbox, checked) ->  HeadRenderingBoolean = checkbox.isChecked())
                .build();
    }

    public static CheckboxWidget FireEntityRendering(int leftpos, int toppos){
        return CheckboxWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.Misc.Checkbox.FireEntityRendering"), MinecraftClient.getInstance().textRenderer)
                .pos(leftpos + leftBackGroundX + 66,toppos + topBackGroundY +  16)
                .checked(isFireEntityRenderingBoolean())
                .callback((checkbox, checked) ->  FireEntityRenderingBoolean = checkbox.isChecked())
                .build();
    }

    public static CheckboxWidget FireHudRendering(int leftpos, int toppos){
        return CheckboxWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.Misc.Checkbox.FireHudRendering"), MinecraftClient.getInstance().textRenderer)
                .pos(leftpos + leftBackGroundX + 66,toppos + topBackGroundY + 32)
                .checked(isFireHudRenderingBoolean())
                .callback((checkbox, checked) ->  FireHudRenderingBoolean = checkbox.isChecked())
                .build();
    }

    public static CheckboxWidget ArmorRendering(int leftpos, int toppos){
        return CheckboxWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.Misc.Checkbox.ArmorHudRendering"), MinecraftClient.getInstance().textRenderer)
                .pos(leftpos +leftBackGroundX +66,toppos + topBackGroundY + 48)
                .checked(isArmorRenderingBoolean())
                .callback((checkbox, checked) ->  ArmorRenderingBoolean = checkbox.isChecked())
                .build();
    }


    public static CheckboxWidget  showPlayerRaids(int leftpos, int toppos){
        return  CheckboxWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.Raids.Checkbox.showPlayerRaids"), MinecraftClient.getInstance().textRenderer)
                .pos(leftpos + leftBackGroundX +66,toppos + topBackGroundY)
                .checked(isShowPlayerRaidsBoolean())
                .callback((checkbox, checked) ->  showPlayerRaidsBoolean = checkbox.isChecked())
                .build();
    }




}
