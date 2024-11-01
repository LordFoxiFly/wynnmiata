package de.lordfoxifly.Features.Raids.RaidFeatures;

import de.lordfoxifly.Features.Raids.PartyUtils;
import de.lordfoxifly.Features.Raids.RaidPlayer;
import de.lordfoxifly.Features.Raids.types.RaidTypes;
import de.lordfoxifly.WynnMiata;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.text.Text;

import java.util.List;

public class CompletionsHud implements HudRenderCallback {

    private static   List<RaidPlayer> party;
    private static RaidTypes raidTypes;

    private static boolean createnew = true;

    /**
     * @param drawContext the {@link DrawContext} instance
     * @param tickCounter the {@link RenderTickCounter} instance
     */
    @Override
    public void onHudRender(DrawContext drawContext, RenderTickCounter tickCounter) {
        int y = 0;
        if (WynnMiata.CONFIG == null) {
            return;
        }
        if (WynnMiata.raidInstance == null){
            return;
        }
        if (createnew && WynnMiata.raidInstance.getRaidChallange() == 1 && WynnMiata.CONFIG.isShowPlayerRaidsBoolean()){
            party = null;
            party = PartyUtils.getParty();
            raidTypes = WynnMiata.raidInstance.getRaidType().getEnumRaidType();
            createnew = false;
            WynnMiata.LOGGER.info("Test 1 comp");
        }
        if (WynnMiata.raidInstance.getRaidChallange() == 4 || WynnMiata.raidInstance.isRaidCompleted()){
            createnew = true;
        }
        if (WynnMiata.CONFIG.isShowPlayerRaidsBoolean() && WynnMiata.raidInstance.getRaidChallange() >= 1 && WynnMiata.raidInstance.getRaidChallange() < 4){
            drawContext.drawText(MinecraftClient.getInstance().textRenderer, Text.literal("Raid: "+ raidTypes.name()), 20, 150, 0x00FF00, true);
            for (RaidPlayer raidPlayer: party){
               if (!party.isEmpty()){
                   if (raidPlayer.getPlayer() == null || raidPlayer.getPlayer().getGlobalData() == null){
                       drawContext.drawText(MinecraftClient.getInstance().textRenderer, Text.literal(raidPlayer.getName() + ": Error Data was null"), 20, 170 + y, 0x00FF00, true);
                       y += 15;
                   }
                   else {
                       if (raidTypes == RaidTypes.TCC){
                           drawContext.drawText(MinecraftClient.getInstance().textRenderer, Text.literal(raidPlayer.getName() + ": " +raidPlayer.getPlayer().getGlobalData().getRaids().getList().getTheCanyonColossus() ), 20, 170 + y, 0x00FF00, true);
                       }
                       if (raidTypes == RaidTypes.NOG){
                           drawContext.drawText(MinecraftClient.getInstance().textRenderer, Text.literal(raidPlayer.getName() + ": " +raidPlayer.getPlayer().getGlobalData().getRaids().getList().getNestOfTheGrootslangs()), 20, 170 + y, 0x00FF00, true);
                       }
                       if (raidTypes == RaidTypes.NOL){
                           drawContext.drawText(MinecraftClient.getInstance().textRenderer, Text.literal(raidPlayer.getName() + ": " +raidPlayer.getPlayer().getGlobalData().getRaids().getList().getOrphionSNexusOfLight()), 20, 170 + y, 0x00FF00, true);
                       }
                       if (raidTypes == RaidTypes.TNA){
                           drawContext.drawText(MinecraftClient.getInstance().textRenderer, Text.literal(raidPlayer.getName() + ": " +raidPlayer.getPlayer().getGlobalData().getRaids().getList().getTheNamelessAnomaly() ), 20, 170 + y, 0x00FF00, true);
                       }
                       y += 15;
                   }
               }
            }


        }

    }

    private void renderPlayerCompletions(DrawContext context, int defaultx,int defaulty,RaidTypes raidTypes){
        int y = defaulty;


    }
}
