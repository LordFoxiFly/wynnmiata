package de.lordfoxifly.Screens.PlayerStats.Screens;

import de.lordfoxifly.Api.PlayerAPI.Player;
import de.lordfoxifly.Api.PlayerAPIHelper;
import de.lordfoxifly.Api.RequestHelper;
import de.lordfoxifly.Screens.PlayerStats.PlayerStatsHelper;
import de.lordfoxifly.Screens.Widgets.Buttons;
import de.lordfoxifly.Screens.Widgets.TextFields;
import de.lordfoxifly.WynnMiata;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Logger;

public class RaidStatScreen extends Screen {

    private static final Text TITLE = Text.translatable("gui." + WynnMiata.MOD_ID + "playerstats");

    private static final  Text TCCComps = Text.translatable( "gui." + WynnMiata.MOD_ID + ".playerstats.raidstats.Lable.TCCComps");
    private static final  Text NOGComps = Text.translatable( "gui." + WynnMiata.MOD_ID + ".playerstats.raidstats.Lable.NOGComps");
    private static final  Text NOLComps = Text.translatable( "gui." + WynnMiata.MOD_ID + ".playerstats.raidstats.Lable.NOLComps");
    private static final  Text TNAComps = Text.translatable( "gui." + WynnMiata.MOD_ID + ".playerstats.raidstats.Lable.TNAComps");

    private static final Identifier PLAYERBACKGROUND_STATS = Identifier.of("wynnmiata", "textures/gui/playerstats_texture.png");

    private  final int imagewidth, imageheight;
    private int leftpos, toppos;
    private final Player requestedPlayer;

    private TextFieldWidget textFieldWidget;


    public RaidStatScreen(Player requestedPlayer) {
        super(TITLE);
        imageheight = 256;
        imagewidth = imageheight;
        this.requestedPlayer = requestedPlayer;
        WynnMiata.LOGGER.info(requestedPlayer.getUsername());

    }

    @Override
    protected void init() {
        super.init();
        leftpos = (this.width - this.imagewidth ) / 2 - 64;
        toppos = (this.height - this.imageheight) / 2;
        addDrawableChild(Buttons.RAIDSTATS(leftpos,toppos, true));
        addDrawableChild(Buttons.DEFAULTSTATS(leftpos,toppos ));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context,mouseX,mouseY,delta);
        super.render(context, mouseX, mouseY, delta);

        context.drawText(MinecraftClient.getInstance().textRenderer, NOLComps , leftpos + 22, toppos + 33,0xFFFFFFFF, true  );
        context.drawText(MinecraftClient.getInstance().textRenderer, "" + requestedPlayer.getGlobalData().getRaids().getList().getNestOfTheGrootslangs(), leftpos + 22, toppos +43, 0xFFFFFFFF, true );
        context.drawText(MinecraftClient.getInstance().textRenderer, TCCComps , leftpos + 22, toppos + 53,0xFFFFFFFF, true  );
        context.drawText(MinecraftClient.getInstance().textRenderer, "" + requestedPlayer.getGlobalData().getRaids().getList().getTheCanyonColossus(), leftpos + 22, toppos +63, 0xFFFFFFFF, true );
        context.drawText(MinecraftClient.getInstance().textRenderer, NOLComps , leftpos + 22, toppos + 73,0xFFFFFFFF, true  );
        context.drawText(MinecraftClient.getInstance().textRenderer,  "" +requestedPlayer.getGlobalData().getRaids().getList().getOrphionSNexusOfLight(), leftpos + 22, toppos +83, 0xFFFFFFFF, true );
        context.drawText(MinecraftClient.getInstance().textRenderer, TNAComps , leftpos + 22, toppos + 93,0xFFFFFFFF, true  );
        context.drawText(MinecraftClient.getInstance().textRenderer, "" + requestedPlayer.getGlobalData().getRaids().getList().getTheNamelessAnomaly(), leftpos + 22, toppos +103, 0xFFFFFFFF, true );

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
