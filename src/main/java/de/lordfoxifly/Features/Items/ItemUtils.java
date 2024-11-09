package de.lordfoxifly.Features.Items;

import de.lordfoxifly.Features.Professions.ProfessionUtils;
import de.lordfoxifly.WynnMiata;
import de.lordfoxifly.WynnMiataUtils.WynnMiataUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemUtils {
    /**
     * Gets the Lore of a Wynncraft Item
     * @param itemStack
     * @return
     */
    public static String getItemLore(ItemStack itemStack){
        StringBuilder stringBuilder =  new StringBuilder();
        Value<NbtCompound> value = ItemData.WynncraftTag(itemStack);
        for (String key : value.get().getKeys()){
            if (value.get().get(key) == null) {
                continue;
            }
            stringBuilder.append(Formatting.strip(Objects.requireNonNull(value.get().get(key)).asString()));
        }
        String output = null;
        if (stringBuilder.indexOf("{") != -1){
            output = stringBuilder.substring(stringBuilder.indexOf("{"));
        }
        return output;
    }

    /**
     * Gets the Item Durability of a crafted Wynncraft Item
     * @param itemStack
     * @return
     */
    public static Integer getItemDurability(ItemStack itemStack){
        String lore  = getItemLore(itemStack);
        String dura = null;
        if (lore == null) {
            return null;
        }
        Pattern durabilityPattern = Pattern.compile("\\[\\d+/\\d+\\ Durability\\]");
        Matcher matcher = durabilityPattern.matcher(lore);
        if (matcher.find()){
            dura= matcher.group().substring(matcher.group().indexOf("[") + 1 , matcher.group().indexOf("/"));
        }
        if (!WynnMiataUtils.isNumeric(dura)){
            return  null;
        }
        return Integer.parseInt(dura);
    }

    /**
     * Gets the Max Item Durability of a crafted Item in Wynncraft
     * @param itemStack
     * @return
     */
    public static Integer getItemMaxDurability(ItemStack itemStack){
        String lore  = getItemLore(itemStack);
        String maxdurabilty = null;
        if (lore == null) {
            return null;
        }
        Pattern durabilityPattern = Pattern.compile("\\[\\d+/\\d+\\ Durability\\]");
        Matcher matcher = durabilityPattern.matcher(lore);
        if (matcher.find()){
            maxdurabilty = matcher.group().substring(matcher.group().indexOf("/") +1, matcher.group().indexOf(" "));
        }
        if (!WynnMiataUtils.isNumeric(maxdurabilty)){
            return  null;
        }

        return Integer.parseInt(maxdurabilty);
    }

    /**
     * Checks if a ItemStack has durability
     * @param itemStack
     * @return
     */
    public static boolean hasItemDurability(ItemStack itemStack){
        boolean hasDurability = false;
        String lore = getItemLore(itemStack);
        Pattern durabilityPattern = Pattern.compile("\\[\\d+/\\d+\\ Durability\\]");
        Matcher matcher = durabilityPattern.matcher(lore);
        if (matcher.find()){
            hasDurability = true;
        }
        return hasDurability;
    }

    //Pattern pattern
    public static int getArmorBonus(){
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

    public static int getPieceBonus(Pattern pattern, ItemStack itemStack){
        int output = 0;
        if (itemStack.isEmpty()){
            return output;
        }
        Matcher matcher = pattern.matcher(getItemLore(itemStack));
        if (matcher.find()){
            if (WynnMiataUtils.isNumeric(matcher.group(1)) && matcher.group(1) != null){
                return Integer.parseInt(matcher.group(1));
            }
        }
        return output;
    }

    public static int getAccsBonus() {
        int output = 0;
        for (int i = 9; i < 13; i++){
            if (!MinecraftClient.getInstance().player.getInventory().getStack(i).isEmpty() &&  hasItemDurability(MinecraftClient.getInstance().player.getInventory().getStack(i))) {
                output += ProfessionUtils.getProfXPBoost(MinecraftClient.getInstance().player.getInventory().getStack(i));
            }
        }
        return output;
    }
}
