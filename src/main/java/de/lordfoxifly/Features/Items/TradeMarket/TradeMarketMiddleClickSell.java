package de.lordfoxifly.Features.Items.TradeMarket;

import de.lordfoxifly.Packets.ItemPackets;
import de.lordfoxifly.WynnMiata;
import de.lordfoxifly.WynnMiataUtils.WynnMiataUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.ActionResult;

import java.util.logging.Logger;

public class TradeMarketMiddleClickSell {
    private static boolean executing = false;
    public static ActionResult mouseClicked(double mouseX, double mouseY, int button, Slot clickedSlot, ScreenHandler screenHandler) {
        WynnMiata.LOGGER.info(MinecraftClient.getInstance().currentScreen.getTitle().getString());
        if (MinecraftClient.getInstance().player == null || MinecraftClient.getInstance().currentScreen == null ||
                !MinecraftClient.getInstance().currentScreen.getTitle().getString().equals("\uDAFF\uDFE8\uE011") ||
                MinecraftClient.getInstance().getNetworkHandler() == null ||
                button != 2 || clickedSlot == null) {
            return ActionResult.SUCCESS;
        }
        String name = WynnMiataUtils.getUnformattedString(clickedSlot.getStack().getName().getString());
        if (name.equals("Air")) return ActionResult.SUCCESS;

        ItemStack sellItem = screenHandler.slots.get(45).getStack();
        WynnMiata.LOGGER.info(sellItem.getName().getString());
        if (!sellItem.getName().getString().contains("Sell an Item") || executing) return ActionResult.SUCCESS;
        executing = true;

        new Thread(() -> {
            ItemPackets.sendClickPacket(
                    screenHandler,
                    45,
                    0,
                    SlotActionType.PICKUP,
                    sellItem
            );

            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            WynnMiata.LOGGER.info(String.valueOf(clickedSlot.getIndex()));
            ItemStack clickedSlotStack = clickedSlot.getStack();
            ItemPackets.sendClickPacketItemStackSlot(
                    MinecraftClient.getInstance().player.currentScreenHandler,
                    0,
                    SlotActionType.PICKUP,
                    clickedSlotStack
            );

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            executing = false;
        }).start();

        // Cancels the regular middle click if everything was successfull
        return ActionResult.FAIL;
    }
}
