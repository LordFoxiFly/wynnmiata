package de.lordfoxifly.Features.Items;

import de.lordfoxifly.WynnMiata;
import de.lordfoxifly.WynnMiataUtils.ColorUtils;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;

public class ArmorDurabilityHud implements HudRenderCallback {

    private static final Identifier DIAMOND_BOOTS = Identifier.of(WynnMiata.MOD_ID, "textures/gui/minecraft/diamond_boots.png");
    private static final Identifier DIAMOND_LEGGINGS = Identifier.of(WynnMiata.MOD_ID, "textures/gui/minecraft/diamond_leggings.png");
    private static final Identifier DIAMOND_CHESTPLATE = Identifier.of(WynnMiata.MOD_ID, "textures/gui/minecraft/diamond_chestplate.png");
    private static final Identifier DIAMOND_HELMET = Identifier.of(WynnMiata.MOD_ID, "textures/gui/minecraft/diamond_helmet.png");
    private static final Identifier EMPTY_BOOTS = Identifier.of(WynnMiata.MOD_ID, "textures/gui/minecraft/empty_armor_slot_boots.png");
    private static final Identifier EMPTY_LEGGINGS = Identifier.of(WynnMiata.MOD_ID, "textures/gui/minecraft/empty_armor_slot_leggings.png");
    private static final Identifier EMPTY_CHESTPLATE = Identifier.of(WynnMiata.MOD_ID, "textures/gui/minecraft/empty_armor_slot_chestplate.png");
    private static final Identifier EMPTY_HELMET = Identifier.of(WynnMiata.MOD_ID, "textures/gui/minecraft/empty_armor_slot_helmet.png");
    /**
     * @param drawContext the {@link DrawContext} instance
     * @param tickCounter the {@link RenderTickCounter} instance
     */
    @Override
    public void onHudRender(DrawContext drawContext, RenderTickCounter tickCounter) {
        //TODO: Needs to be cleaned up
        if (WynnMiata.CONFIG.isArmorDurabilityBoolean() && WynnMiata.CONFIG.isRenderHudElements()){
            if (MinecraftClient.getInstance().player.getEquippedStack(EquipmentSlot.HEAD).isEmpty()){
                drawContext.drawTexture(EMPTY_HELMET, WynnMiata.CONFIG.getArmorDurabilityX() , WynnMiata.CONFIG.getArmorDurabilityY(), 0, 0, 16, 16, 16, 16);

            }
            else{
                drawContext.drawTexture(DIAMOND_HELMET, WynnMiata.CONFIG.getArmorDurabilityX(), WynnMiata.CONFIG.getArmorDurabilityY(), 0, 0, 16, 16, 16, 16);
                if (ItemUtils.hasItemDurability(MinecraftClient.getInstance().player.getEquippedStack(EquipmentSlot.HEAD))){
                    if (!WynnMiata.CONFIG.isArmorDurabilityOnlyBoolean()){
                        drawContext.drawText(MinecraftClient.getInstance().textRenderer, "[" + ItemUtils.getItemDurability(MinecraftClient.getInstance().player.getEquippedStack(EquipmentSlot.HEAD)) + "/" +ItemUtils.getItemMaxDurability(MinecraftClient.getInstance().player.getEquippedStack(EquipmentSlot.HEAD))  + "]",  WynnMiata.CONFIG.getArmorDurabilityTextX() , WynnMiata.CONFIG.getArmorDurabilityTextY(), ColorUtils.hexstringToInt(WynnMiata.CONFIG.getArmorDurabilityTextColor()),
                                true);
                    }
                    else {
                        drawContext.drawText(MinecraftClient.getInstance().textRenderer, String.valueOf( ItemUtils.getItemDurability(MinecraftClient.getInstance().player.getEquippedStack(EquipmentSlot.HEAD))) ,  WynnMiata.CONFIG.getArmorDurabilityTextX() , WynnMiata.CONFIG.getArmorDurabilityTextY(), ColorUtils.hexstringToInt(WynnMiata.CONFIG.getArmorDurabilityTextColor()),
                                true);
                    }
                }
            }
            if (MinecraftClient.getInstance().player.getEquippedStack(EquipmentSlot.CHEST).isEmpty()){
                drawContext.drawTexture(EMPTY_CHESTPLATE, WynnMiata.CONFIG.getArmorDurabilityX() , WynnMiata.CONFIG.getArmorDurabilityY() +20, 0, 0, 16, 16, 16, 16);
            }
            else{
                drawContext.drawTexture(DIAMOND_CHESTPLATE, WynnMiata.CONFIG.getArmorDurabilityX() , WynnMiata.CONFIG.getArmorDurabilityY() + 20, 0, 0, 16, 16, 16, 16);
                if (ItemUtils.hasItemDurability(MinecraftClient.getInstance().player.getEquippedStack(EquipmentSlot.CHEST))){
                    if (!WynnMiata.CONFIG.isArmorDurabilityOnlyBoolean()){
                        drawContext.drawText(MinecraftClient.getInstance().textRenderer, "[" + ItemUtils.getItemDurability(MinecraftClient.getInstance().player.getEquippedStack(EquipmentSlot.CHEST)) + "/" +ItemUtils.getItemMaxDurability(MinecraftClient.getInstance().player.getEquippedStack(EquipmentSlot.CHEST))  + "]",  WynnMiata.CONFIG.getArmorDurabilityTextX() , WynnMiata.CONFIG.getArmorDurabilityTextY() + 20, ColorUtils.hexstringToInt(WynnMiata.CONFIG.getArmorDurabilityTextColor()),
                                true);
                    }
                    else {
                        drawContext.drawText(MinecraftClient.getInstance().textRenderer, String.valueOf( ItemUtils.getItemDurability(MinecraftClient.getInstance().player.getEquippedStack(EquipmentSlot.CHEST))) ,  WynnMiata.CONFIG.getArmorDurabilityTextX() , WynnMiata.CONFIG.getArmorDurabilityTextY() + 20, ColorUtils.hexstringToInt(WynnMiata.CONFIG.getArmorDurabilityTextColor()),
                                true);
                    }
                }
            }
            if (MinecraftClient.getInstance().player.getEquippedStack(EquipmentSlot.LEGS).isEmpty()){
                drawContext.drawTexture(EMPTY_LEGGINGS, WynnMiata.CONFIG.getArmorDurabilityX() , WynnMiata.CONFIG.getArmorDurabilityY() + 40, 0, 0, 16, 16, 16, 16);
            }
            else{
                drawContext.drawTexture(DIAMOND_LEGGINGS, WynnMiata.CONFIG.getArmorDurabilityX() , WynnMiata.CONFIG.getArmorDurabilityY() + 40, 0, 0, 16, 16, 16, 16);
                if (ItemUtils.hasItemDurability(MinecraftClient.getInstance().player.getEquippedStack(EquipmentSlot.LEGS))){
                    if (!WynnMiata.CONFIG.isArmorDurabilityOnlyBoolean()){
                        drawContext.drawText(MinecraftClient.getInstance().textRenderer, "[" + ItemUtils.getItemDurability(MinecraftClient.getInstance().player.getEquippedStack(EquipmentSlot.LEGS)) + "/" +ItemUtils.getItemMaxDurability(MinecraftClient.getInstance().player.getEquippedStack(EquipmentSlot.LEGS))  + "]",  WynnMiata.CONFIG.getArmorDurabilityTextX() , WynnMiata.CONFIG.getArmorDurabilityTextY() + 40, ColorUtils.hexstringToInt(WynnMiata.CONFIG.getArmorDurabilityTextColor()),
                                true);
                    }
                    else {
                        drawContext.drawText(MinecraftClient.getInstance().textRenderer,  String.valueOf(ItemUtils.getItemDurability(MinecraftClient.getInstance().player.getEquippedStack(EquipmentSlot.LEGS))) ,  WynnMiata.CONFIG.getArmorDurabilityTextX() , WynnMiata.CONFIG.getArmorDurabilityTextY() + 40, ColorUtils.hexstringToInt(WynnMiata.CONFIG.getArmorDurabilityTextColor()),
                                true);
                    }
                }}

            if (MinecraftClient.getInstance().player.getEquippedStack(EquipmentSlot.FEET).isEmpty()){
                drawContext.drawTexture(EMPTY_BOOTS, WynnMiata.CONFIG.getArmorDurabilityX() , WynnMiata.CONFIG.getArmorDurabilityY() + 60, 0, 0, 16, 16, 16, 16);
            }
            else{
                drawContext.drawTexture(DIAMOND_BOOTS, WynnMiata.CONFIG.getArmorDurabilityX() , WynnMiata.CONFIG.getArmorDurabilityY() + 60, 0, 0, 16, 16, 16, 16);
                if (ItemUtils.hasItemDurability(MinecraftClient.getInstance().player.getEquippedStack(EquipmentSlot.FEET))){
                    if (!WynnMiata.CONFIG.isArmorDurabilityOnlyBoolean()){
                        drawContext.drawText(MinecraftClient.getInstance().textRenderer, "[" + ItemUtils.getItemDurability(MinecraftClient.getInstance().player.getEquippedStack(EquipmentSlot.FEET)) + "/" +ItemUtils.getItemMaxDurability(MinecraftClient.getInstance().player.getEquippedStack(EquipmentSlot.FEET))  + "]", WynnMiata.CONFIG.getArmorDurabilityTextX() , WynnMiata.CONFIG.getArmorDurabilityTextY() + 60, ColorUtils.hexstringToInt(WynnMiata.CONFIG.getArmorDurabilityTextColor()),
                                true);
                    }
                    else {
                        drawContext.drawText(MinecraftClient.getInstance().textRenderer, String.valueOf(ItemUtils.getItemDurability(MinecraftClient.getInstance().player.getEquippedStack(EquipmentSlot.FEET))), WynnMiata.CONFIG.getArmorDurabilityTextX() , WynnMiata.CONFIG.getArmorDurabilityTextY() + 60, ColorUtils.hexstringToInt(WynnMiata.CONFIG.getArmorDurabilityTextColor()),
                                true);
                    }
                }
            }
        }
    }




}
