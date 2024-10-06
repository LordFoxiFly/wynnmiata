package de.lordfoxifly.Screens.Widgets;

import de.lordfoxifly.Screens.*;
import de.lordfoxifly.WynnMiata;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class Buttons {




    public static ButtonWidget TCC = ButtonWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.TCC.Button.Open"), (btn) -> {
        MinecraftClient.getInstance().setScreen(new TheCanyonColossusScreen());

    }).dimensions( 118, 28, 55, 20).tooltip(Tooltip.of(Text.of("Testing"))).build();

    public static ButtonWidget NOL = ButtonWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.NOL.Button.Open"), (btn) -> {
        MinecraftClient.getInstance().setScreen(new NexusOfLightScreen());

    }).dimensions( 118,  48, 55, 20).tooltip(Tooltip.of(Text.of("Testing"))).build();

    public static   ButtonWidget MISC = ButtonWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.MISC.Button.Open"), (btn) -> {
        MinecraftClient.getInstance().setScreen(new MiscScreen());

    }).dimensions( 118,  68, 55, 20).tooltip(Tooltip.of(Text.of("Testing"))).build();

    public static   ButtonWidget RAIDS = ButtonWidget.builder(Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.RAIDS.Button.Open"), (btn) -> {
        MinecraftClient.getInstance().setScreen(new RaidsScreen());

    }).dimensions(  118,  88, 55, 20).tooltip(Tooltip.of(Text.of("Testing"))).build();



}
