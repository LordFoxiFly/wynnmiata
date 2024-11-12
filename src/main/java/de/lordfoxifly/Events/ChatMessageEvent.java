package de.lordfoxifly.Events;

import net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.text.Text;

import java.util.function.BiConsumer;

public interface ChatMessageEvent {

    Event<ChatMessageEvent> EVENT = EventFactory.createArrayBacked(ChatMessageEvent.class, callbacks -> message -> {
        for (ChatMessageEvent callback : callbacks) {
            callback.onMessage(message);
        }});


    void onMessage(String message);


}