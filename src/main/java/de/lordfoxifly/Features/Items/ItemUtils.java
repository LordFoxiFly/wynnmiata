package de.lordfoxifly.Features.Items;

import de.lordfoxifly.WynnMiata;
import de.lordfoxifly.WynnMiataUtils.WynnMiataUtils;
import net.minecraft.client.MinecraftClient;
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
        return stringBuilder.substring(stringBuilder.indexOf("{"));
    }

    /**
     * Gets the Item Durability of a crafted Wynncraft Item
     * @param itemStack
     * @return
     */
    public static Integer getItemDurability(ItemStack itemStack){
        int durability = 0;
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
        durability = Integer.parseInt(dura);

        return durability;
    }

    /**
     * Gets the Max Item Durability of a crafted Item in Wynncraft
     * @param itemStack
     * @return
     */
    public static Integer getItemMaxDurability(ItemStack itemStack){
        int durability = 0;
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
        durability = Integer.parseInt(maxdurabilty);

        return durability;
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

}
