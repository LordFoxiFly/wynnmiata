package de.lordfoxifly.Screens.Widgets;

import de.lordfoxifly.Api.PlayerAPI.Player;
import de.lordfoxifly.Screens.PlayerStats.Screens.RaidStatScreen;
import de.lordfoxifly.WynnMiata;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.PlayerSkinDrawer;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.gui.widget.PressableWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ImageButtonWidget extends PressableWidget {
    private static final Identifier Selected = Identifier.of(WynnMiata.MOD_ID, "textures/gui/playerstatstab_selected.png");
    private static final Identifier UnSelected = Identifier.of(WynnMiata.MOD_ID, "textures/gui/playerstatstab.png");
    private final Identifier BackgroundImage;
    private boolean isSelected;
    private final PressAction onPress;
    private int yBackgroundOffset =  5;
    private int xBackgroundOffsets = 0;


    public ImageButtonWidget(int x, int y, int width, int height, Text key, Identifier backgroundImage, boolean isSelected ,PressAction onPress) {
        super(x, y, width, height, key);
        this.BackgroundImage = backgroundImage;
        this.onPress = onPress;
        this.isSelected = isSelected;
    }


    /**
     * @param context
     * @param mouseX
     * @param mouseY
     * @param delta
     */
    @Override
    protected void renderWidget(DrawContext context, int mouseX, int mouseY, float delta) {
        if (isSelected) { context.drawTexture(Selected, getX() , getY() - yBackgroundOffset, 0 , 0 ,  getWidth() + xBackgroundOffsets, getHeight() +yBackgroundOffset,   getWidth(), getHeight()  + 5);}
        else {context.drawTexture(UnSelected, getX(), getY() - yBackgroundOffset, 0 , 0 ,  getWidth() +xBackgroundOffsets,  getHeight() + yBackgroundOffset,getWidth(), getHeight() +5);}
        context.drawTexture(BackgroundImage, getX(), getY(), 0 , 0 ,getWidth(), getHeight(), getWidth(), getHeight());

    }


    /**
     * @param builder
     */
    @Override
    protected void appendClickableNarrations(NarrationMessageBuilder builder) {
            
    }

    @Override
    public void onPress() {
        this.onPress.onPress(this);
    }

    public void renderPlayerHead() {

    }


    @Environment(EnvType.CLIENT)
    public interface PressAction {
        void onPress(ImageButtonWidget button);
    }

    public void setyBackgroundOffset(int yBackgroundOffset){
        this.yBackgroundOffset = yBackgroundOffset;
    }
    public void setxBackgroundOffsets(int xBackgroundOffsets){
        this.xBackgroundOffsets = xBackgroundOffsets;
    }

    public void setSelected(boolean isSelected){
        this.isSelected = isSelected;
    }
}
