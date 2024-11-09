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
            "(§.x[\\d\\.]+ )?(§.)?\\[\\+(§d)?(?<gain>\\d+)§f [ⓀⒸⒷⒿⒺⒹⓁⒶⒼⒻⒾⒽ]§7 (?<name>.+) XP\\] §6\\[(?<current>[\\d.]+)%\\]");

    private static final Pattern PROFESSION_NODE_HARVEST_PATTERN =
            Pattern.compile("§a\\+\\d+§2 (?<type>.+) (?<material>.+)§6 \\[§e✫((?:§8)?✫(?:§8)?)✫§6\\]");

    private final TimedSet<Vec3d> gatheredNodes = new TimedSet<>(10, TimeUnit.SECONDS, true);

    /**
     * Updates the PlayerProfessionUpdate()
     * @param context
     */
    public static void updateProfProgress(String context){
        Matcher matcher = PROFESSION_NODE_EXPERIENCE_PATTERN.matcher(context);
        if (matcher.find()){
            WynnMiata.LOGGER.info("Test");
            Devutils.appendToFile(matcher.group(), "wynnmiatadevlog.txt");
        }
    }

    private void updateProf(String profName, String profXP){
        if (profXP == null || profName == null){
            return;
        }
        if (!WynnMiataUtils.isNumeric(profXP)){
            return;
        }
        switch (profName){

        }
    }
}
