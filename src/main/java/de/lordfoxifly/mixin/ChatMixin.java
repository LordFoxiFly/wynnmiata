package de.lordfoxifly.mixin;

import de.lordfoxifly.Events.ChatMessageEvent;
import de.lordfoxifly.WynnMiata;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChatHud.class)
public class ChatMixin {
    //You received inspiration to gather from the plate...
    @Inject(method = "addMessage(Lnet/minecraft/text/Text;)V",
            at = @At("HEAD"))
    public void addToMessageHistory(Text message, CallbackInfo ci){
        ChatMessageEvent.EVENT.invoker().onMessage(message.getString());
    }
}
