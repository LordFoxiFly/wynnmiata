package de.lordfoxifly.Features.Items;

import de.lordfoxifly.WynnMiata;
import de.lordfoxifly.WynnMiataUtils.ColorUtils;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.item.Item;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public class AccessoryDurabilityHud implements HudRenderCallback {

    private static final Identifier ring = Identifier.of(WynnMiata.MOD_ID, "textures/gui/wynncrafttexture/ring.png");
    private static final Identifier bracelet =Identifier.of(WynnMiata.MOD_ID, "textures/gui/wynncrafttexture/bracelet.png");
    private static final Identifier necklace = Identifier.of(WynnMiata.MOD_ID, "textures/gui/wynncrafttexture/necklace.png");
    /**
     * @param drawContext the {@link DrawContext} instance
     * @param tickCounter the {@link RenderTickCounter} instance
     */
    @Override
    public void onHudRender(DrawContext drawContext, RenderTickCounter tickCounter) {
        if (WynnMiata.CONFIG.isAccessoryDurabilityBoolean() && WynnMiata.CONFIG.isRenderHudElements()){
            int slot = 9;
            for (int i = WynnMiata.CONFIG.getAccessoryDurabilityTextY(); i <= WynnMiata.CONFIG.getAccessoryDurabilityTextY() + 60; i += 20){
                if (!MinecraftClient.getInstance().player.getInventory().getStack(slot).isEmpty() && ItemUtils.hasItemDurability(MinecraftClient.getInstance().player.getInventory().getStack(slot))){
                    String durability = String.valueOf(ItemUtils.getItemDurability(MinecraftClient.getInstance().player.getInventory().getStack(slot)));
                    switch (slot) {

                        case 9 ->{
                                drawContext.drawTexture(ring, WynnMiata.CONFIG.getAccessoryDurabilityX(), WynnMiata.CONFIG.getArmorDurabilityY(), 0, 0, 16, 16, 16, 16);
                        if (!WynnMiata.CONFIG.isAccessoryDurabilityOnly()) {
                            durability = "[" + durability + "/" + ItemUtils.getItemMaxDurability(MinecraftClient.getInstance().player.getInventory().getStack(slot));
                        }
                        drawContext.drawText(MinecraftClient.getInstance().textRenderer, durability,WynnMiata.CONFIG.getAccessoryDurabilityTextX(), i, ColorUtils.hexstringToInt( WynnMiata.CONFIG.getAccessoryDurabilityTextColor()), true);
                    }
                        case 10 ->{
                                drawContext.drawTexture(ring, WynnMiata.CONFIG.getAccessoryDurabilityX(), WynnMiata.CONFIG.getArmorDurabilityY() + 20, 0, 0, 16, 16, 16, 16);
                        if (!WynnMiata.CONFIG.isAccessoryDurabilityOnly()) {
                            durability = "[" + durability + "/" + ItemUtils.getItemMaxDurability(MinecraftClient.getInstance().player.getInventory().getStack(slot));
                        }
                        drawContext.drawText(MinecraftClient.getInstance().textRenderer, durability,WynnMiata.CONFIG.getAccessoryDurabilityTextX(), i, ColorUtils.hexstringToInt( WynnMiata.CONFIG.getAccessoryDurabilityTextColor()), true);
                    }
                        case 11 -> {
                            drawContext.drawTexture(bracelet, WynnMiata.CONFIG.getAccessoryDurabilityX(), WynnMiata.CONFIG.getArmorDurabilityY() + 40, 0, 0, 16, 16, 16, 16);

                            if (!WynnMiata.CONFIG.isAccessoryDurabilityOnly()) {
                                durability = "[" + durability + "/" + ItemUtils.getItemMaxDurability(MinecraftClient.getInstance().player.getInventory().getStack(slot));
                            }
                            drawContext.drawText(MinecraftClient.getInstance().textRenderer, durability,WynnMiata.CONFIG.getAccessoryDurabilityTextX(), i, ColorUtils.hexstringToInt( WynnMiata.CONFIG.getAccessoryDurabilityTextColor()), true);
                        }
                        case 12 -> {
                                    drawContext.drawTexture(necklace, WynnMiata.CONFIG.getAccessoryDurabilityX(), WynnMiata.CONFIG.getArmorDurabilityY() + 60, 0, 0, 16, 16, 16, 16);

                                    if (!WynnMiata.CONFIG.isAccessoryDurabilityOnly()){
                                        durability = "[" + durability + "/" + ItemUtils.getItemMaxDurability(MinecraftClient.getInstance().player.getInventory().getStack(slot));
                                    }
                                    drawContext.drawText(MinecraftClient.getInstance().textRenderer, durability,WynnMiata.CONFIG.getAccessoryDurabilityTextX(), i, ColorUtils.hexstringToInt( WynnMiata.CONFIG.getAccessoryDurabilityTextColor()), true);
                            }
                    }
                    slot ++;
                }
                else {
                    if (!MinecraftClient.getInstance().player.getInventory().getStack(slot).isEmpty()){
                        switch (slot) {
                            case 9 ->
                                    drawContext.drawTexture(ring, WynnMiata.CONFIG.getAccessoryDurabilityX(), WynnMiata.CONFIG.getArmorDurabilityY(), 0, 0, 16, 16, 16, 16);
                            case 10 ->
                                    drawContext.drawTexture(ring, WynnMiata.CONFIG.getAccessoryDurabilityX(), WynnMiata.CONFIG.getArmorDurabilityY() + 20, 0, 0, 16, 16, 16, 16);
                            case 11 ->
                                    drawContext.drawTexture(bracelet, WynnMiata.CONFIG.getAccessoryDurabilityX(), WynnMiata.CONFIG.getArmorDurabilityY() + 40, 0, 0, 16, 16, 16, 16);
                            case 12 ->
                                    drawContext.drawTexture(necklace, WynnMiata.CONFIG.getAccessoryDurabilityX(), WynnMiata.CONFIG.getArmorDurabilityY() + 60, 0, 0, 16, 16, 16, 16);
                        }
                    }
                    slot++;
                }
            }
            slot = 9;
        }
    }
}
