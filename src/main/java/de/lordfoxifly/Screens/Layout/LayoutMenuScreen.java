package de.lordfoxifly.Screens.Layout;

import de.lordfoxifly.Screens.LayoutScreen;
import de.lordfoxifly.Screens.Widgets.TextFields;
import de.lordfoxifly.WynnMiata;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class LayoutMenuScreen extends Screen {
    private static final Text TITLE = Text.translatable("gui." + WynnMiata.MOD_ID + ".layout.LayoutMenuScreen");
    private static final Identifier BACKGROUND_IMAGE = Identifier.of("wynnmiata", "textures/gui/layout_texture.png");

    private  int leftpos, toppos;
    private final int imagewidth,imageheight;
    private final LayoutTypes layoutType;


    public LayoutMenuScreen(LayoutTypes layoutType) {
        super(TITLE);
        this.imagewidth = 256;
        this.imageheight= 256;
        this.layoutType = layoutType;
    }

    @Override
    protected void init() {
        leftpos = (this.width - this.imagewidth ) / 2;
        toppos = (this.height - this.imageheight) / 2;
        super.init();
        getWidgets(layoutType);
    }



    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context,mouseX,mouseY,delta);
        super.render(context, mouseX, mouseY, delta);
        getElements(layoutType, context);
    }

    @Override
    public void renderBackground(DrawContext context, int mouseX, int mouseY, float delta) {
        context.drawTexture(BACKGROUND_IMAGE,  leftpos, toppos + 15,0,0, 256,220, 256, 220);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }


    @Override
    public boolean shouldCloseOnEsc() {
        MinecraftClient.getInstance().setScreen(new LayoutScreen());
        return false;
    }

    private void getWidgets(LayoutTypes layoutType) {
        if (layoutType == LayoutTypes.ShowPlayerRaids){
            TextFieldWidget xTextField = TextFields.ShowPlayerRaidsXTextField(leftpos,toppos);
            xTextField.setText(String.valueOf(WynnMiata.CONFIG.getShowPlayerRaidx()));
            TextFieldWidget yTextField = TextFields.ShowPlayerRaidsYTextField(leftpos,toppos);
            yTextField.setText(String.valueOf(WynnMiata.CONFIG.getShowPlayerRaidy()));
            addDrawableChild(xTextField);
            addDrawableChild(yTextField);
            addDrawableChild(TextFields.ShowPlayerRaidsEnter(leftpos,toppos,this.width, this.height,xTextField, yTextField));
        }
    }
    private void getElements(LayoutTypes layoutType, DrawContext context) {
        if (layoutType == LayoutTypes.ShowPlayerRaids){
            context.drawText(textRenderer, "Layout", leftpos + 8, toppos + 25, 0xFFFFFFFF, true);
            context.drawText(textRenderer, "X:", leftpos + 10, toppos + 35, 0xFFFFFFFF, true);
            context.drawText(textRenderer, "Y:", leftpos + 90, toppos + 35, 0xFFFFFFFF, true);
        }
    }

}