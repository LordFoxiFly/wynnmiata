package de.lordfoxifly.mixin;

import de.lordfoxifly.Events.DisplayTextUpdateEvent;
import de.lordfoxifly.Events.ScoreboardUpdateEvent;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.DisplayEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.decoration.DisplayEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DisplayEntityRenderer.TextDisplayEntityRenderer.class)
public class DisplayTextMixin {

    @Inject(
            at = @At("HEAD"),
            method = "render(Lnet/minecraft/entity/decoration/DisplayEntity$TextDisplayEntity;Lnet/minecraft/entity/decoration/DisplayEntity$TextDisplayEntity$Data;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IF)V"
    )
    public void onRender(DisplayEntity.TextDisplayEntity textDisplayEntity, DisplayEntity.TextDisplayEntity.Data data, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, float f, CallbackInfo ci){
        DisplayTextUpdateEvent.EVENT.invoker().update(data.text().getString(), textDisplayEntity.getPos());
    }
}
