package de.lorfoxifly.Screens;

import de.lorfoxifly.Screens.Widgets.Buttons;
import de.lorfoxifly.WynnMiata;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class SettingScreen extends Screen {

    private static final  Text TITLE = Text.translatable("gui." + WynnMiata.MOD_ID + "settings.SettingScreen");
    private static final Identifier BACKGROUND_IMAGE = Identifier.of("wynnmiata", "textures/gui/background_texture.png");
    private  int leftpos, toppos;
    private final int imagewidth,imageheight;

    public SettingScreen() {
        super(TITLE);
        this.imagewidth = 256;
        this.imageheight= 256;
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
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public void renderBackground(DrawContext context, int mouseX, int mouseY, float delta) {
        context.drawTexture(BACKGROUND_IMAGE,  leftpos, toppos + 15,0,0, 256,220, 256, 220);


    }
}
