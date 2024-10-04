package de.lorfoxifly.Screens.Widgets;

import de.lorfoxifly.WynnMiata;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.widget.CheckboxWidget;
import net.minecraft.text.Text;
import org.apache.commons.io.filefilter.TrueFileFilter;

public class CheckBoxs {

    public static int leftpos, toppos;

    private static boolean HighLightLavaBoolean = false;

    public static boolean isHighLightLavaBoolean() {
        return HighLightLavaBoolean;
    }

    public static boolean isHeadRenderingBoolean() {
        return HeadRenderingBoolean;
    }

    private static boolean HeadRenderingBoolean = false;

    public static boolean isFireEntityRenderingBoolean() {
        return FireEntityRenderingBoolean;
    }

    public static boolean isFireHudRenderingBoolean() {
        return FireHudRenderingBoolean;
    }

    private static boolean FireHudRenderingBoolean = false;
    private static boolean FireEntityRenderingBoolean = false;

    public static boolean isArmorRenderingBoolean() {
        return ArmorRenderingBoolean;
    }

    private static boolean ArmorRenderingBoolean = true;



    public static CheckboxWidget HighlightLava = CheckboxWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.TCC.Checkbox.HighlightLava"), MinecraftClient.getInstance().textRenderer)
            .pos(leftpos + 184,toppos + 28)
            .checked(isHighLightLavaBoolean())
            .callback((checkbox, checked) ->  HighLightLavaBoolean = checkbox.isChecked())
            .build();

    public static CheckboxWidget HeadRendering = CheckboxWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.Misc.Checkbox.HeadRendering"), MinecraftClient.getInstance().textRenderer)
            .pos(leftpos + 184,toppos + 28)
            .checked(isHeadRenderingBoolean())
            .callback((checkbox, checked) ->  HeadRenderingBoolean = checkbox.isChecked())
            .build();

    public static CheckboxWidget FireEntityRendering = CheckboxWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.Misc.Checkbox.FireEntityRendering"), MinecraftClient.getInstance().textRenderer)
            .pos(leftpos + 184,toppos + 44)
            .checked(isFireEntityRenderingBoolean())
            .callback((checkbox, checked) ->  FireEntityRenderingBoolean = checkbox.isChecked())
            .build();

    public static CheckboxWidget FireHudRendering = CheckboxWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.Misc.Checkbox.FireHudRendering"), MinecraftClient.getInstance().textRenderer)
            .pos(leftpos + 184,toppos + 60)
            .checked(isFireHudRenderingBoolean())
            .callback((checkbox, checked) ->  FireHudRenderingBoolean = checkbox.isChecked())
            .build();

    public static CheckboxWidget ArmorRendering = CheckboxWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.Misc.Checkbox.ArmorHudRendering"), MinecraftClient.getInstance().textRenderer)
            .pos(leftpos + 184,toppos + 76)
            .checked(isArmorRenderingBoolean())
            .callback((checkbox, checked) ->  ArmorRenderingBoolean = checkbox.isChecked())
            .build();

}
