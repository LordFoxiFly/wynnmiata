package de.lordfoxifly.Features.Professions;

import de.lordfoxifly.Debug.Devutils;
import de.lordfoxifly.WynnMiata;
import de.lordfoxifly.WynnMiataUtils.TimedSet;
import de.lordfoxifly.WynnMiataUtils.WynnMiataUtils;
import net.minecraft.util.math.Vec3d;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProfessionTracking {
    //§7x1 §7[+§7336§f Ⓙ§7 Farming§7 XP] §6[21.8%]
    private static final Pattern PROFESSION_NODE_EXPERIENCE_PATTERN = Pattern.compile(
            "(§.x\\d) (§.)?(.+?§.)(\\d+)(.*? )+[ⓀⒸⒷⒿⒺⒹⓁⒶⒼⒻⒾⒽ]+§. (.+? )XP] §..(.*?%)]");

    private static final Pattern PROFESSION_NODE_HARVEST_PATTERN =
            Pattern.compile("§a\\+\\d+§2 (?<type>.+) (?<material>.+)§6 \\[§e✫((?:§8)?✫(?:§8)?)✫§6\\]");

    private final static TimedSet<Vec3d> gatheredNodes = new TimedSet<>(10, TimeUnit.SECONDS, true);

    /**
     * Updates the PlayerProfessionUpdate()
     * @param context
     */
    public static void updateProfProgress(String context, Vec3d nodepos){
        Matcher matcher = PROFESSION_NODE_EXPERIENCE_PATTERN.matcher(context);
        if (matcher.find()){
            if (gatheredNodes.stream().anyMatch(position ->WynnMiataUtils.isSame(position, nodepos))) {
                // We already recorded this XP gain, ignore it.
                return;
            }
            gatheredNodes.put(nodepos);
            updateProf(matcher.group(6).substring(0, matcher.group(6).indexOf("§")), matcher.group(4), matcher.group(7));
        }
    }

    private static void updateProf(String profName, String profXP, String profPercentage){
        if (profXP == null || profName == null || profPercentage == null){
            return;
        }
        if (!WynnMiataUtils.isNumeric(profXP)){
            return;
        }
        String defaultXPString = "Last Xp: §e+";
        switch (profName){
            case "Farming" -> ProfessionTrackingHud.setFarmingXP( defaultXPString + profXP + " §r|§e" + profPercentage+ "§r]");
            case "Woodcutting" -> ProfessionTrackingHud.setWoodcuttingXP( defaultXPString + profXP + " §r|§e" + profPercentage+ "§r]");
            case "Mining" -> ProfessionTrackingHud.setMiningXP( defaultXPString + profXP + " §r|§e " + profPercentage+ "§r]");
            case "Fishing" -> ProfessionTrackingHud.setFishingXP( defaultXPString + profXP + " §r|§e" + profPercentage+ "§r]");
        }
    }
}
