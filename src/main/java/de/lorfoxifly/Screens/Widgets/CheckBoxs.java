package de.lorfoxifly.Screens.Widgets;

import de.lorfoxifly.WynnMiata;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.widget.CheckboxWidget;
import net.minecraft.text.Text;

public class CheckBoxs {

    public static int leftpos, toppos;

    private static boolean HighLightLavaBoolean = false;

    public static boolean isHighLightLavaBoolean() {
        return HighLightLavaBoolean;
    }

    public static boolean isHeadRenderingBoolean() {
        return HeadRenderingBoolean;
    }

    private static boolean HeadRenderingBoolean = true;


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



}
