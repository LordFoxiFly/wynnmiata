package de.lordfoxifly.Events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.ActionResult;

public interface InventoryMouseClickCallback {

    Event<InventoryMouseClickCallback> EVENT = EventFactory.createArrayBacked(InventoryMouseClickCallback.class,
            (listeners) -> (mouseX, mouseY, button, clickedSlot, screenHandler) -> {
                for (InventoryMouseClickCallback listener : listeners) {
                    ActionResult result = listener.mouseClicked(mouseX, mouseY, button, clickedSlot, screenHandler);

                    if(result != ActionResult.PASS) {
                        return result;
                    }
                }

                return ActionResult.PASS;
            });

    ActionResult mouseClicked(double mouseX, double mouseY, int button, Slot clickedSlot, ScreenHandler screenHandler);
}

