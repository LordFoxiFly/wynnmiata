package de.lordfoxifly.Features.Professions;

import de.lordfoxifly.Features.Items.ItemUtils;
import de.lordfoxifly.WynnMiata;
import de.lordfoxifly.WynnMiataUtils.WynnMiataUtils;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProfessionUtils {

    public static Integer getMiningSpeed(ItemStack itemStack){
        if (itemStack.isEmpty()){
            return null;
        }
        Pattern pattern = Pattern.compile("Gathering Speed:\\s+(\\d+)\\s+\\((.+)\\)");
        Matcher matcher = pattern.matcher(ItemUtils.getItemLore(itemStack));
        String speed = null;
        if (matcher.find()){
            speed = matcher.group(1);
        }
        if (!WynnMiataUtils.isNumeric(speed)){
            return null;
        }
        return Integer.parseInt(speed);
    }
    public static Integer getProfXPBoost(ItemStack itemStack){
        if (itemStack.isEmpty()){
            return null;
        }
        Pattern pattern = Pattern.compile("\\+\\d+%\\/\\d+%\\ Gather XP Bonus");
        Matcher matcher = pattern.matcher(ItemUtils.getItemLore(itemStack));
        String xp = null;
        if (matcher.find()){
            xp = matcher.group().substring(0, matcher.group().indexOf("%"));
        }
        if (!WynnMiataUtils.isNumeric(xp)){
            return null;
        }
        return Integer.parseInt(xp);
    }

    public static Boolean isGatheringTool(ItemStack itemStack){
        if (itemStack.isEmpty()){
            return false;
        }
        Pattern pattern = Pattern.compile("Gathering\\s+(\\w+)\\s+T\\d+");
        Matcher matcher = pattern.matcher(ItemUtils.getItemLore(itemStack));
        if (matcher.find()){
            return true;
        }
        return false;
    }
    public static String getGatheringToolType(ItemStack itemStack){
        if (itemStack.isEmpty()){
            return null;
        }
        Pattern pattern = Pattern.compile("Gathering\\s+(\\w+)\\s+T\\d+");
        Matcher matcher = pattern.matcher(ItemUtils.getItemLore(itemStack));
        if (matcher.find()){
           return matcher.group(1);
        }
        return  null;
    }
    public static Integer getGatheringToolTier(ItemStack itemStack){
        if (itemStack.isEmpty()){
            return null;
        }
        Pattern pattern = Pattern.compile("Gathering\\s+(\\w+)\\s+T\\d+");
        Matcher matcher = pattern.matcher(ItemUtils.getItemLore(itemStack));
        if (matcher.find()){
            if (WynnMiataUtils.isNumeric(matcher.group().substring(matcher.group().indexOf("T") + 1))){
                return Integer.parseInt(matcher.group().substring(matcher.group().indexOf("T") +1));
            }

        }
        return null;
    }

}
