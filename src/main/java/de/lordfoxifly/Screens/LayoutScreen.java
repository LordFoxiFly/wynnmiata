package de.lordfoxifly.Screens;

import de.lordfoxifly.Screens.Widgets.LayoutWidgets;
import de.lordfoxifly.WynnMiata;
import de.lordfoxifly.WynnMiataUtils.ColorUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class LayoutScreen extends Screen {
    private static final  Text TITLE = Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.LayoutScreen");
    int leftpos,  toppos;
    public LayoutScreen() {
        super(TITLE);

    }
    @Override
    protected void init() {
        leftpos = 0;
        toppos = 0;
        super.init();

        if (WynnMiata.CONFIG.isShowPlayerRaidsBoolean()){
            addDrawableChild(LayoutWidgets.ShowPlayerRaids());
        }


    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context,mouseX,mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
       if (WynnMiata.CONFIG.isShowPlayerRaidsBoolean()){
           int y = 15;
           context.drawText(MinecraftClient.getInstance().textRenderer, Text.literal("Raid: TCC"), WynnMiata.CONFIG.getShowPlayerRaidx(),WynnMiata.CONFIG.getShowPlayerRaidy(), ColorUtils.hexstringToInt(WynnMiata.CONFIG.getShowPlayerRaidColor()), true);
           for (int i = 0; i < 4; i++){
               context.drawText(MinecraftClient.getInstance().textRenderer, Text.literal(MinecraftClient.getInstance().getSession().getUsername() + ": "+ y), WynnMiata.CONFIG.getShowPlayerRaidx(),  WynnMiata.CONFIG.getShowPlayerRaidy() + y,ColorUtils.hexstringToInt(WynnMiata.CONFIG.getShowPlayerRaidColor()) ,true);
               y += 15;
               if (i == 3) y = 15;
           }
       }
    }
}
