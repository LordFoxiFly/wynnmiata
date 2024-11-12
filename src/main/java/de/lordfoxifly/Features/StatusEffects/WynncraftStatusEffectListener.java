package de.lordfoxifly.Features.StatusEffects;

import de.lordfoxifly.WynnMiata;
import de.lordfoxifly.WynnMiataUtils.WynnMiataUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WynncraftStatusEffectListener {
    public static List<WynncraftStatusEffect> activeWynncraftStatusEffects = new ArrayList<>();
    private static  final  Pattern potionPattern = Pattern.compile("\\[(.*? )(.*?)for (\\d+) (\\w+)]");
    public static void listen(String message) {
        Matcher matcher = potionPattern.matcher(message);
        if (matcher.find()){
            WynnMiata.LOGGER.info(matcher.group(2).replace( " ", ""));
            if (WynncraftStatusEffectUtils.getWynncraftStatusEffectType(matcher.group(2).replace(" ","")) == null){
                return;
            }
            WynnMiata.LOGGER.info("First Test passed");
            WynnMiata.LOGGER.info(matcher.group(3).replace(" ", ""));
            if (!WynnMiataUtils.isNumeric(matcher.group(3).replace(" ", ""))){
                return;
            }
            WynncraftStatusEffect wynncraftStatusEffect = new WynncraftStatusEffect(Integer.parseInt(matcher.group(3).replace(" ", "")), getEffectValue(matcher.group(1)) ,WynncraftStatusEffectUtils.getWynncraftStatusEffectType(matcher.group(2).replace(" ","")), hasPercentage(matcher.group(1)));
            WynnMiata.LOGGER.info("2nd Test passed");
            activeWynncraftStatusEffects.add(wynncraftStatusEffect);
            WynnMiata.LOGGER.info("StatusEffect  Added");
        }
    }

    public static  int getEffectValue(String string){
        if (hasPercentage(string)){
            String eff = string.replace(" ", "");
            return Integer.parseInt(eff.substring(0, string.indexOf("%")));
        }
        return Integer.parseInt(string);
    }
    public static boolean hasPercentage(String string){
        return  string.contains("%");
    }
}
