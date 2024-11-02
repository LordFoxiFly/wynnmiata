package de.lordfoxifly.Screens.Widgets;

import de.lordfoxifly.Screens.Layout.LayoutMenuScreen;
import de.lordfoxifly.Screens.Layout.LayoutTypes;
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
}
