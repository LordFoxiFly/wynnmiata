package de.lordfoxifly.Events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;

import java.util.function.BiConsumer;

public interface WynnMiataEventUtils {

    static <T, V> Event<BiConsumer<T, V>> biConsumer() {
        return EventFactory.createArrayBacked(BiConsumer.class, biConsumers -> (a, b) -> {
            for (BiConsumer<T, V> consumer : biConsumers) {
                consumer.accept(a, b);
            }
        });
    }
}
