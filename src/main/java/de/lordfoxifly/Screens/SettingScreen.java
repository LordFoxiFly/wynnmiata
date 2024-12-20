package de.lordfoxifly.Screens;

import de.lordfoxifly.Api.PlayerAPIHelper;
import de.lordfoxifly.Api.RequestHelper;
import de.lordfoxifly.Screens.Widgets.Buttons;
import de.lordfoxifly.WynnMiata;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.io.IOException;
import java.net.URISyntaxException;

public class SettingScreen extends Screen {

    private static final  Text TITLE = Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.SettingScreen");
    private static final Identifier BACKGROUND_IMAGE = Identifier.of("wynnmiata", "textures/gui/background_texture.png");

    public static int getLeftpos() {
        return leftpos;
    }

    public static int getToppos() {
        return toppos;
    }

    private static int leftpos, toppos;
    private final int imagewidth,imageheight;

    private final int NOLGPlayerComps, TCCPlayerComps, TNAPlayerComps, NOLPlayerComps;

    public SettingScreen() {
        super(TITLE);
        this.imagewidth = 256;
        this.imageheight= 256;
        String source = "ERROR";

        NOLGPlayerComps = WynnMiata.ClientPlayer.getGlobalData().getRaids().getList().getNestOfTheGrootslangs();
        TCCPlayerComps = WynnMiata.ClientPlayer.getGlobalData().getRaids().getList().getTheCanyonColossus();
        TNAPlayerComps = WynnMiata.ClientPlayer.getGlobalData().getRaids().getList().getTheNamelessAnomaly();
        NOLPlayerComps = WynnMiata.ClientPlayer.getGlobalData().getRaids().getList().getOrphionSNexusOfLight();
    }

    @Override
    protected void init() {
        leftpos = (this.width - this.imagewidth ) / 2;
        toppos = (this.height - this.imageheight) / 2;
        super.init();
        addDrawableChild(Buttons.TTCButton(leftpos, toppos));
        addDrawableChild(Buttons.NOLButton(leftpos, toppos));
        addDrawableChild(Buttons.MISCButton(leftpos, toppos));
        addDrawableChild(Buttons.RAIDSButton(leftpos,toppos));
        addDrawableChild(Buttons.DebugButton(leftpos,toppos));
        addDrawableChild(Buttons.CustomizeButton(leftpos,toppos));
        addDrawableChild(Buttons.LayoutButton(leftpos,toppos));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        if (WynnMiata.ClientPlayer != null){
            context.drawText(textRenderer, "NOLG Completions: " + NOLGPlayerComps, leftpos + 80, toppos + 28, 0xFFFFFFFF, true);
            context.drawText(textRenderer, "TCC Completions: " + TCCPlayerComps, leftpos + 80, toppos + 38, 0xFFFFFFFF, true);
            context.drawText(textRenderer, "NOL Completions: " + NOLPlayerComps, leftpos + 80, toppos + 48, 0xFFFFFFFF, true);
            context.drawText(textRenderer, "TNA Completions: " + TNAPlayerComps, leftpos + 80, toppos + 58, 0xFFFFFFFF, true);
        }
    }

    @Override
    public void renderBackground(DrawContext context, int mouseX, int mouseY, float delta) {
        context.drawTexture(BACKGROUND_IMAGE,  leftpos, toppos + 15,0,0, 256,220, 256, 220);
    }

}
