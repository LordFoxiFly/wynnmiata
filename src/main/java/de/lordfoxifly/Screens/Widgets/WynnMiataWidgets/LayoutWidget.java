package de.lordfoxifly.Screens.Widgets.WynnMiataWidgets;

import de.lordfoxifly.WynnMiata;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.widget.PressableWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class LayoutWidget extends PressableWidget {

    private final LayoutWidget.PressAction onPress;

    public DrawContext getDrawContext() {
        return drawContext;
    }

    private DrawContext drawContext;


    public LayoutWidget(int x, int y, int width, int height, Text key,  LayoutWidget.PressAction onPress) {
        super(x, y, width, height, key);
        this.onPress = onPress;
    }


    /**
     * @param context
     * @param mouseX
     * @param mouseY
     * @param delta
     */
    @Override
    protected void renderWidget(DrawContext context, int mouseX, int mouseY, float delta) {

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



    @Environment(EnvType.CLIENT)
    public interface PressAction {
        void onPress(LayoutWidget button);
    }

}
