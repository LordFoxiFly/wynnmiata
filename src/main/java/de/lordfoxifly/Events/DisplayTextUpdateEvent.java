package de.lordfoxifly.Events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.util.math.Vec3d;

public interface DisplayTextUpdateEvent {

    Event<DisplayTextUpdateEvent> EVENT = EventFactory.createArrayBacked(DisplayTextUpdateEvent.class, events -> (content, pos) -> {
        for (DisplayTextUpdateEvent event : events) {
            event.update(content, pos);
        }
    });


    void update(String content, Vec3d pos);
}
