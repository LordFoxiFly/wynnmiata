package de.lordfoxifly.Screens.PlayerStats.Screens;

import de.lordfoxifly.Api.PlayerAPI.Player;
import de.lordfoxifly.Screens.Widgets.Buttons;
import de.lordfoxifly.WynnMiata;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class AbilityTreeScreen extends Screen {
    private static final Text TITLE = Text.translatable("gui." + WynnMiata.MOD_ID + "abiltytreestats");
    private static final Identifier PLAYERBACKGROUND_STATS = Identifier.of("wynnmiata", "textures/gui/playerstats_texture.png");
    private  final int imagewidth, imageheight;
    private int leftpos, toppos;
    private Player requestedPlayer;
    public AbilityTreeScreen(Player player) {
        super(TITLE);
        requestedPlayer = player;
        imageheight = 256;
        imagewidth = imageheight;
    }

    @Override
    protected void init() {
        super.init();
        leftpos = (this.width - this.imagewidth ) / 2 - 64;
        toppos = (this.height - this.imageheight) / 2;
        addDrawableChild(Buttons.DEFAULTSTATS(leftpos, toppos));
        addDrawableChild(Buttons.RAIDSTATS(leftpos,toppos));
        addDrawableChild(Buttons.PROFSTATS(leftpos,toppos));
        addDrawableChild(Buttons.ABILTYTREE(leftpos,toppos, true));
        addDrawableChild(Buttons.OTHERSTATS(leftpos,toppos));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context,mouseX,mouseY,delta);
        super.render(context, mouseX, mouseY, delta);
        context.drawText(textRenderer, Text.literal("Coming soon,"), leftpos + leftpos, toppos + toppos, 0xFFFFFF, true);
    }

    @Override
    public void renderBackground(DrawContext context, int mouseX, int mouseY, float delta) {
        context.drawTexture(PLAYERBACKGROUND_STATS,  leftpos, toppos + 15,0,0, 384,220, 384, 220);
        //PlayerStatsHelper.renderProgressBar(context, 75, false, leftpos + 22 , toppos +35);

    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}

