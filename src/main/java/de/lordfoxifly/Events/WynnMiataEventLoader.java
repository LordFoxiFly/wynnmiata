package de.lordfoxifly.Events;

import de.lordfoxifly.Debug.Screen.DebugHud;
import de.lordfoxifly.Features.Items.ArmorDurability;
import de.lordfoxifly.Features.Raids.RaidFeatures.CompletionsHud;
import de.lordfoxifly.Features.Raids.RaidUtils.RaidInstanceUtils;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

public abstract class WynnMiataEventLoader {

    public static void load(){
        ChatMessageEvent.register();
        ScoreboardListener.load();
        RaidInstanceUtils.loadTCCFeatures();
        HudRenderCallback.EVENT.register(new DebugHud());
        HudRenderCallback.EVENT.register(new CompletionsHud());
        HudRenderCallback.EVENT.register(new ArmorDurability());
    }
}
