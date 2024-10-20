package de.lordfoxifly.Events;

import de.lordfoxifly.Features.Raids.RaidUtils.RaidInstanceUtils;

public abstract class WynnMiataEventLoader {

    public static void load(){
        ChatMessageEvent.register();
        ScoreboardListener.load();
        RaidInstanceUtils.loadTCCFeatures();
    }
}
