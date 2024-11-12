package de.lordfoxifly.Features.Professions;

import de.lordfoxifly.Features.Items.ItemUtils;
import de.lordfoxifly.WynnMiata;
import de.lordfoxifly.WynnMiataUtils.ColorUtils;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ProfessionTrackingHud implements HudRenderCallback {

    private static String miningXP = "Last XP: ";
    private static String woodcuttingXP= "Last XP: ";
    private static String fishingXP =  "Last XP: ";
    private static boolean minesXPBonus = false;
    public static boolean isMinesXPBonus() {
        return minesXPBonus;
    }

    public static void setMinesXPBonus(boolean minesXPBonus) {
        ProfessionTrackingHud.minesXPBonus = minesXPBonus;
    }



    public static String getMiningXP() {
        return miningXP;
    }

    public static void setMiningXP(String miningXP) {
        ProfessionTrackingHud.miningXP = miningXP;
    }

    public static String getWoodcuttingXP() {
        return woodcuttingXP;
    }

    public static void setWoodcuttingXP(String woodcuttingXP) {
        ProfessionTrackingHud.woodcuttingXP = woodcuttingXP;
    }

    public static String getFishingXP() {
        return fishingXP;
    }

    public static void setFishingXP(String fishingXP) {
        ProfessionTrackingHud.fishingXP = fishingXP;
    }

    public static String getFarmingXP() {
        return farmingXP;
    }

    public static void setFarmingXP(String farmingXP) {
        ProfessionTrackingHud.farmingXP = farmingXP;
    }

    private static String farmingXP = "Last XP: ";


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
                int xpboost = ProfessionUtils.getArmorXPBonus();
                xpboost += ProfessionUtils.getAccsXPBonus();
                if (isMinesXPBonus()) xpboost += 50;
                xpboost += ProfessionUtils.getStatusEffectBuff();
                drawContext.drawText(MinecraftClient.getInstance().textRenderer, "Gathering XP Boost: " + xpboost ,WynnMiata.CONFIG.getProfessionHudTextX(), WynnMiata.CONFIG.getProfessionHudTextY() , ColorUtils.hexstringToInt(WynnMiata.CONFIG.getProfessionHudTextColor()), true  );
                String durability = getDurabilityString(ItemUtils.getItemDurability(MinecraftClient.getInstance().player.getMainHandStack()), ItemUtils.getItemMaxDurability(MinecraftClient.getInstance().player.getMainHandStack()));
                drawContext.drawText(MinecraftClient.getInstance().textRenderer, durability ,WynnMiata.CONFIG.getProfessionHudTextX(), WynnMiata.CONFIG.getProfessionHudTextY() +10 , ColorUtils.hexstringToInt(WynnMiata.CONFIG.getProfessionHudTextColor()), true  );
                drawContext.drawText(MinecraftClient.getInstance().textRenderer, "Gathering Speed: " + ProfessionUtils.getMiningSpeed(MinecraftClient.getInstance().player.getMainHandStack()) ,WynnMiata.CONFIG.getProfessionHudTextX(), WynnMiata.CONFIG.getProfessionHudTextY() + 20 , ColorUtils.hexstringToInt(WynnMiata.CONFIG.getProfessionHudTextColor()), true  );
                switch (ProfessionUtils.getGatheringToolType(MinecraftClient.getInstance().player.getMainHandStack()).toLowerCase()){
                    case "axe" -> drawContext.drawText(MinecraftClient.getInstance().textRenderer, woodcuttingXP ,WynnMiata.CONFIG.getProfessionHudTextX(), WynnMiata.CONFIG.getProfessionHudTextY() + 30 , ColorUtils.hexstringToInt(WynnMiata.CONFIG.getProfessionHudTextColor()), true  );
                    case "pickaxe" ->  drawContext.drawText(MinecraftClient.getInstance().textRenderer, miningXP ,WynnMiata.CONFIG.getProfessionHudTextX(), WynnMiata.CONFIG.getProfessionHudTextY() + 30 , ColorUtils.hexstringToInt(WynnMiata.CONFIG.getProfessionHudTextColor()), true  );
                    case "rod" ->      drawContext.drawText(MinecraftClient.getInstance().textRenderer, fishingXP ,WynnMiata.CONFIG.getProfessionHudTextX(), WynnMiata.CONFIG.getProfessionHudTextY() + 30 , ColorUtils.hexstringToInt(WynnMiata.CONFIG.getProfessionHudTextColor()), true  );
                    case "scythe" ->    drawContext.drawText(MinecraftClient.getInstance().textRenderer, farmingXP ,WynnMiata.CONFIG.getProfessionHudTextX(), WynnMiata.CONFIG.getProfessionHudTextY() + 30 , ColorUtils.hexstringToInt(WynnMiata.CONFIG.getProfessionHudTextColor()), true  );
                    default ->   drawContext.drawText(MinecraftClient.getInstance().textRenderer, "Last XP: " ,WynnMiata.CONFIG.getProfessionHudTextX(), WynnMiata.CONFIG.getProfessionHudTextY() + 30 , ColorUtils.hexstringToInt(WynnMiata.CONFIG.getProfessionHudTextColor()), true  );
                }
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
