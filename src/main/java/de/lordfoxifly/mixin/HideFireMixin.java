package de.lordfoxifly.mixin;

import de.lordfoxifly.Screens.Widgets.CheckBoxs;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import org.joml.Quaternionf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityRenderDispatcher.class)
public class HideFireMixin {

     @Inject(
             at = @At("HEAD"),
             method = "renderFire",
             cancellable = true
     )
    public void renderFire(MatrixStack matrices, VertexConsumerProvider vertexConsumers, Entity entity, Quaternionf rotation, CallbackInfo ci){
        if (CheckBoxs.isFireEntityRenderingBoolean()){
            ci.cancel();
        }
     }
}
