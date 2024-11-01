package de.lordfoxifly.Screens.Widgets.WynnMiataWidgets;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.apache.commons.lang3.NotImplementedException;

public class AbilityPerkWidget extends ClickableWidget {

    private final Identifier image;
    private int x, y,  width, height;
    public AbilityPerkWidget(int x, int y, int width, int height,Text message,Identifier image) {
        super(x, y, width, height, message);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
    }

    /**
     * @param context
     * @param mouseX
     * @param mouseY
     * @param delta
     */
    @Override
    protected void renderWidget(DrawContext context, int mouseX, int mouseY, float delta) {
        context.drawTexture(image, x, y, 0, 0 , width, height, width, height);
    }

    /**
     * @param builder
     */
    @Override
    protected void appendClickableNarrations(NarrationMessageBuilder builder) {
        throw new NotImplementedException();
    }

    /**
     * @param x
     * @param y
     */
    @Override
    public void setPosition(int x, int y) {
        super.setPosition(x, y);
    }

}
