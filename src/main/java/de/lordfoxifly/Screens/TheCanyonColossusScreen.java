package de.lordfoxifly.Screens;

import de.lordfoxifly.Screens.Widgets.Buttons;
import de.lordfoxifly.Screens.Widgets.CheckBoxs;
import de.lordfoxifly.Screens.Widgets.TextFields;
import de.lordfoxifly.WynnMiata;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class TheCanyonColossusScreen extends Screen {

    private static final Text TCC_TITLE = Text.translatable("gui." + WynnMiata.MOD_ID + ".settings.TCC");
    private static final Identifier BACKGROUND_IMAGE = Identifier.of("wynnmiata", "textures/gui/background_texture.png");
    public int yHighlightLavaOffset = 0;
    private  int leftpos, toppos;
    private TextFieldWidget redlavacolor;
    private TextFieldWidget bluelavacolor;
    private TextFieldWidget greenlavacolor;
    private ButtonWidget highlightlavacolorenter;
    private final int imagewidth,imageheight;
    public TheCanyonColossusScreen() {
        super(TCC_TITLE);
        imageheight = 256;
        imagewidth = 256;
    }

    @Override
    protected void init() {
        leftpos = (this.width - this.imagewidth ) / 2;
        toppos = (this.height - this.imageheight) / 2;
        super.init();


        addDrawableChild(Buttons.TTCButton(leftpos,toppos));
        addDrawableChild(Buttons.NOLButton(leftpos, toppos));
        addDrawableChild(Buttons.MISCButton(leftpos, toppos));
        addDrawableChild(Buttons.RAIDSButton(leftpos,toppos));
        addDrawableChild(Buttons.DebugButton(leftpos,toppos));
        addDrawableChild(Buttons.LayoutButton(leftpos,toppos));
        addDrawableChild(Buttons.CustomizeButton(leftpos,toppos));
        addDrawableChild(CheckBoxs.HighlightLava(leftpos, toppos));

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


    public void renderColorInput(DrawContext context){
    }
}

