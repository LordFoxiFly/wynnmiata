package de.lordfoxifly.Screens;

import de.lordfoxifly.WynnMiata;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class PlayerStatsScreen extends Screen {

    private static final Text TITLE = Text.translatable("gui." + WynnMiata.MOD_ID + "playerstats");
    private static final Identifier PLAYERBACKGROUND_STATS = Identifier.of(WynnMiata.MOD_ID, "texture/gui/playerstats_texture.png");

    private  final int imagewidth, imageheight;
    private int leftpos, toppos;


    public PlayerStatsScreen() {
        super(TITLE);
        imageheight = 256;
        imagewidth = imageheight;


    }

    @Override
    protected void init() {
        super.init();
        leftpos = (this.width - this.imagewidth ) / 2;
        toppos = (this.height - this.imageheight) / 2;
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context,mouseX,mouseY,delta);
        super.render(context, mouseX, mouseY, delta);
        context.drawText(textRenderer, "Stats of : " + "Test", leftpos + 80, toppos + 58, 0xFFFFFFFF, true);
    }

    @Override
    public void renderBackground(DrawContext context, int mouseX, int mouseY, float delta) {
        context.drawTexture(PLAYERBACKGROUND_STATS,  leftpos, toppos + 15,0,0, 256,220, 256, 220);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
