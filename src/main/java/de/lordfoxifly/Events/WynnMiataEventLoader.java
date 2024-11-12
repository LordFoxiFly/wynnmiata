package de.lordfoxifly.Events;

import de.lordfoxifly.Debug.Screen.DebugHud;
import de.lordfoxifly.Events.ScreenEvents.TriggerInventoryMouseClickEvent;
import de.lordfoxifly.Features.Items.AccessoryDurabilityHud;
import de.lordfoxifly.Features.Items.ArmorDurabilityHud;
import de.lordfoxifly.Features.Professions.ProfessionTrackingHud;
import de.lordfoxifly.Features.Raids.RaidFeatures.CompletionsHud;
import de.lordfoxifly.Features.Raids.RaidUtils.RaidInstanceUtils;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

public abstract class WynnMiataEventLoader {

    public static void load(){
        ChatListener.register();
        ScoreboardListener.load();
        RaidInstanceUtils.loadTCCFeatures();
        TickTimer.register();
        DisplayTextUpdateListener.onDisplayUpdate();
        HudRenderCallback.EVENT.register(new DebugHud());
        HudRenderCallback.EVENT.register(new CompletionsHud());
        HudRenderCallback.EVENT.register(new ArmorDurabilityHud());
        HudRenderCallback.EVENT.register(new AccessoryDurabilityHud());
        HudRenderCallback.EVENT.register(new ProfessionTrackingHud());
        InventoryMouseClickCallback.EVENT.register(TriggerInventoryMouseClickEvent::mouseClicked);
    }
}
