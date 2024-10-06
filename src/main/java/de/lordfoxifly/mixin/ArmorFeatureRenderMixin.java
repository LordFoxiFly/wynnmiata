package de.lordfoxifly.mixin;

import de.lordfoxifly.Screens.Widgets.CheckBoxs;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ArmorFeatureRenderer.class)
public class ArmorFeatureRenderMixin {



    @Inject(
            at = @At("HEAD"),
            method = "renderArmor",
            cancellable = true
    )
    public <T extends LivingEntity, A extends BipedEntityModel<T>> void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, T entity, EquipmentSlot armorSlot, int light, A model, CallbackInfo ci){
        if (CheckBoxs.isArmorRenderingBoolean() && entity instanceof PlayerEntity){
            ci.cancel();
        }
    }

}
