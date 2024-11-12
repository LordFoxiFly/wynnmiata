package de.lordfoxifly.Events;

import de.lordfoxifly.Features.StatusEffects.WynncraftStatusEffect;
import de.lordfoxifly.Features.StatusEffects.WynncraftStatusEffectListener;
import de.lordfoxifly.Features.StatusEffects.WynncraftStatusEffectUtils;
import de.lordfoxifly.WynnMiata;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class TickTimer {
    private static int secondTick = 0;
    public static void register(){
        ClientTickEvents.END_CLIENT_TICK.register( client -> {
                secondTick++;
                if (secondTick >= 20) {
                    WynnMiata.LOGGER.info("1sec has passed");
                    if (!WynncraftStatusEffectListener.activeWynncraftStatusEffects.isEmpty()) {
                        WynnMiata.LOGGER.info("test 3 comp");
                        new Thread(WynncraftStatusEffectUtils::updateTime).start();
                    }
                    secondTick = 0;
                }
        });
    }

}
