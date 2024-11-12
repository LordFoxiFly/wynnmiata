package de.lordfoxifly.Events;

import de.lordfoxifly.Features.Professions.ProfessionTrackingHud;
import de.lordfoxifly.Features.StatusEffects.WynncraftStatusEffectListener;

public class ChatListener {
    //You are now level 32 in Ⓛ Alchemism
    //[+23 Spell Damage for 559 seconds]
    //&7[+8457 &fⓁ &7Alchemism XP] &6[100%]
    //[+4% Gather XP Bonus for 559 seconds]
    //Potion Effect Pattern
    // \[(.*? )(.*?)for (\d+) (\w+)]
    public static void register(){
        ChatMessageEvent.EVENT.register(message -> {
            if (message.contains("You received inspiration to gather from the plate...") || message.contains("You received +50% Gathering XP Bonus")){
                ProfessionTrackingHud.setMinesXPBonus(true);
            }
            if (message.contains("The inspiration to gather fades...")){
                ProfessionTrackingHud.setMinesXPBonus(false);
            }
            WynncraftStatusEffectListener.listen(message);
        });
    }

}
