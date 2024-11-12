package de.lordfoxifly.Packets;

import de.lordfoxifly.WynnMiata;
import it.unimi.dsi.fastutil.ints.Int2ObjectMaps;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.c2s.play.ClickSlotC2SPacket;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;

public class ItemPackets {

    public static void sendClickPacket(ScreenHandler screenHandler, int slot, int button, SlotActionType slotActionType, ItemStack itemStack) {
        if (MinecraftClient.getInstance().getNetworkHandler() != null) {
            MinecraftClient.getInstance().getNetworkHandler().sendPacket(
                    new ClickSlotC2SPacket(
                            screenHandler.syncId,
                            screenHandler.getRevision(),
                            slot,
                            button,
                            slotActionType,
                            itemStack,
                            Int2ObjectMaps.emptyMap()
                    )
            );
        }
    }

    public static void sendClickPacketItemStackSlot(ScreenHandler screenHandler,  int button, SlotActionType slotActionType, ItemStack itemStack) {
        if (MinecraftClient.getInstance().getNetworkHandler() != null) {
            MinecraftClient.getInstance().getNetworkHandler().sendPacket(
                    new ClickSlotC2SPacket(
                            screenHandler.syncId,
                            screenHandler.getRevision(),
                            screenHandler.getSlotIndex(MinecraftClient.getInstance().player.getInventory(), MinecraftClient.getInstance().player.getInventory().getSlotWithStack(itemStack)).getAsInt(),
                            button,
                            slotActionType,
                            itemStack,
                            Int2ObjectMaps.emptyMap()
                    )
            );
        }
    }
}
