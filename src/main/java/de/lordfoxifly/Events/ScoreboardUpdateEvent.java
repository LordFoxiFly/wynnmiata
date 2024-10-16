package de.lordfoxifly.Events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.scoreboard.ScoreHolder;
import net.minecraft.scoreboard.Scoreboard;

import java.util.List;

public interface ScoreboardUpdateEvent {

    Event<ScoreboardUpdateEvent> EVENT = EventFactory.createArrayBacked(ScoreboardUpdateEvent.class, events -> (content) -> {
        for (ScoreboardUpdateEvent event : events) {
            event.update( content);
        }
    });


    /**
     *
     * @param content New Value of the Line
     */
    void update(String content);
}