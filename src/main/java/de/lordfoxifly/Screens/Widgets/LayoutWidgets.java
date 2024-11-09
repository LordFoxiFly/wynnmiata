package de.lordfoxifly.Screens.Widgets;

import de.lordfoxifly.Screens.Layout.LayoutMenuScreen;
import de.lordfoxifly.Screens.Layout.LayoutTypes;
import de.lordfoxifly.Screens.Widgets.WynnMiataWidgets.LayoutWidget;
import de.lordfoxifly.WynnMiata;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.Element;
import net.minecraft.text.Text;

public class LayoutWidgets {

    public static LayoutWidget ShowPlayerRaids(){
        return new  LayoutWidget(WynnMiata.CONFIG.getShowPlayerRaidx(), WynnMiata.CONFIG.getShowPlayerRaidy(), 75, 75, Text.translatable("gui." + WynnMiata.CONFIG + ".layout.showplayerraids"),
                button -> {
                    MinecraftClient.getInstance().setScreen(new LayoutMenuScreen(LayoutTypes.ShowPlayerRaids));
        });
    }
    public static LayoutWidget ArmorDurability(){
        return new  LayoutWidget(WynnMiata.CONFIG.getArmorDurabilityX(), WynnMiata.CONFIG.getArmorDurabilityY(), 20, 90, Text.translatable("gui." + WynnMiata.CONFIG + ".layout.armordurability"),
                button -> {
                    MinecraftClient.getInstance().setScreen(new LayoutMenuScreen(LayoutTypes.ArmorDuration));
                });
    }

    public static LayoutWidget ProfessionHud() {
        return new  LayoutWidget(WynnMiata.CONFIG.getProfessionHudX(), WynnMiata.CONFIG.getProfessionHudY(), 150, 32, Text.translatable("gui." + WynnMiata.CONFIG + ".layout.professionhud"),
                button -> {
                    MinecraftClient.getInstance().setScreen(new LayoutMenuScreen(LayoutTypes.PROFESSIONHUD));
                });
    }
}
