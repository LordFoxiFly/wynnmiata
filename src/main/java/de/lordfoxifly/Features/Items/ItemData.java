package de.lordfoxifly.Features.Items;

import net.minecraft.client.MinecraftClient;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.component.type.NbtComponent;
import org.jetbrains.annotations.NotNull;


public class ItemData {

    public static final ItemStack MAIN_HAND = MinecraftClient.getInstance().player.getMainHandStack();
    public static final ItemStack OFF_HAND = MinecraftClient.getInstance().player.getOffHandStack();

    public static ItemStack getMainHand(){
        return MAIN_HAND;
    }
    public static ItemStack getOffHand(){
        return OFF_HAND;
    }

    @NotNull
    public static Value<NbtCompound> WynncraftTag(ItemStack itemStack) {
        return () -> itemStack.getComponentChanges()
                .get(DataComponentTypes.CUSTOM_DATA)
                .map(NbtComponent::copyNbt)
                .orElse(null);
    }

}
