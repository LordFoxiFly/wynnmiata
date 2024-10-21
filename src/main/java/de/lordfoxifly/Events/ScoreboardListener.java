package de.lordfoxifly.Events;

import de.lordfoxifly.Debug.DebugCommands;
import de.lordfoxifly.Debug.Devutils;
import de.lordfoxifly.Features.Raids.RaidInstance;
import de.lordfoxifly.Features.Raids.RaidPhase;
import de.lordfoxifly.Features.Raids.RaidType;
import de.lordfoxifly.Features.Raids.RaidUtils.RaidInstanceUtils;
import de.lordfoxifly.Features.Raids.types.RaidTypes;
import de.lordfoxifly.WynnMiata;

import java.util.Objects;

public class ScoreboardListener {

    public static void load(){
        if (WynnMiata.CONFIG.isDebugRaidsBoolean()){
            Devutils.appendToFile("Scoreboard Loaded", "wynnmiatadevlog.txt");
        }
        ScoreboardUpdateEvent.EVENT.register(content ->{
            if (WynnMiata.raidInstance == null || WynnMiata.raidInstance.isRaidCompleted()){
                RaidInstance raidInstance = createRaidInstance(content);
                if (raidInstance == null){
                    return;
                }
                if (WynnMiata.CONFIG.isDebugRaidsBoolean()){
                    Devutils.appendToFile("RaidInstance created: " + content, "wynnmiatadevlog.txt");
                }
                WynnMiata.raidInstance = raidInstance;

            }
            else {
                 RaidPhase raidPhase = RaidInstanceUtils.getRaidPhaseTCC(content, WynnMiata.raidInstance.getRaidChallange());
            if ( raidPhase != null && WynnMiata.raidInstance.getRaidPhase() != raidPhase ){
                if (WynnMiata.CONFIG.isDebugRaidsBoolean()){
                    Devutils.appendToFile("Phase changed to : " + raidPhase, "wynnmiatadevlog.txt");
                }
                if (!Objects.equals(WynnMiata.raidInstance.getRaidChallange(), RaidInstanceUtils.getRaidChallange(raidPhase)) && RaidInstanceUtils.getRaidChallange(raidPhase) != 7){
                    WynnMiata.raidInstance.setRaidChallange(RaidInstanceUtils.getRaidChallange(raidPhase));
                    Devutils.appendToFile("RaidChallange changed to : " + RaidInstanceUtils.getRaidChallange(raidPhase), "wynnmiatadevlog.txt");
                    if (WynnMiata.raidInstance.getRaidChallange() == 4){
                        WynnMiata.raidInstance.setRaidCompleted(true);
                        if (WynnMiata.CONFIG.isDebugRaidsBoolean()){
                            Devutils.appendToFile("Raid Instance got marked as completed" , "wynnmiatadevlog.txt");
                        }
                    }
                }
                WynnMiata.raidInstance.setRaidPhase(raidPhase);
                }
            }
        });
    }



    public static RaidInstance createRaidInstance(String content){

        RaidTypes raidType = RaidInstanceUtils.getRaidPType(content);
        if (raidType == null){
            return null;
        }
        if (WynnMiata.CONFIG.isDebugRaidsBoolean()){
            Devutils.appendToFile("Instance Creation " + raidType, "wynnmiatadevlog.txt");
        }
        return RaidInstance.createInstance(new RaidType(raidType));
    }
}
