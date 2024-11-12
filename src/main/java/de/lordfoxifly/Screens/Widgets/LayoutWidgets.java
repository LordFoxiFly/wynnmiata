package de.lordfoxifly.Screens.Widgets;

import de.lordfoxifly.Screens.Layout.LayoutMenuScreen;
import de.lordfoxifly.Screens.Layout.LayoutTypes;
import de.lordfoxifly.Screens.Layout.LayoutUtils;
import de.lordfoxifly.Screens.Widgets.WynnMiataWidgets.LayoutWidget;
import de.lordfoxifly.WynnMiata;
import net.minecraft.client.MinecraftClient;
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
                    MinecraftClient.getInstance().setScreen(new LayoutMenuScreen(LayoutTypes.ArmorDurability));
                });
    }

    public static LayoutWidget ProfessionHud() {
        int y = LayoutUtils.getY(WynnMiata.CONFIG.getProfessionHudY(), WynnMiata.CONFIG.getProfessionHudTextY());
        int x = LayoutUtils.getX(WynnMiata.CONFIG.getProfessionHudX(), WynnMiata.CONFIG.getProfessionHudTextX());
        int with = LayoutUtils.getWitdh(x, WynnMiata.CONFIG.getProfessionHudX(), WynnMiata.CONFIG.getProfessionHudTextX(), 150);
        int height = LayoutUtils.getHeight(y, WynnMiata.CONFIG.getProfessionHudY(), WynnMiata.CONFIG.getProfessionHudTextY(), 32);
        return new  LayoutWidget(x, y, with, height, Text.translatable("gui." + WynnMiata.CONFIG + ".layout.professionhud"),
                button -> {
                    MinecraftClient.getInstance().setScreen(new LayoutMenuScreen(LayoutTypes.PROFESSIONHUD));
                });
    }

    public static LayoutWidget AccessoryDurability(){
        return new  LayoutWidget(WynnMiata.CONFIG.getAccessoryDurabilityX(), WynnMiata.CONFIG.getAccessoryDurabilityY(), 20, 90, Text.translatable("gui." + WynnMiata.CONFIG + ".layout.armordurability"),
                button -> {
                    MinecraftClient.getInstance().setScreen(new LayoutMenuScreen(LayoutTypes.AccessoryDurability));
                });
    }
}
