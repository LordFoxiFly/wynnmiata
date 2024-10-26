package de.lordfoxifly.Screens.PlayerStats.Screens;

import de.lordfoxifly.Api.PlayerAPI.Player;
import de.lordfoxifly.WynnMiata;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ProfStatScreen extends Screen {

    private static final Text TITLE = Text.translatable("gui." + WynnMiata.MOD_ID + "playerstats");
    private static final Identifier PLAYERBACKGROUND_STATS = Identifier.of("wynnmiata", "textures/gui/playerstats_texture.png");
    private final String characteruuid;
    private Player requestedPlayer;

    private  final int imagewidth, imageheight;
    private int leftpos, toppos;
    public ProfStatScreen(Player player, String characteruuid){
        super(TITLE);
        imageheight = 256;
        imagewidth = imageheight;
        this.requestedPlayer = player;
        this.characteruuid = characteruuid;
    }

    @Override
    protected void init() {
        super.init();
        leftpos = (this.width - this.imagewidth ) / 2 - 64;
        toppos = (this.height - this.imageheight) / 2;
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context,mouseX,mouseY,delta);
        super.render(context, mouseX, mouseY, delta);
        context.drawText(textRenderer,Text.literal("Class: " + requestedPlayer.getCharacterData().getFirst().getType()), leftpos + 20, toppos + 20, 0xFFFFFF, true);
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
