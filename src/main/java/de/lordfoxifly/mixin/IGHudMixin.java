package de.lordfoxifly.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import de.lordfoxifly.Screens.Widgets.CheckBoxs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameOverlayRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(InGameOverlayRenderer.class)
public class IGHudMixin {

    @WrapMethod(
            method =  "renderFireOverlay"
    )
    private static void renderFire(MinecraftClient client, MatrixStack matrices, Operation<Void> original){
        if (CheckBoxs.isFireHudRenderingBoolean()) {
            return;
        }
        original.call(client, matrices);
    }


}
