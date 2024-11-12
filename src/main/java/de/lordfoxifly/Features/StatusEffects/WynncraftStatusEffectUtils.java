package de.lordfoxifly.Features.StatusEffects;

import de.lordfoxifly.WynnMiata;
import org.jetbrains.annotations.Nullable;

public class WynncraftStatusEffectUtils {

    /**
     * Gets the WynncraftSatusEffectType from a String
     * @param msg
     * @return Nullable.
     */

    public static WynncraftStatusEffectTypes getWynncraftStatusEffectType(String msg ){
        for (WynncraftStatusEffectTypes effectType : WynncraftStatusEffectTypes.values()){
            WynnMiata.LOGGER.info(effectType.name());
            if (effectType.name().contains(msg)){
                return effectType;
            }
        }
        return null;
    }

    public static void updateTime() {
        for (WynncraftStatusEffect statusEffect:  WynncraftStatusEffectListener.activeWynncraftStatusEffects){
            if (statusEffect.getDuration() <= 0){
                WynnMiata.LOGGER.info(statusEffect.getEffectTyp().name() + " was removed");
                WynncraftStatusEffectListener.activeWynncraftStatusEffects.remove(statusEffect);
                continue;
            }
            statusEffect.setDuration(statusEffect.getDuration() - 1);
            WynnMiata.LOGGER.info( statusEffect.getEffectTyp().name() + ": " + statusEffect.getDuration());
        }
    }
}
