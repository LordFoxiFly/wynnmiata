package de.lordfoxifly.Events.ScreenEvents;

import de.lordfoxifly.Features.Items.TradeMarket.TradeMarketMiddleClickSell;
import de.lordfoxifly.WynnMiata;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.ActionResult;

import java.util.ArrayList;
import java.util.List;

public class TriggerInventoryMouseClickEvent {

    public static ActionResult mouseClicked(double mouseX, double mouseY, int button, Slot clickedSlot, ScreenHandler screenHandler) {
        if (!WynnMiata.CONFIG.isTradeMarketMiddleClickSellBoolean()) return ActionResult.SUCCESS;
        List<ActionResult> actionResults = new ArrayList<>();
        actionResults.add(TradeMarketMiddleClickSell.mouseClicked(mouseX, mouseY, button, clickedSlot, screenHandler));
        if (actionResults.contains(ActionResult.FAIL)) {
            return ActionResult.FAIL;
        } else {
            return ActionResult.SUCCESS;
        }
    }
}
