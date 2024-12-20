package de.lordfoxifly.Screens;

import de.lordfoxifly.Screens.Widgets.Buttons;
import de.lordfoxifly.Screens.Widgets.CheckBoxs;
import de.lordfoxifly.WynnMiata;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class DebugScreen extends Screen {

    private static final Text DEBUG_TITLE = Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.DEBUG");
    private static final Identifier BACKGROUND_IMAGE = Identifier.of("wynnmiata", "textures/gui/background_texture.png");

    private  int leftpos, toppos;
    private final int imagewidth,imageheight;
    public DebugScreen() {
        super(DEBUG_TITLE);
        imageheight = 256;
        imagewidth = 256;
    }

    @Override
    protected void init() {
        super.init();
        leftpos = (this.width - this.imagewidth ) / 2;
        toppos = (this.height - this.imageheight) / 2;

        addDrawableChild(Buttons.TTCButton(leftpos,toppos));
        addDrawableChild(Buttons.NOLButton(leftpos, toppos));
        addDrawableChild(Buttons.MISCButton(leftpos, toppos));
        addDrawableChild(Buttons.RAIDSButton(leftpos,toppos));
        addDrawableChild(Buttons.DebugButton(leftpos,toppos));
        addDrawableChild(Buttons.CustomizeButton(leftpos,toppos));
        addDrawableChild(Buttons.LayoutButton(leftpos,toppos));
        addDrawableChild(CheckBoxs.debugEvents(leftpos, toppos));
        addDrawableChild(CheckBoxs.debugRaids(leftpos,toppos));
        addDrawableChild(CheckBoxs.debugHud(leftpos,toppos));

    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context,mouseX,mouseY,delta);
        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public void renderBackground(DrawContext context, int mouseX, int mouseY, float delta) {
        context.drawTexture(BACKGROUND_IMAGE,  leftpos, toppos + 15,0,0, 256,220, 256, 220);
    }
}
