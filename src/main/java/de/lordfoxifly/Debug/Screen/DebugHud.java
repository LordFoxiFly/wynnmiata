package de.lordfoxifly.Debug.Screen;

import de.lordfoxifly.WynnMiata;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.text.Text;

public class DebugHud implements HudRenderCallback {


    /**
     * @param drawContext the {@link DrawContext} instance
     * @param tickCounter the {@link RenderTickCounter} instance
     */
    @Override
    public void onHudRender(DrawContext drawContext, RenderTickCounter tickCounter) {
        if (WynnMiata.CONFIG != null && WynnMiata.CONFIG.isDebugHudBoolean()) {
            drawContext.drawText(MinecraftClient.getInstance().textRenderer, Text.literal("This is a debug feature "), 250, 200, 0x00FF00, true);
        }
    }
}
