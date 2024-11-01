package de.lordfoxifly.Screens.PlayerStats.Screens;

import de.lordfoxifly.Api.PlayerAPI.Player;
import de.lordfoxifly.Screens.PlayerStats.PlayerStatsHelper;
import de.lordfoxifly.Screens.Widgets.Buttons;
import de.lordfoxifly.WynnMiata;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ProfStatScreen extends Screen {

    private static final Text TITLE = Text.translatable("gui." + WynnMiata.MOD_ID + "profplayerstats");
    private static final Identifier PLAYERBACKGROUND_STATS = Identifier.of("wynnmiata", "textures/gui/playerstats_texture.png");

    private Player requestedPlayer;

    private  final int imagewidth, imageheight;
    private int leftpos, toppos;
    public ProfStatScreen(Player player){
        super(TITLE);
        imageheight = 256;
        imagewidth = imageheight;
        this.requestedPlayer = player;
    }

    @Override
    protected void init() {
        super.init();
        leftpos = (this.width - this.imagewidth ) / 2 - 64;
        toppos = (this.height - this.imageheight) / 2;
        addDrawableChild(Buttons.DEFAULTSTATS(leftpos, toppos));
        addDrawableChild(Buttons.RAIDSTATS(leftpos,toppos));
        addDrawableChild(Buttons.PROFSTATS(leftpos,toppos, true));
        addDrawableChild(Buttons.ABILTYTREE(leftpos,toppos));
        addDrawableChild(Buttons.OTHERSTATS(leftpos,toppos));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context,mouseX,mouseY,delta);
        super.render(context, mouseX, mouseY, delta);

        context.drawText(textRenderer,Text.literal("Selected Class: " + requestedPlayer.getSelectedCharacterData().getType()), leftpos + 20, toppos + 20, 0xFFFFFF, true);
        context.drawText(textRenderer,Text.literal("Mining Level: " + requestedPlayer.getSelectedCharacterData().getProfessions().getMining().getLevel()), leftpos + 20, toppos + 40, 0xFFFFFF, true);
        PlayerStatsHelper.renderProgressBar(context,requestedPlayer.getSelectedCharacterData().getProfessions().getMining().getXpPercent(), false,leftpos + 20, toppos + 50);
        context.drawText(textRenderer,Text.literal("Fishing Level: " + requestedPlayer.getSelectedCharacterData().getProfessions().getFishing().getLevel()), leftpos + 20, toppos + 60, 0xFFFFFF, true);
        PlayerStatsHelper.renderProgressBar(context,requestedPlayer.getSelectedCharacterData().getProfessions().getFishing().getXpPercent(), false,leftpos + 20, toppos + 70);
        context.drawText(textRenderer,Text.literal("Wood Cutting Level: " + requestedPlayer.getSelectedCharacterData().getProfessions().getWoodcutting().getLevel()), leftpos + 20, toppos + 80, 0xFFFFFF, true);
        PlayerStatsHelper.renderProgressBar(context,requestedPlayer.getSelectedCharacterData().getProfessions().getWoodcutting().getXpPercent(), false,leftpos + 20, toppos + 90);
        context.drawText(textRenderer,Text.literal("Farming Level: " + requestedPlayer.getSelectedCharacterData().getProfessions().getFarming().getLevel()), leftpos + 20, toppos + 100, 0xFFFFFF, true);
        PlayerStatsHelper.renderProgressBar(context,requestedPlayer.getSelectedCharacterData().getProfessions().getFarming().getXpPercent(), false,leftpos + 20, toppos + 110);

        context.drawText(textRenderer, Text.literal("Scribing :" + requestedPlayer.getSelectedCharacterData().getProfessions().getScribing().getLevel()), leftpos+ 150,toppos + 40 , 0xFFFFFF, true);
        PlayerStatsHelper.renderProgressBar(context,requestedPlayer.getSelectedCharacterData().getProfessions().getScribing().getXpPercent(), false,leftpos + 150, toppos + 50);
        context.drawText(textRenderer, Text.literal("Cooking :" + requestedPlayer.getSelectedCharacterData().getProfessions().getCooking().getLevel()), leftpos+ 150,toppos + 60 , 0xFFFFFF, true);
        PlayerStatsHelper.renderProgressBar(context,requestedPlayer.getSelectedCharacterData().getProfessions().getCooking().getXpPercent(), false,leftpos + 150, toppos + 70);
        context.drawText(textRenderer, Text.literal("Alchemism: " + requestedPlayer.getSelectedCharacterData().getProfessions().getAlchemism().getLevel()), leftpos+ 150,toppos + 80 , 0xFFFFFF, true);
        PlayerStatsHelper.renderProgressBar(context,requestedPlayer.getSelectedCharacterData().getProfessions().getAlchemism().getXpPercent(), false,leftpos + 150, toppos + 90);
        context.drawText(textRenderer, Text.literal("Jeweling:" + requestedPlayer.getSelectedCharacterData().getProfessions().getJeweling().getLevel()), leftpos+ 150,toppos + 100 , 0xFFFFFF, true);
        PlayerStatsHelper.renderProgressBar(context,requestedPlayer.getSelectedCharacterData().getProfessions().getJeweling().getXpPercent(), false,leftpos + 150, toppos + 110);
        context.drawText(textRenderer, Text.literal("Armouring: " + requestedPlayer.getSelectedCharacterData().getProfessions().getArmouring().getLevel()), leftpos+ 150,toppos + 120 , 0xFFFFFF, true);
        PlayerStatsHelper.renderProgressBar(context,requestedPlayer.getSelectedCharacterData().getProfessions().getArmouring().getXpPercent(), false,leftpos + 150, toppos + 130);
        context.drawText(textRenderer, Text.literal("Tailoring: " + requestedPlayer.getSelectedCharacterData().getProfessions().getTailoring().getLevel()), leftpos+ 150,toppos + 140 , 0xFFFFFF, true);
        PlayerStatsHelper.renderProgressBar(context,requestedPlayer.getSelectedCharacterData().getProfessions().getTailoring().getXpPercent(), false,leftpos + 150, toppos + 150);
        context.drawText(textRenderer, Text.literal("Weaponsmithing: " + requestedPlayer.getSelectedCharacterData().getProfessions().getWeaponsmithing().getLevel()), leftpos+ 150,toppos + 160 , 0xFFFFFF, true);
        PlayerStatsHelper.renderProgressBar(context,requestedPlayer.getSelectedCharacterData().getProfessions().getWeaponsmithing().getXpPercent(), false,leftpos + 150, toppos + 170);
        context.drawText(textRenderer, Text.literal("Woodworking:" + requestedPlayer.getSelectedCharacterData().getProfessions().getWoodworking().getLevel()), leftpos+ 150,toppos + 180 , 0xFFFFFF, true);
        PlayerStatsHelper.renderProgressBar(context,requestedPlayer.getSelectedCharacterData().getProfessions().getWoodworking().getXpPercent(), false,leftpos + 150, toppos + 190);
    }

    @Override
    public void renderBackground(DrawContext context, int mouseX, int mouseY, float delta) {
        context.drawTexture(PLAYERBACKGROUND_STATS,  leftpos, toppos + 15,0,0, 384,220, 384, 220);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }

}
