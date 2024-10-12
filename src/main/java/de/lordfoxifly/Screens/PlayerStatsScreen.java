package de.lordfoxifly.Screens;

import de.lordfoxifly.Api.PlayerAPI.Player;
import de.lordfoxifly.Api.PlayerAPIHelper;
import de.lordfoxifly.Api.RequestHelper;
import de.lordfoxifly.Screens.PlayerStats.PlayerStatsHelper;
import de.lordfoxifly.Screens.Widgets.Buttons;
import de.lordfoxifly.Screens.Widgets.TextFields;
import de.lordfoxifly.WynnMiata;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.io.IOException;
import java.net.URISyntaxException;

public class PlayerStatsScreen extends Screen {

    private static final Text TITLE = Text.translatable("gui." + WynnMiata.MOD_ID + "playerstats");
    private static final Identifier PLAYERBACKGROUND_STATS = Identifier.of("wynnmiata", "textures/gui/playerstats_texture.png");

    private  final int imagewidth, imageheight;
    private int leftpos, toppos;

    public static Player getRequestedPlayer() {
        return requestedPlayer;
    }

    private static Player requestedPlayer;

    private TextFieldWidget textFieldWidget;


    public PlayerStatsScreen(Player requestedPlayer) {
        super(TITLE);
        imageheight = 256;
        imagewidth = imageheight;
        PlayerStatsScreen.requestedPlayer = requestedPlayer;
    }

    public static   void setPlayer(String username) {
        try {
             requestedPlayer = PlayerAPIHelper.getPlayer(RequestHelper.getAPIData("https://api.wynncraft.com/v3/player/"+ username ));//MinecraftClient.getInstance().getSession().getUsername()));
        } catch (URISyntaxException | IOException | InterruptedException e) {
            WynnMiata.LOGGER.error(e.toString());
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void init() {
        super.init();
        leftpos = (this.width - this.imagewidth ) / 2 - 64;
        toppos = (this.height - this.imageheight) / 2;

        textFieldWidget = TextFields.PlayerStatSearch(leftpos, toppos);
        addDrawableChild(textFieldWidget);
        addDrawableChild(TextFields.PLayerStatSearchEnter(leftpos,toppos,textFieldWidget));
        addDrawableChild(Buttons.RAIDSTATS(leftpos,toppos));
        addDrawableChild(Buttons.DEFAULTSTATS(leftpos, toppos, true));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context,mouseX,mouseY,delta);
        super.render(context, mouseX, mouseY, delta);
        if (requestedPlayer !=null){
           renderPlayerStats(context);
        }
        else {
            requestedPlayer = WynnMiata.ClientPlayer;
        }

    }

    private void renderPlayerStats(DrawContext context) {
        context.drawText(textRenderer, "Stats of : " + requestedPlayer.getUsername(), leftpos + 15, toppos + 35, 0xFFFFFFFF, true);
        context.drawText(textRenderer, "Online: ",leftpos + 15, toppos + 45, 0xFFFFFFFF, true);
        PlayerStatsHelper.renderOnlineWool(context, requestedPlayer.isOnline(), leftpos,toppos);
        context.drawText(textRenderer, "Rank: " + getSupportRank(requestedPlayer), leftpos + 15, toppos + 55, 0xFFFFFFFF, true);
        context.drawText(textRenderer, "Total Time Played : " + requestedPlayer.getPlaytime(), leftpos + 15, toppos + 65, 0xFFFFFFFF, true);

    }

    @Override
    public void renderBackground(DrawContext context, int mouseX, int mouseY, float delta) {
        context.drawTexture(PLAYERBACKGROUND_STATS,  leftpos, toppos + 15,0,0, 384,220, 384, 220);


    }

    @Override
    public boolean shouldPause() {
        return false;
    }


    public String getSupportRank(Player player){
        if (player.getSupportRank() != null){
            return player.getSupportRank().toUpperCase();
        }
        else return  "Player";
    }
}
