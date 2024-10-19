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

    Event<BiConsumer<Text, Boolean>> BEFORE_MODIFY = WynnMiataEventUtils.biConsumer();
    static void register() {
        ClientReceiveMessageEvents.GAME.register(ChatMessageEvent::game);
        ClientReceiveMessageEvents.ALLOW_GAME.register((message, overlay) -> {
            BEFORE_MODIFY.invoker().accept(message, overlay);
            return true;
        });
    }

    /**
     * Listens to all messages sent by the server to the client.
     *
     * @param text The message that got send
     * @param b Just let it on false
     */
    static void game(Text text, boolean b) {
        if ( b){
            return;
        }
        final String string = text.getString();
        EVENT.invoker().onMessage(string);
    }


    void onMessage(String message);


}