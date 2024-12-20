package de.lordfoxifly.Features.Professions;

import de.lordfoxifly.Features.Items.ItemUtils;
import de.lordfoxifly.Features.StatusEffects.WynncraftStatusEffect;
import de.lordfoxifly.Features.StatusEffects.WynncraftStatusEffectListener;
import de.lordfoxifly.Features.StatusEffects.WynncraftStatusEffectTypes;
import de.lordfoxifly.WynnMiataUtils.WynnMiataUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.EquipmentSlot;
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
        Pattern pattern = Pattern.compile("(.\\d+?%)\\/(\\d+?%) Gather XP Bonus");
        Matcher matcher = pattern.matcher(ItemUtils.getItemLore(itemStack));
        String xp = null;
        if (matcher.find()){
            xp = matcher.group(1).substring(0, matcher.group().indexOf("%"));
                    //.substring(0, matcher.group().indexOf("%"));
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
        String lore = ItemUtils.getItemLore(itemStack);
        if (lore == null){
            return false;
        }
        Matcher matcher = pattern.matcher(lore);
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

    public static int getAccsXPBonus() {
        int output = 0;
        for (int i = 9; i < 13; i++){
            if (!MinecraftClient.getInstance().player.getInventory().getStack(i).isEmpty() &&  ItemUtils.getItemLore(MinecraftClient.getInstance().player.getInventory().getStack(i)) != null) {
                if (ProfessionUtils.getProfXPBoost(MinecraftClient.getInstance().player.getInventory().getStack(i)) != null) {
                    output += ProfessionUtils.getProfXPBoost(MinecraftClient.getInstance().player.getInventory().getStack(i));
                }
            }
        }
        return output;
    }

    public static int getArmorXPBonus(){
        int ouput = 0;
        ClientPlayerEntity clientPlayer = MinecraftClient.getInstance().player;
        if (!clientPlayer.getEquippedStack(EquipmentSlot.HEAD).isEmpty()){
            if (ProfessionUtils.getProfXPBoost(clientPlayer.getEquippedStack(EquipmentSlot.HEAD)) != null){
                int xp = ProfessionUtils.getProfXPBoost(clientPlayer.getEquippedStack(EquipmentSlot.HEAD));
                if (xp != 0){
                    ouput += xp;
                }
            }

        }
        if (!clientPlayer.getEquippedStack(EquipmentSlot.CHEST).isEmpty()){
            if (ProfessionUtils.getProfXPBoost(clientPlayer.getEquippedStack(EquipmentSlot.CHEST)) != null) {
                int xp = ProfessionUtils.getProfXPBoost(clientPlayer.getEquippedStack(EquipmentSlot.CHEST));
                if (xp != 0){
                    ouput += xp;
                }
            }

        }
        if (!clientPlayer.getEquippedStack(EquipmentSlot.LEGS).isEmpty()){
            if (ProfessionUtils.getProfXPBoost(clientPlayer.getEquippedStack(EquipmentSlot.LEGS)) != null){
                int xp = ProfessionUtils.getProfXPBoost(clientPlayer.getEquippedStack(EquipmentSlot.LEGS));
                if (xp != 0){
                    ouput += xp;
                }
            }

        }
        if (!clientPlayer.getEquippedStack(EquipmentSlot.FEET).isEmpty()){
            if (ProfessionUtils.getProfXPBoost(clientPlayer.getEquippedStack(EquipmentSlot.FEET)) != null){
                int xp = ProfessionUtils.getProfXPBoost(clientPlayer.getEquippedStack(EquipmentSlot.FEET));
                if (xp != 0){
                    ouput += xp;
                }
            }
        }
        return ouput;
    }
    public static int getStatusEffectBuff(){
        if (WynncraftStatusEffectListener.activeWynncraftStatusEffects.isEmpty()){
            return 0;
        }
        for (WynncraftStatusEffect statusEffect : WynncraftStatusEffectListener.activeWynncraftStatusEffects){
            if (statusEffect.getEffectTyp() == WynncraftStatusEffectTypes.GatherXPBonus){
                return statusEffect.getEffect();
            }
        }
        return  0;
    }



}
