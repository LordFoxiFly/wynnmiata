package de.lorfoxifly.Screens;

import de.lorfoxifly.Screens.Widgets.Buttons;
import de.lorfoxifly.Screens.Widgets.CheckBoxs;
import de.lorfoxifly.WynnMiata;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;


public class MiscScreen extends Screen {
    private static final Text MISC_TITLE = Text.translatable(WynnMiata.MOD_ID, "gui."+ WynnMiata.MOD_ID + ".settings.MISC");
    private static final Identifier BACKGROUND_IMAGE = Identifier.of("wynnmiata", "textures/gui/background_texture.png");
    private  int leftpos, toppos;
    private final int imagewidth,imageheight;
    public MiscScreen() {
        super(MISC_TITLE);
        this.imageheight = 256;
        this.imagewidth = imageheight;
    }

    @Override
    protected void init() {
        super.init();
        leftpos = (this.width - this.imagewidth ) / 2;
        toppos = (this.height - this.imageheight) / 2;

        Buttons.leftpos = leftpos;
        Buttons.toppos = toppos;
        addDrawableChild(Buttons.TCC);
        addDrawableChild(Buttons.NOL);
        addDrawableChild(Buttons.MISC);
        addDrawableChild(CheckBoxs.HeadRendering);
        addDrawableChild(CheckBoxs.FireEntityRendering);
        addDrawableChild(CheckBoxs.FireHudRendering);
        addDrawableChild(CheckBoxs.ArmorRendering);
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
