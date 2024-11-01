package de.lordfoxifly.Screens.PlayerStats.Screens;

import de.lordfoxifly.Api.PlayerAPI.Player;
import de.lordfoxifly.Screens.Widgets.Buttons;
import de.lordfoxifly.WynnMiata;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class OtherStatsScreen extends Screen {
    private static final Text TITLE = Text.translatable("gui." + WynnMiata.MOD_ID + "abiltytreestats");
    private static final Identifier PLAYERBACKGROUND_STATS = Identifier.of("wynnmiata", "textures/gui/playerstats_texture.png");
    private  final int imagewidth, imageheight;
    private int leftpos, toppos;
    private Player requestedPlayer;
    public OtherStatsScreen(Player player) {
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
        addDrawableChild(Buttons.ABILTYTREE(leftpos,toppos));
        addDrawableChild(Buttons.OTHERSTATS(leftpos,toppos,true));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context,mouseX,mouseY,delta);
        super.render(context, mouseX, mouseY, delta);
        context.drawText(textRenderer, Text.literal("Deaths: " + requestedPlayer.getSelectedCharacterData().getDeaths()), leftpos + 20, toppos + 35, 0xFFFFFF, true);
        context.drawText(textRenderer, Text.literal("Mobs Killed: " + requestedPlayer.getSelectedCharacterData().getMobsKilled()), leftpos + 20, toppos + 50, 0xFFFFFF, true);
        context.drawText(textRenderer, Text.literal("Items Identified: " + requestedPlayer.getSelectedCharacterData().getItemsIdentified()), leftpos + 20, toppos + 65, 0xFFFFFF, true);
        context.drawText(textRenderer, Text.literal("Blocks Walked: " + requestedPlayer.getSelectedCharacterData().getBlocksWalked()), leftpos + 20, toppos + 80, 0xFFFFFF, true);
        context.drawText(textRenderer, Text.literal("Discoveries: " + requestedPlayer.getSelectedCharacterData().getDiscoveries()), leftpos + 20, toppos + 95, 0xFFFFFF, true);
        context.drawText(textRenderer, Text.literal("Chests Found: " + requestedPlayer.getSelectedCharacterData().getChestsFound()), leftpos + 20, toppos + 110, 0xFFFFFF, true);
        context.drawText(textRenderer, Text.literal("Logins: " + requestedPlayer.getSelectedCharacterData().getLogins()), leftpos + 20, toppos + 125, 0xFFFFFF, true);

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
