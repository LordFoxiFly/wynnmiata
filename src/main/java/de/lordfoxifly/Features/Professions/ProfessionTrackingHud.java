package de.lordfoxifly.Features.Professions;

import de.lordfoxifly.Features.Items.ItemUtils;
import de.lordfoxifly.WynnMiata;
import de.lordfoxifly.WynnMiataUtils.ColorUtils;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import java.util.logging.Logger;

public class ProfessionTrackingHud implements HudRenderCallback {

    private static Integer miningXP = 0;
    private static Integer woodcuttingXP= 0;
    private static Integer fishingXP = 0;

    public static Integer getMiningXP() {
        return miningXP;
    }

    public static void setMiningXP(Integer miningXP) {
        ProfessionTrackingHud.miningXP = miningXP;
    }

    public static Integer getWoodcuttingXP() {
        return woodcuttingXP;
    }

    public static void setWoodcuttingXP(Integer woodcuttingXP) {
        ProfessionTrackingHud.woodcuttingXP = woodcuttingXP;
    }

    public static Integer getFishingXP() {
        return fishingXP;
    }

    public static void setFishingXP(Integer fishingXP) {
        ProfessionTrackingHud.fishingXP = fishingXP;
    }

    public static Integer getFarmingXP() {
        return farmingXP;
    }

    public static void setFarmingXP(Integer farmingXP) {
        ProfessionTrackingHud.farmingXP = farmingXP;
    }

    private static Integer farmingXP = 0;
    /**
     * @param drawContext the {@link DrawContext} instance
     * @param tickCounter the {@link RenderTickCounter} instance
     */
    @Override
    public void onHudRender(DrawContext drawContext, RenderTickCounter tickCounter) {
        if (!MinecraftClient.getInstance().player.getMainHandStack().isEmpty() &&  WynnMiata.CONFIG.isRenderHudElements()){
            if (ProfessionUtils.isGatheringTool(MinecraftClient.getInstance().player.getMainHandStack()) && WynnMiata.CONFIG.isProfessionHudBoolean()){
                Identifier identifier = getGatherToolIdentifier(MinecraftClient.getInstance().player.getMainHandStack());
                if (identifier != null){
                    drawContext.drawTexture(identifier, WynnMiata.CONFIG.getProfessionHudX(),WynnMiata.CONFIG.getProfessionHudY(), 0 , 0 , 32, 32, 32, 32);
                }
                int xpboost = ItemUtils.getArmorBonus();
                xpboost += ItemUtils.getAccsBonus();
                drawContext.drawText(MinecraftClient.getInstance().textRenderer, "Gathering XP Boost: " + xpboost ,WynnMiata.CONFIG.getProfessionHudTextX(), WynnMiata.CONFIG.getProfessionHudTextY() , ColorUtils.hexstringToInt(WynnMiata.CONFIG.getProfessionHudTextColor()), true  );
                String durability = getDurabilityString(ItemUtils.getItemDurability(MinecraftClient.getInstance().player.getMainHandStack()), ItemUtils.getItemMaxDurability(MinecraftClient.getInstance().player.getMainHandStack()));
                drawContext.drawText(MinecraftClient.getInstance().textRenderer, durability ,WynnMiata.CONFIG.getProfessionHudTextX(), WynnMiata.CONFIG.getProfessionHudTextY() +10 , ColorUtils.hexstringToInt(WynnMiata.CONFIG.getProfessionHudTextColor()), true  );
                drawContext.drawText(MinecraftClient.getInstance().textRenderer, "Gathering Speed: " + ProfessionUtils.getMiningSpeed(MinecraftClient.getInstance().player.getMainHandStack()) ,WynnMiata.CONFIG.getProfessionHudTextX(), WynnMiata.CONFIG.getProfessionHudTextY() + 20 , ColorUtils.hexstringToInt(WynnMiata.CONFIG.getProfessionHudTextColor()), true  );

            }
        }
    }

    private Identifier getGatherToolIdentifier(ItemStack itemStack){
        if (itemStack.isEmpty()){
            return null;
        }
        String path;
        switch (ProfessionUtils.getGatheringToolTier(itemStack)){
            case 1,2,3 -> path = "textures/gui/wynncrafttexture/gathertools/" + ProfessionUtils.getGatheringToolType(itemStack).toLowerCase()  + "_wood.png";
            case 4,5,6 -> path = "textures/gui/wynncrafttexture/gathertools/" + ProfessionUtils.getGatheringToolType(itemStack).toLowerCase()  + "_stone.png";
            case 7,8 -> path = "textures/gui/wynncrafttexture/gathertools/" + ProfessionUtils.getGatheringToolType(itemStack).toLowerCase()  + "_gold.png";
            case 9,10 -> path = "textures/gui/wynncrafttexture/gathertools/" + ProfessionUtils.getGatheringToolType(itemStack).toLowerCase()  + "_iron.png";
            case 11, 12, 13 -> path = "textures/gui/wynncrafttexture/gathertools/" + ProfessionUtils.getGatheringToolType(itemStack).toLowerCase()  + "_diamond.png";
            case null, default -> path = "textures/gui/wynncrafttexture/gathertools/scythe_wood.png";
        }
        return Identifier.of(WynnMiata.MOD_ID, path);
    }

    private String getDurabilityString(int durability, int maxdurability){
        int durabiltyperc = Math.round((float) maxdurability / 3);
        if ( durability > (2 * durabiltyperc)){
            return "Durability: §2" + durability;
        }
        if (durability > durabiltyperc){
            return "Durability: §e" + durability;
        }
        if (durability < durabiltyperc){
            return "Durability: §4" + durability;
        }
        return null;
    }
}
