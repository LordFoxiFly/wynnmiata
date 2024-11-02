package de.lordfoxifly.Screens.Customize;

import de.lordfoxifly.Screens.Layout.LayoutTypes;
import de.lordfoxifly.Screens.LayoutScreen;
import de.lordfoxifly.Screens.SettingScreen;
import de.lordfoxifly.Screens.Widgets.Buttons;
import de.lordfoxifly.Screens.Widgets.TextFields;
import de.lordfoxifly.WynnMiata;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CustomizeMenuScreen extends Screen {
    private static final Text TITLE = Text.translatable("gui." + WynnMiata.MOD_ID + ".layout.LayoutMenuScreen");
    private static final Identifier BACKGROUND_IMAGE = Identifier.of("wynnmiata", "textures/gui/background_texture.png");

    private  int leftpos, toppos;
    private final int imagewidth,imageheight;
    private final CustomizeTypes layoutType;


    public CustomizeMenuScreen(CustomizeTypes layoutType) {
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
        addDrawableChild(Buttons.LavaHighlight(leftpos,toppos));
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
        MinecraftClient.getInstance().setScreen(new SettingScreen());
        return false;
    }

    private void getWidgets(CustomizeTypes layoutType) {
        if (layoutType == CustomizeTypes.LAVAHIGHLIGHT){
            TextFieldWidget colorTextFiled = TextFields.LavaHighlightColorTextField(leftpos + 100, toppos + 33);
            colorTextFiled.setText(WynnMiata.CONFIG.getHighLightLavaColor());
            addDrawableChild(colorTextFiled);
            addDrawableChild(TextFields.LavaHighlightColorEnter(leftpos + 160, toppos + 33, colorTextFiled));
        }
    }
    private void getElements(CustomizeTypes layoutType, DrawContext context) {
        if (layoutType == CustomizeTypes.LAVAHIGHLIGHT){
            context.drawText(textRenderer, "Color:", leftpos + 75, toppos + 25, 0xFFFFFF, true);
            context.drawText(textRenderer, "Hex:", leftpos + 75, toppos + 35, 0xFFFFFF, true);
        }
    }

}
