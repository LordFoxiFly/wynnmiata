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
            TextFieldWidget colorTextFiled = TextFields.ShowPlayerRaidsColorTextField(leftpos + 30, toppos + 60);
            colorTextFiled.setText(WynnMiata.CONFIG.getShowPlayerRaidColor());
            addDrawableChild(colorTextFiled);
            addDrawableChild(xTextField);
            addDrawableChild(yTextField);
            addDrawableChild(TextFields.ShowPlayerRaidsEnter(leftpos,toppos,this.width, this.height,xTextField, yTextField));
            addDrawableChild(TextFields.ShowPlayerRaidsColorEnter(leftpos + 100, toppos + 60, colorTextFiled));
        }
        if (layoutType == LayoutTypes.ArmorDuration){
            TextFieldWidget xTextField = TextFields.LayoutMenuXTextField(leftpos + 20,toppos + 33);
            xTextField.setText(String.valueOf(WynnMiata.CONFIG.getArmorDurabilityX()));
            TextFieldWidget yTextField = TextFields.LayoutMenuYTextField(leftpos + 100,toppos + 33);
            yTextField.setText(String.valueOf(WynnMiata.CONFIG.getArmorDurabilityY()));
            TextFieldWidget colorTextFiled = TextFields.LayoutMenuColorTextField(leftpos + 30, toppos + 60);
            colorTextFiled.setText(WynnMiata.CONFIG.getArmorDurabilityTextColor());
            TextFieldWidget xTextTextField = TextFields.LayoutMenuXTextField(leftpos + 20,toppos + 88);
            xTextTextField.setText(String.valueOf(WynnMiata.CONFIG.getArmorDurabilityTextX()));
            TextFieldWidget yTextTextField = TextFields.LayoutMenuYTextField(leftpos + 100, toppos +88);
            yTextTextField.setText(String.valueOf(WynnMiata.CONFIG.getArmorDurabilityTextY()));
            addDrawableChild(xTextTextField);
            addDrawableChild(yTextTextField);
            addDrawableChild(colorTextFiled);
            addDrawableChild(xTextField);
            addDrawableChild(yTextField);
            addDrawableChild(TextFields.ArmorDurabilityTextCoordsEnter(leftpos,toppos, this.width, this.height, xTextTextField, yTextTextField));
            addDrawableChild(TextFields.ArmorDurabilityCoordsEnter(leftpos,toppos,this.width, this.height,xTextField, yTextField));
            addDrawableChild(TextFields.ArmorDurabilityColorEnter(leftpos + 100, toppos + 60, colorTextFiled));
        }
        if (layoutType == LayoutTypes.PROFESSIONHUD){
            TextFieldWidget xTextField = TextFields.LayoutMenuXTextField(leftpos + 20,toppos + 33);
            xTextField.setText(String.valueOf(WynnMiata.CONFIG.getProfessionHudX()));
            TextFieldWidget yTextField = TextFields.LayoutMenuYTextField(leftpos + 100,toppos + 33);
            yTextField.setText(String.valueOf(WynnMiata.CONFIG.getProfessionHudY()));
            TextFieldWidget colorTextFiled = TextFields.LayoutMenuColorTextField(leftpos + 30, toppos + 60);
            colorTextFiled.setText(WynnMiata.CONFIG.getProfessionHudTextColor());
            TextFieldWidget xTextTextField = TextFields.LayoutMenuXTextField(leftpos + 20,toppos + 88);
            xTextTextField.setText(String.valueOf(WynnMiata.CONFIG.getProfessionHudTextX()));
            TextFieldWidget yTextTextField = TextFields.LayoutMenuYTextField(leftpos + 100, toppos +88);
            yTextTextField.setText(String.valueOf(WynnMiata.CONFIG.getProfessionHudTextY()));
            addDrawableChild(xTextTextField);
            addDrawableChild(yTextTextField);
            addDrawableChild(colorTextFiled);
            addDrawableChild(xTextField);
            addDrawableChild(yTextField);
            addDrawableChild(TextFields.ProfessionHudTextCoordsEnter(leftpos,toppos, this.width, this.height, xTextTextField, yTextTextField));
            addDrawableChild(TextFields.ProfessionHudCoordsEnter(leftpos,toppos,this.width, this.height,xTextField, yTextField));
            addDrawableChild(TextFields.ProfessionHudColorEnter(leftpos + 100, toppos + 60, colorTextFiled));
        }
    }
    private void getElements(LayoutTypes layoutType, DrawContext context) {
        if (layoutType == LayoutTypes.ShowPlayerRaids){
            context.drawText(textRenderer, "Layout", leftpos + 8, toppos + 25, 0xFFFFFF, true);
            context.drawText(textRenderer, "X:", leftpos + 10, toppos + 35, 0xFFFFFFFF, true);
            context.drawText(textRenderer, "Y:", leftpos + 90, toppos + 35, 0xFFFFFFFF, true);
            context.drawText(textRenderer, "Color:", leftpos + 8, toppos + 50, 0xFFFFFF, true);
            context.drawText(textRenderer, "Hex:", leftpos + 8, toppos + 63, 0xFFFFFF, true);
        }
        if (layoutType == LayoutTypes.ArmorDuration){
            context.drawText(textRenderer, "Layout", leftpos + 8, toppos + 25, 0xFFFFFF, true);
            context.drawText(textRenderer, "X:", leftpos + 10, toppos + 35, 0xFFFFFFFF, true);
            context.drawText(textRenderer, "Y:", leftpos + 90, toppos + 35, 0xFFFFFFFF, true);
            context.drawText(textRenderer, "Text Color:", leftpos + 8, toppos + 50, 0xFFFFFF, true);
            context.drawText(textRenderer, "Hex:", leftpos + 8, toppos + 63, 0xFFFFFF, true);
            context.drawText(textRenderer, "Text Layout:", leftpos + 8, toppos + 78, 0xFFFFFF, true);
            context.drawText(textRenderer, "X:", leftpos + 10, toppos + 90, 0xFFFFFF, true);
            context.drawText(textRenderer, "Y:", leftpos + 90, toppos + 90, 0xFFFFFF, true);
        }
        if (layoutType == LayoutTypes.PROFESSIONHUD){
            context.drawText(textRenderer, "Layout", leftpos + 8, toppos + 25, 0xFFFFFF, true);
            context.drawText(textRenderer, "X:", leftpos + 10, toppos + 35, 0xFFFFFFFF, true);
            context.drawText(textRenderer, "Y:", leftpos + 90, toppos + 35, 0xFFFFFFFF, true);
            context.drawText(textRenderer, "Text Color:", leftpos + 8, toppos + 50, 0xFFFFFF, true);
            context.drawText(textRenderer, "Hex:", leftpos + 8, toppos + 63, 0xFFFFFF, true);
            context.drawText(textRenderer, "Text Layout:", leftpos + 8, toppos + 78, 0xFFFFFF, true);
            context.drawText(textRenderer, "X:", leftpos + 10, toppos + 90, 0xFFFFFF, true);
            context.drawText(textRenderer, "Y:", leftpos + 90, toppos + 90, 0xFFFFFF, true);
        }
    }

}
