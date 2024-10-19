package de.lordfoxifly.mixin;

import de.lordfoxifly.Screens.Widgets.CheckBoxs;
import de.lordfoxifly.WynnMiata;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.HeadFeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HeadFeatureRenderer.class)
public class HeadNotRenderMixin {

    @Inject(
            at = @At("HEAD"),
            method ="render(Lnet/minecraft/client/util/math/MatrixStack;" +
                    "Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/entity/LivingEntity;FFFFFF)V",
            cancellable = true
    )
    @SuppressWarnings("MissingJavadoc")
    public <T extends LivingEntity> void render(final MatrixStack matrixStack, final VertexConsumerProvider vertexConsumerProvider, final int i, final T livingEntity, final float f, final float g, final float h, final float j, final float k, final float l, final CallbackInfo ci) {
        if (WynnMiata.CONFIG.isHeadRenderingBoolean() && livingEntity.hasStackEquipped(EquipmentSlot.HEAD) && livingEntity instanceof PlayerEntity) {
            ci.cancel();
        }

    }
}
