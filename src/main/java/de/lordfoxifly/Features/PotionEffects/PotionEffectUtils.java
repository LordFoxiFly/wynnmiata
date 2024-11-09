package de.lordfoxifly.Features.PotionEffects;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.entry.RegistryEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PotionEffectUtils {

    public static List<String> getPotionEffectNames(){
        List<String> output = new ArrayList<>();
        for (Map.Entry<RegistryEntry<StatusEffect>, StatusEffectInstance> entry : MinecraftClient.getInstance().player.getActiveStatusEffects().entrySet()){
            output.add(entry.getValue().getEffectType().getIdAsString());
        }
        return output;
    }

}
