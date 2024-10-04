package de.lorfoxifly.Screens.Widgets;

import de.lorfoxifly.Screens.MiscScreen;
import de.lorfoxifly.Screens.NexusOfLightScreen;
import de.lorfoxifly.Screens.TheCanyonColossusScreen;
import de.lorfoxifly.WynnMiata;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class Buttons {


    public static int leftpos, toppos;
            ;



    public static ButtonWidget TCC = ButtonWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.TCC.Button.Open"), (btn) -> {
        MinecraftClient.getInstance().setScreen(new TheCanyonColossusScreen());

    }).dimensions(leftpos + 118, toppos+28, 55, 20).tooltip(Tooltip.of(Text.of("Testing"))).build();

    public static ButtonWidget NOL = ButtonWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.NOL.Button.Open"), (btn) -> {
        MinecraftClient.getInstance().setScreen(new NexusOfLightScreen());

    }).dimensions(leftpos + 118, toppos + 48, 55, 20).tooltip(Tooltip.of(Text.of("Testing"))).build();

    public static ButtonWidget MISC = ButtonWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.MISC.Button.Open"), (btn) -> {
        MinecraftClient.getInstance().setScreen(new MiscScreen());

    }).dimensions(leftpos + 118, toppos + 68, 55, 20).tooltip(Tooltip.of(Text.of("Testing"))).build();






}
